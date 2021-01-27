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
    private static final String REGISTRATION_PAGE = "WEB-INF/views/registration.jsp";
    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";
    private static final String REPEAT_PASSWORD = "repeat_password";
    private static final String INVALID_DATA_ATTRIBUTE = "invalidData";
    private static final String USER_ADDED_ATTRIBUTE = "userAdded";
    private final UserService userService;


    public RegistrationCommand() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        CommandResult commandResult = null;

        String firstname = request.getParameter(User.FIRSTNAME);
        String surname = request.getParameter(User.SURNAME);
        String roleString = request.getParameter(User.ROLE);
        Role role = Role.valueOf(roleString.toUpperCase());
        String login = request.getParameter(User.LOGIN);
        String password = request.getParameter(User.PASSWORD);
        String repeatPassword = request.getParameter(REPEAT_PASSWORD);

        if (!password.equals(repeatPassword)) {
            request.setAttribute(INVALID_DATA_ATTRIBUTE, "The passwords entered do not match");
            commandResult = CommandResult.forward(REGISTRATION_PAGE);
        } else {
            User user = new User(null, login, password, firstname, surname, role, false);
            try {
                userService.registerUser(user);
                request.setAttribute(USER_ADDED_ATTRIBUTE, true);
                commandResult = CommandResult.forward(MESSAGE_JSP);

            } catch (FieldValidatorException e) {
                LOGGER.error("Incorrect data entered");
                request.setAttribute(INVALID_DATA_ATTRIBUTE, "Enter correct data");
                commandResult = CommandResult.forward(REGISTRATION_PAGE);
            } catch (ServiceException e) {
                request.setAttribute(INVALID_DATA_ATTRIBUTE, "Such user already exists");
                commandResult = CommandResult.forward(REGISTRATION_PAGE);
            }
        }
        return commandResult;
    }
}
