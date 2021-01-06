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
    private static final String BOOK_ID_PARAMETER = "bookId";
    private static final String BOOK_DELETED = "bookDeleted";
    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";

    private final BookService service;

    public DeleteBookCommand() {
        service = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String bookIdString = request.getParameter(BOOK_ID_PARAMETER);
            Integer bookId = Integer.parseInt(bookIdString);

            service.deleteBookById(bookId);

            request.setAttribute(BOOK_DELETED, true);
            return CommandResult.forward(MESSAGE_JSP);
        } catch (ServiceException | DaoException e) {
            //forward to error.jsp?
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
