package com.epam.web.dao.book;

import com.epam.web.dao.AbstractDao;

import com.epam.web.entity.Book;
import com.epam.web.dao.mapper.BookRowMapper;
import com.epam.web.exception.DaoException;
import com.epam.web.extractor.BookFieldsExtractor;


import java.sql.Connection;
import java.util.List;
import java.util.Optional;


public class BookDaoImpl extends AbstractDao<Book> implements BookDao {
    private static final String FIND_ALL_BOOKS = "SELECT * \n" +
            "FROM library.books\n" +
            "INNER JOIN library.publishers\n" +
            "ON library.books.publisher_id=library.publishers.id;";


    public BookDaoImpl(Connection connection) {
        super(connection, new BookRowMapper(), Book.TABLE, new BookFieldsExtractor());
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }


    @Override
    public List<Book> findAllBooks() throws DaoException {
        return executeQuery(FIND_ALL_BOOKS);
    }
}
