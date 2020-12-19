package com.epam.web.dao.book;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Book;
import com.epam.web.exception.DaoException;

import java.util.List;


public interface BookDao extends Dao<Book> {
    //specific methods for bookDao

    public List<Book> findAllBooks() throws DaoException;
}
