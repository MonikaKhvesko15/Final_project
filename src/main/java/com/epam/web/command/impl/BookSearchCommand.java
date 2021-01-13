package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Book;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class BookSearchCommand implements Command {

    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";
    private static final String TITLE_PARAMETER = "title";
    private static final String FOUND_BOOK_PARAMETER = "foundBook";
    private static final String BOOK_CATALOG_PAGE = "WEB-INF/views/book_catalog.jsp";
    private static final String IS_BOOK_PAGE = "isBookPage";
    private static final String BOOK_NOT_FOUND_MESSAGE = "bookNotFound";
    private static final String BOOK_DELETED_MESSAGE = "foundBookDeleted";

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
        if (title != null) {
            Optional<Book> foundBookOptional = service.findBookByTitle(title);
            if (foundBookOptional.isPresent()) {
                book = foundBookOptional.get();
                if (!book.isDeleted()) {
                    request.setAttribute(FOUND_BOOK_PARAMETER, book);
                    commandResult = CommandResult.forward(BOOK_CATALOG_PAGE);
                } else {
                    request.setAttribute(BOOK_DELETED_MESSAGE, true);
                    commandResult = CommandResult.forward(MESSAGE_JSP);
                }
            } else {
                request.setAttribute(BOOK_NOT_FOUND_MESSAGE, true);
                commandResult = CommandResult.forward(MESSAGE_JSP);
            }
        }
        return commandResult;
    }
}
