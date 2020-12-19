package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EditUserCommand implements Command {
    private static final String FIRSTNAME_PARAMETER = "firstname";
    private static final String SURNAME_PARAMETER = "surname";
    private static final String HOME_PAGE = "/Final_project_war/controller?command=home_page";
    private final UserServiceImpl service;
    private static final String ERROR_JSP = "WEB-INF/views/error.jsp";

    public EditUserCommand() {

        service = new UserServiceImpl();
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String userFirstname = request.getParameter(FIRSTNAME_PARAMETER);
            String userSurname = request.getParameter(SURNAME_PARAMETER);

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            user.setFirstname(userFirstname);
            user.setSurname(userSurname);
            service.updateUser(user);

            return CommandResult.redirect(HOME_PAGE);
        } catch (ServiceException e) {
            request.setAttribute("editUserErrorMessage", true);
            return CommandResult.forward(ERROR_JSP);
        }
    }

}
