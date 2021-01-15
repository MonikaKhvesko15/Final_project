package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Book;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditBookPageCommand implements Command {

    private static final String BOOK_ID_PARAMETER = "bookId";
    private static final String EDIT_BOOK = "editBook";
    private static final String EDIT_BOOK_PAGE_JSP = "WEB-INF/views/edit_book_page.jsp";

    private final BookService service;

    public EditBookPageCommand() {
        this.service = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String bookIdString = request.getParameter(BOOK_ID_PARAMETER);
        Integer bookId = Integer.parseInt(bookIdString);

        Book book = service.getBookById(bookId).get();
        request.setAttribute(EDIT_BOOK, book);
        return CommandResult.forward(EDIT_BOOK_PAGE_JSP);
    }
}
