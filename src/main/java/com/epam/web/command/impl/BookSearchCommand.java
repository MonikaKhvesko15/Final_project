package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Book;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class BookSearchCommand implements Command {

    private static final String TITLE_PARAMETER = "title";
    private static final String FOUND_BOOK_PARAMETER = "foundBook";
    private static final String BOOK_CATALOG_PAGE = "WEB-INF/views/book_catalog.jsp";
    private static final String IS_BOOK_PAGE = "isBookPage";
    private static final String BOOK_NOT_FOUND_MESSAGE_JSP = "/controller?command=message_page&message=bookNotFound";

    private final BookService service;

    public BookSearchCommand() {
        this.service = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        //for searching in header
        request.setAttribute(IS_BOOK_PAGE, true);
        String title = request.getParameter(TITLE_PARAMETER);
        Book book = null;
        CommandResult commandResult = null;
        ServletContext servletContext = request.getServletContext();
        String contexPath = servletContext.getContextPath();
        if (title != null) {
            Optional<Book> foundBookOptional = service.findBookByTitle(title);
            if (foundBookOptional.isPresent()) {
                book = foundBookOptional.get();
                if (!book.isDeleted()) {
                    request.setAttribute(FOUND_BOOK_PARAMETER, book);
                    commandResult = CommandResult.forward(BOOK_CATALOG_PAGE);
                } else {
                    commandResult = CommandResult.redirect(contexPath + BOOK_NOT_FOUND_MESSAGE_JSP);
                }
            } else {
                commandResult = CommandResult.redirect(contexPath + BOOK_NOT_FOUND_MESSAGE_JSP);
            }
        }
        return commandResult;
    }
}
