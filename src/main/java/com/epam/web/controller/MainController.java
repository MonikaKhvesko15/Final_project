package com.epam.web.controller;

import com.epam.web.command.factory.Command;
import com.epam.web.command.factory.CommandFactory;
import com.epam.web.command.CommandResult;
import com.epam.web.connection.ConnectionPool;
import com.epam.web.controller.content.RequestContent;
import com.epam.web.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(MainController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String commandName = request.getParameter("command");
            Command command = CommandFactory.create(commandName);
            CommandResult commandResult = command.execute(request, response);
            dispatch(request, response, commandResult);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            request.setAttribute("errorMessage", e.getMessage());
            dispatch(request, response, CommandResult.redirect("/WEB-INF/views/error.jsp"));
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, CommandResult commandResult) throws IOException, ServletException {
        boolean isRedirect = commandResult.isRedirect();
        if (isRedirect) {
            response.sendRedirect(commandResult.getPage());
        } else {
            request.getRequestDispatcher(commandResult.getPage()).forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool.getInstance().destroyPool();
    }
}
