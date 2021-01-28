package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Book;
import com.epam.web.entity.Publisher;
import com.epam.web.exception.FieldValidatorException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;
import com.epam.web.service.publisher.PublisherService;
import com.epam.web.service.publisher.PublisherServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveBookCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SaveBookCommand.class);
    private static final String PUBLISHER_NAME_PARAMETER = "publisherName";
    private static final String BOOK_ID_PARAMETER = "bookId";
    private static final String TITLE_PARAMETER = "title";
    private static final String AUTHOR_PARAMETER = "author";
    private static final String PAGES_PARAMETER = "pages";
    private static final String AMOUNT_PARAMETER = "amount";

    private static final String MESSAGE_PAGE = "/controller?command=message_page";
    private static final String WITH_MESSAGE_BOOK_DUPLICATION = "&message=bookDuplication";
    private static final String WITH_MESSAGE_BOOK_ADDED = "&message=bookAdded";
    private static final String WITH_MESSAGE_BOOK_EDITED = "&message=bookEdited";

    private final BookService bookService;
    private final PublisherService publisherService;

    public SaveBookCommand() {
        this.bookService = new BookServiceImpl();
        this.publisherService = new PublisherServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String publisherName = request.getParameter(PUBLISHER_NAME_PARAMETER);
        Publisher publisher = publisherService.getPublisherByName(publisherName).get();

        String idString = request.getParameter(BOOK_ID_PARAMETER);
        Integer id = idString.isEmpty() ? null : Integer.parseInt(idString);

        String title = request.getParameter(TITLE_PARAMETER);
        String author = request.getParameter(AUTHOR_PARAMETER);

        String pagesString = request.getParameter(PAGES_PARAMETER);
        int pages = Integer.parseInt(pagesString);

        String amountString = request.getParameter(AMOUNT_PARAMETER);
        Integer amount = Integer.parseInt(amountString);

        Book book = new Book(id, title, author, pages, amount, publisher, false);

        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        CommandResult commandResult = null;
        try {
            bookService.saveBook(book);
        } catch (FieldValidatorException e) {
            LOGGER.error("Incorrect data entered");
            commandResult = CommandResult.redirect(contextPath + MESSAGE_PAGE);
        } catch (ServiceException e) {
            commandResult = CommandResult.redirect(contextPath + MESSAGE_PAGE + WITH_MESSAGE_BOOK_DUPLICATION);
        }

        if (idString.isEmpty()) {
            commandResult = CommandResult.redirect(contextPath + MESSAGE_PAGE + WITH_MESSAGE_BOOK_ADDED);
        } else {
            commandResult = CommandResult.redirect(contextPath + MESSAGE_PAGE + WITH_MESSAGE_BOOK_EDITED);
        }
        return commandResult;
    }
}
