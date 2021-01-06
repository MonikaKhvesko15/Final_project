package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.user.UserService;
import com.epam.web.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnblockUserCommand implements Command {
    private static final String USER_ID_PARAMETER = "userId";
    private static final String USER_ROLE_PARAMETER = "userRole";
    private static final String VIEW_READERS = "/Final_project_war/controller?command=view_readers";
    private static final String VIEW_LIBRARIANS = "/Final_project_war/controller?command=view_librarians";

    private final UserService service;

    public UnblockUserCommand() {
        this.service = new UserServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String userIdString = request.getParameter(USER_ID_PARAMETER);
            Integer userId = Integer.parseInt(userIdString);

            service.unblockUserById(userId);

            CommandResult commandResult = null;
            String roleString = request.getParameter(USER_ROLE_PARAMETER);
            User.Role role = User.Role.valueOf(roleString);

            if (role == User.Role.READER) {
                commandResult = CommandResult.redirect(VIEW_READERS);
            } else if (role == User.Role.LIBRARIAN) {
                commandResult = CommandResult.redirect(VIEW_LIBRARIANS);
            }
            return commandResult;
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
