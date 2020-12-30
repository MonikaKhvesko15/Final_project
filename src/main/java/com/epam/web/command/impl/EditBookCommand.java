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

public class EditBookCommand implements Command {
    public static final String PUBLISHER_NAME_PARAMETER = "publisherName";
    private final BookService bookService;
    private final PublisherService publisherService;
    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";

    public EditBookCommand() {
        this.bookService = new BookServiceImpl();
        this.publisherService = new PublisherServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String publisherName = request.getParameter(PUBLISHER_NAME_PARAMETER);
            Publisher publisher = publisherService.getPublisherByName(publisherName).get();

            String idString = request.getParameter("bookId");
            int id = Integer.parseInt(idString);
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String pagesString = request.getParameter("pages");
            int pages = Integer.parseInt(pagesString);
            String amountString = request.getParameter("amount");
            Integer amount = Integer.parseInt(amountString);

            Book book = new Book(id, title, author, pages, amount, publisher);
            bookService.editBook(book);

            request.setAttribute("bookEdited", true);
            return CommandResult.forward(MESSAGE_JSP);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
