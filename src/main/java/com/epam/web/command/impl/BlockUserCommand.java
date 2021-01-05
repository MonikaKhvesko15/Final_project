package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.user.UserService;
import com.epam.web.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BlockUserCommand implements Command {
    private final UserService service;


    public BlockUserCommand() {
        this.service = new UserServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String userIdString = request.getParameter("userId");
            Integer userId = Integer.parseInt(userIdString);

            service.blockUserById(userId);

            CommandResult commandResult = null;
            String roleString = request.getParameter("userRole");
            User.Role role = User.Role.valueOf(roleString);

            if (role == User.Role.READER) {
                commandResult = CommandResult.redirect("/Final_project_war/controller?command=view_readers");
            } else if (role == User.Role.LIBRARIAN) {
                commandResult = CommandResult.redirect("/Final_project_war/controller?command=view_librarians");
            }
            return commandResult;
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
