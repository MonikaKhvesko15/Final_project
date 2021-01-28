package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exception.FieldValidatorException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.user.UserService;
import com.epam.web.service.user.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class RegistrationCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);
    private static final String REGISTRATION_PAGE = "/controller?command=registration_page";
    private static final String WITH_MESSAGE_INVALID_DATA = "&message=invalidData";
    private static final String WITH_MESSAGE_PASSWORD_MISMATCH = "&message=passwordMismatch";
    private static final String WITH_MESSAGE_USER_EXISTS = "&message=suchUserExists";
    private static final String MESSAGE_PAGE = "/controller?command=message_page&message=userAdded";
    private static final String REPEAT_PASSWORD = "repeat_password";
    private final UserService userService;


    public RegistrationCommand() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        CommandResult commandResult = null;
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();

        String firstname = request.getParameter(User.FIRSTNAME);
        String surname = request.getParameter(User.SURNAME);
        String roleString = request.getParameter(User.ROLE);
        Role role = Role.valueOf(roleString.toUpperCase());
        String login = request.getParameter(User.LOGIN);
        String password = request.getParameter(User.PASSWORD);
        String repeatPassword = request.getParameter(REPEAT_PASSWORD);

        if (!password.equals(repeatPassword)) {
            commandResult = CommandResult.redirect(contextPath + REGISTRATION_PAGE + WITH_MESSAGE_PASSWORD_MISMATCH);
        } else {
            User user = new User(null, login, password, firstname, surname, role, false);
            try {
                userService.registerUser(user);
                commandResult = CommandResult.redirect(contextPath + MESSAGE_PAGE);

            } catch (FieldValidatorException e) {
                LOGGER.error("Incorrect data entered");
                commandResult = CommandResult.redirect(contextPath + REGISTRATION_PAGE + WITH_MESSAGE_INVALID_DATA);
            } catch (ServiceException e) {
                commandResult = CommandResult.redirect(contextPath + REGISTRATION_PAGE + WITH_MESSAGE_USER_EXISTS);
            }
        }
        return commandResult;
    }
}
