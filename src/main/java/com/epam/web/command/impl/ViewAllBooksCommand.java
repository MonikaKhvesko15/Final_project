package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Book;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewAllBooksCommand implements Command {

    public static final String BOOKS_PARAMETER = "books";


    private final BookServiceImpl service;

    public ViewAllBooksCommand() {

        service = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<Book> bookList = service.findAll();
        request.setAttribute(BOOKS_PARAMETER, bookList);
        return CommandResult.forward("WEB-INF/views/catalog.jsp");
    }
}
