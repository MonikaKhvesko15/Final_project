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
    private final UserService service;

    public EditUserCommand() {
        service = new UserService();
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        service.updateUser(user);

        String currentPage = getCurrentPage(request, session);
        return CommandResult.redirect(currentPage);
    }

    private String getCurrentPage(HttpServletRequest request, HttpSession session) {
        return (String) session.getAttribute(request.getRequestURI());
    }
}
