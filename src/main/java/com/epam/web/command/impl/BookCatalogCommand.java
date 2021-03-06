package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Book;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BookCatalogCommand implements Command {

    private static final String BOOKS_PARAMETER = "books";
    private static final int RECORDS_PER_PAGE = 5;
    private static final String BOOK_LIST_PARAMETER = "bookList";
    private static final String CURRENT_PAGE_PARAMETER = "currentPage";
    private static final int FIRST_PAGE = 1;
    private static final String BOOK_CATALOG_PAGE = "WEB-INF/views/book_catalog.jsp";
    private static final String IS_BOOK_PAGE = "isBookPage";

    private final BookService service;

    public BookCatalogCommand() {

        service = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        //for searching in header
        request.setAttribute(IS_BOOK_PAGE, true);

        int currentPage;
        CommandResult commandResult = null;

        if (request.getParameter(CURRENT_PAGE_PARAMETER) != null) {
            currentPage = Integer.parseInt(request.getParameter(CURRENT_PAGE_PARAMETER));
        } else {
            currentPage = FIRST_PAGE;
        }

        List<Book> bookList = service.getBooksPart((currentPage - 1) * RECORDS_PER_PAGE, RECORDS_PER_PAGE);
        request.setAttribute(BOOK_LIST_PARAMETER, bookList);
        request.setAttribute(CURRENT_PAGE_PARAMETER, currentPage);

        commandResult = CommandResult.forward(BOOK_CATALOG_PAGE);
        return commandResult;
    }
}
