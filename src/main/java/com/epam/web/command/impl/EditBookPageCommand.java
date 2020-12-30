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
    private final BookService service;

    public EditBookPageCommand() {
        this.service = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String bookIdString = request.getParameter("bookId");
            Integer bookId = Integer.parseInt(bookIdString);

            Book book = service.getBookById(bookId).get();
            request.setAttribute("editBook", book);
            return CommandResult.forward("WEB-INF/views/edit_book_page.jsp");
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
