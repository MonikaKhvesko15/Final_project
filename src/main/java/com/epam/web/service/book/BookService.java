package com.epam.web.service.book;

import com.epam.web.entity.Book;
import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll() throws ServiceException;
    Optional<Book> getBookById(int id);
}
