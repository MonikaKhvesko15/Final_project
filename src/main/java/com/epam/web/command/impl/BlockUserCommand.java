package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.user.UserService;
import com.epam.web.service.user.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockUserCommand implements Command {
    private static final String USER_ID_PARAMETER = "userId";
    private static final String USER_ROLE_PARAMETER = "userRole";
    private static final String VIEW_READERS_PAGE = "/controller?command=view_readers";
    private static final String VIEW_LIBRARIANS_PAGE = "/controller?command=view_librarians";

    private final UserService service;

    public BlockUserCommand() {
        this.service = new UserServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String userIdString = request.getParameter(USER_ID_PARAMETER);
        Integer userId = Integer.parseInt(userIdString);

        service.blockUserById(userId);

        String roleString = request.getParameter(USER_ROLE_PARAMETER);
        Role role = Role.valueOf(roleString);

        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        CommandResult commandResult = null;
        if (role == Role.READER) {
            commandResult = CommandResult.redirect(contextPath + VIEW_READERS_PAGE);
        } else if (role == Role.LIBRARIAN) {
            commandResult = CommandResult.redirect(contextPath + VIEW_LIBRARIANS_PAGE);
        }
        return commandResult;
    }
}
