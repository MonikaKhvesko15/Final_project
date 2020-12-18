package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";

    private static final String LOGIN_PAGE = "WEB-INF/views/login.jsp";
    private static final String HOME_PAGE = "/Final_project_war/controller?command=home_page";
    public static final String MESSAGE_PAGE = "/Final_project_war/controller?command=message_page";

    private final UserService service;

    public LoginCommand() {
        service = new UserService();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);

        CommandResult commandResult = null;
        Optional<User> userOptional = service.login(login, password);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (!(user.isBlocked())) {
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId().toString());
                session.setAttribute("login", user.getLogin());
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole().toString());
                commandResult = CommandResult.redirect(HOME_PAGE);
            } else if (user.isBlocked()) {
                request.setAttribute("errorMessage", "This user is blocked");
                commandResult = CommandResult.redirect(MESSAGE_PAGE);
            }

        } else {
            request.setAttribute(ERROR_MESSAGE_ATTRIBUTE, "Invalid credentials");
            commandResult = CommandResult.forward(LOGIN_PAGE);
        }
        return commandResult;
    }
}
