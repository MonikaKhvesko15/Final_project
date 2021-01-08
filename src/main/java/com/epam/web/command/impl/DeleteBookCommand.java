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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBookCommand implements Command {
    private static final String BOOK_ID_PARAMETER = "bookId";
    private static final String BOOK_DELETED = "bookDeleted";
    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";
    public static final String IMPOSSIBLE_TO_DELETE = "impossibleToDelete";
    private static final String ERROR_JSP = "WEB-INF/views/error.jsp";

    private final BookService bookService;

    public DeleteBookCommand() {
        bookService = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            CommandResult commandResult = null;
            String bookIdString = request.getParameter(BOOK_ID_PARAMETER);
            Integer bookId = Integer.parseInt(bookIdString);

            boolean isBookDeleted = bookService.deleteBookById(bookId);
            if (isBookDeleted) {
                request.setAttribute(BOOK_DELETED, true);
                commandResult = CommandResult.forward(MESSAGE_JSP);
            } else {
                request.setAttribute(IMPOSSIBLE_TO_DELETE, true);
                commandResult = CommandResult.forward(ERROR_JSP);
            }
            return commandResult;
        } catch (ServiceException | DaoException e) {
            //forward to error.jsp?
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
