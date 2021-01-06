package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private static final String LOGIN_PAGE = "/Final_project_war/controller?command=login_page";
    private static final String ID = "id";
    private static final String LOGIN = "login";
    private static final String USER = "user";
    private static final String ROLE = "role";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(ID);
            session.removeAttribute(LOGIN);
            session.removeAttribute(USER);
            session.removeAttribute(ROLE);

        }
        return CommandResult.redirect(LOGIN_PAGE);
    }
}
