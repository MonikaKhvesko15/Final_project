package com.epam.web.dao.book;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Book;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;


public interface BookDao extends Dao<Book> {
    //specific methods for bookDao

    List<Book> findBooksPart(int startPosition, int endPosition) throws DaoException;

    Optional<Book> getBookByTitle(String title) throws DaoException;

    void increaseBookAmount(Integer id) throws DaoException;

    void decreaseBookAmount(Integer id) throws DaoException;
}
