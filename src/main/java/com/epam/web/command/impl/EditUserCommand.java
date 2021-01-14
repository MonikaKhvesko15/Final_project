package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.FieldValidatorException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.user.UserService;
import com.epam.web.service.user.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EditUserCommand implements Command {
    private static final String FIRSTNAME_PARAMETER = "firstname";
    private static final String SURNAME_PARAMETER = "surname";
    private static final String HOME_PAGE = "/controller?command=home_page";
    private static final String USER_ATTRIBUTE = "user";
    private static final String HOME_PAGE_JSP = "WEB-INF/views/home_page.jsp";

    private final UserService service;

    public EditUserCommand() {

        service = new UserServiceImpl();
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, CloneNotSupportedException {
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
            request.setAttribute("invalidData", true);
            return CommandResult.forward(HOME_PAGE_JSP);
        }

    }

}
