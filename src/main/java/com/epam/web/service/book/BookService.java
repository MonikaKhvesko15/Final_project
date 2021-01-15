package com.epam.web.service.book;

import com.epam.web.entity.Book;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooksPart(int startPosition, int endPosition) throws ServiceException;

    Optional<Book> findBookByTitle(String title) throws ServiceException;

    void deleteBookById(Integer bookId) throws ServiceException;

    Optional<Book> getBookById(Integer bookId) throws ServiceException;

    void saveBook(Book book) throws ServiceException;
}
