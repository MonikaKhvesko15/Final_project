package com.epam.web.controller;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.command.factory.CommandFactory;
import com.epam.web.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MainControllerTest {
    private static final String HOME_PAGE = "WEB-INF/views/home_page.jsp";

    @Test
    public void testMainController() throws  ServiceException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("command")).thenReturn("login");
        String commandName = request.getParameter("command");
        Command command = CommandFactory.create(commandName);

        Mockito.when(command.execute(request,response)).thenReturn(CommandResult.redirect(HOME_PAGE));
        CommandResult actual = command.execute(request,response);
        CommandResult expected = CommandResult.redirect(HOME_PAGE);

        Assert.assertEquals(expected,actual);
    }
}
