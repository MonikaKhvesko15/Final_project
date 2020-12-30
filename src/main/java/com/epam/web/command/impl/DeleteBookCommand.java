package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBookCommand implements Command {
    private final BookService service;
    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";


    public DeleteBookCommand() {
        service = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String bookIdString = request.getParameter("bookId");
            Integer bookId = Integer.parseInt(bookIdString);
            service.deleteBookById(bookId);
            request.setAttribute("bookDeleted", true);
            return CommandResult.forward(MESSAGE_JSP);
        } catch (ServiceException | DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
