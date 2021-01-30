package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.exception.ServiceException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private static final String LOGIN_PAGE = "/controller?command=login_page";
    private static final String USER = "user";
    private static final String ROLE = "role";
    private static final String ID = "id";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession(false);
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        if (session != null) {
            session.removeAttribute(USER);
            session.removeAttribute(ROLE);
            session.removeAttribute(ID);
        }
        return CommandResult.redirect(contextPath + LOGIN_PAGE);
    }
}
