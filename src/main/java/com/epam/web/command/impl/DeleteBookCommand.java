package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Order;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;
import com.epam.web.service.order.OrderService;
import com.epam.web.service.order.OrderServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBookCommand implements Command {
    private static final String BOOK_ID_PARAMETER = "bookId";
    private static final String BOOK_DELETED_MESSAGE_JSP = "/controller?command=message_page&message=bookDeleted";

    private final BookService bookService;

    public DeleteBookCommand() {
        bookService = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        CommandResult commandResult = null;
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        String bookIdString = request.getParameter(BOOK_ID_PARAMETER);
        Integer bookId = Integer.parseInt(bookIdString);

        bookService.deleteBookById(bookId);
        commandResult = CommandResult.redirect(contextPath + BOOK_DELETED_MESSAGE_JSP);

        return commandResult;
    }
}
