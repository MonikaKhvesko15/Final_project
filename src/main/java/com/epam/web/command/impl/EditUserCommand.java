package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
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


public class EditUserCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(EditUserCommand.class);
    private static final String FIRSTNAME_PARAMETER = "firstname";
    private static final String SURNAME_PARAMETER = "surname";
    private static final String HOME_PAGE = "/controller?command=home_page";
    private static final String USER_ATTRIBUTE = "user";
    private static final String HOME_PAGE_WITH_MESSAGE = "/controller?command=home_page&message=invalidData";
    private static final String USER_DUOLICATION_MESSAGE_JSP = "/controller?command=message_page&message=userDataDuplication";

    private final UserService service;

    public EditUserCommand() {

        service = new UserServiceImpl();
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String userFirstname = request.getParameter(FIRSTNAME_PARAMETER);
        String userSurname = request.getParameter(SURNAME_PARAMETER);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        User testUser = user.clone();
        testUser.setFirstname(userFirstname);
        testUser.setSurname(userSurname);

        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        try {
            service.editUser(testUser);
            user.setFirstname(userFirstname);
            user.setSurname(userSurname);
            return CommandResult.redirect(contextPath + HOME_PAGE);
        } catch (FieldValidatorException e) {
            LOGGER.error("Incorrect data entered");
            return CommandResult.redirect(contextPath + HOME_PAGE_WITH_MESSAGE);
        } catch (ServiceException e) {
            return CommandResult.redirect(contextPath + USER_DUOLICATION_MESSAGE_JSP);
        }
    }

}
