package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Book;
import com.epam.web.entity.Publisher;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;
import com.epam.web.service.publisher.PublisherService;
import com.epam.web.service.publisher.PublisherServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveBookCommand implements Command {
    private static final String PUBLISHER_NAME_PARAMETER = "publisherName";
    private static final String BOOK_ID_PARAMETER = "bookId";
    private static final String TITLE_PARAMETER = "title";
    private static final String AUTHOR_PARAMETER = "author";
    private static final String PAGES_PARAMETER = "pages";
    private static final String AMOUNT_PARAMETER = "amount";
    private static final String BOOK_ADDED = "bookAdded";
    private static final String BOOK_EDITED = "bookEdited";
    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";

    private final BookService bookService;
    private final PublisherService publisherService;

    public SaveBookCommand() {
        this.bookService = new BookServiceImpl();
        this.publisherService = new PublisherServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
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

            Book book = new Book(id, title, author, pages, amount, publisher);

            bookService.saveBook(book);

            if (idString.isEmpty()) {
                request.setAttribute(BOOK_ADDED, true);
            } else {
                request.setAttribute(BOOK_EDITED, true);
            }
            return CommandResult.forward(MESSAGE_JSP);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
