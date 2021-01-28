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
    private static final String USER_ATTRIBUTE = "user";
    private static final String ROLE_ATTRIBUTE = "role";

    private static final String LOGIN_PAGE_WITH_MESSAGE = "/controller?command=login_page&message=errorMessage";
    private static final String HOME_PAGE = "/controller?command=home_page";
    private static final String ERROR_PAGE = "/controller?command=error_page&message=userBlockErrorMessage";

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

        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (!(user.isBlocked())) {
                HttpSession session = request.getSession();
                session.setAttribute(USER_ATTRIBUTE, user);
                session.setAttribute(ROLE_ATTRIBUTE, user.getRole().toString());

                commandResult = CommandResult.redirect(contextPath + HOME_PAGE);
            } else if (user.isBlocked()) {
                commandResult = CommandResult.redirect(contextPath + ERROR_PAGE);
            }

        } else {
            commandResult = CommandResult.redirect(contextPath + LOGIN_PAGE_WITH_MESSAGE);
        }
        return commandResult;
    }
}
