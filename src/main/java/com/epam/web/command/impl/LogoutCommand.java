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

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession(false);
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        if (session != null) {
            session.invalidate();
        }
        return CommandResult.redirect(contextPath + LOGIN_PAGE);
    }
}
