package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EditUserCommand implements Command {
    public static final String FIRSTNAME_PARAMETER = "firstname";
    public static final String SURNAME_PARAMETER = "surname";
    private static final String HOME_PAGE = "/Final_project_war/controller?command=home_page";
    private final UserService service;

    public EditUserCommand() {
        service = new UserService();
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String userFirstname = request.getParameter(FIRSTNAME_PARAMETER);
        String userSurname = request.getParameter(SURNAME_PARAMETER);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setFirstname(userFirstname);
        user.setSurname(userSurname);
        service.updateUser(user);

        return CommandResult.redirect(HOME_PAGE);
    }

}
