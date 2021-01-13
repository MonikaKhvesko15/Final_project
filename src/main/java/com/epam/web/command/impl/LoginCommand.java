package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.user.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
    private static final String USER_ID_ATTRIBUTE = "userId";
    private static final String USER_ATTRIBUTE = "user";
    private static final String ROLE_ATTRIBUTE = "role";

    private static final String LOGIN_PAGE = "WEB-INF/views/login.jsp";
    private static final String HOME_PAGE = "/controller?command=home_page";
    private static final String ERROR_JSP = "WEB-INF/views/error.jsp";
    private static final String USER_BLOCK_ERROR_MESSAGE = "userBlockErrorMessage";

    private final UserServiceImpl service;

    public LoginCommand() {
        service = new UserServiceImpl();
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
                session.setAttribute(USER_ID_ATTRIBUTE, user.getId().toString());
                session.setAttribute(LOGIN_PARAMETER, user.getLogin());
                session.setAttribute(USER_ATTRIBUTE, user);
                session.setAttribute(ROLE_ATTRIBUTE, user.getRole().toString());

                ServletContext servletContext = request.getServletContext();
                String contextPath = servletContext.getContextPath();

                commandResult = CommandResult.redirect(contextPath+HOME_PAGE);
            } else if (user.isBlocked()) {
                request.setAttribute(USER_BLOCK_ERROR_MESSAGE, true);
                commandResult = CommandResult.forward(ERROR_JSP);
            }

        } else {
            request.setAttribute(ERROR_MESSAGE_ATTRIBUTE, "Invalid credentials");
            commandResult = CommandResult.forward(LOGIN_PAGE);
        }
        return commandResult;
    }
}
