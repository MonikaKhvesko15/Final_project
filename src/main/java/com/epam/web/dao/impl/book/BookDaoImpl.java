package com.epam.web.dao.impl.book;

import com.epam.web.dao.AbstractDao;

import com.epam.web.entity.Book;
import com.epam.web.dao.mapper.BookRowMapper;
import com.epam.web.exception.DaoException;
import com.epam.web.dao.extractor.BookFieldsExtractor;


import java.sql.Connection;
import java.util.List;
import java.util.Optional;


public class BookDaoImpl extends AbstractDao<Book> implements BookDao {
    private static final String GET_BOOKS_PART = "SELECT * FROM books INNER JOIN publishers ON books.publisher_id=publishers.id WHERE books.isDeleted!=1 limit ?, ?";
    private static final String FIND_BOOK_BY_TITLE = "SELECT books.id, books.title, books.author,books.pages,books.amount, books.isDeleted, publishers.id, publishers.name,publishers.establish_year\n" +
            "FROM books INNER JOIN publishers ON books.publisher_id=publishers.id\n" +
            "WHERE books.title = ?";
    private static final String FIND_BOOK_BY_ID = "SELECT books.id, books.title, books.author,books.pages,books.amount,books.isDeleted, publishers.id, publishers.name,publishers.establish_year\n" +
            "FROM books INNER JOIN publishers ON books.publisher_id=publishers.id\n" +
            "WHERE books.id = ?";
    private static final String DECREASE_BOOK_AMOUNT = "UPDATE books SET books.amount = books.amount-1 WHERE books.id = ?";
    private static final String INCREASE_BOOK_AMOUNT = "UPDATE books SET books.amount = books.amount+1 WHERE books.id = ?";
    private static final String UPDATE_BOOK = "UPDATE books SET title=?, author=?, pages=?, amount=?, publisher_id=? WHERE id = ?";
    private static final String SAVE_BOOK = "INSERT INTO books (title, author, pages, amount, publisher_id) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_BOOK = "UPDATE books SET isDeleted=1 WHERE id = ?";

    public BookDaoImpl(Connection connection) {
        super(connection, new BookRowMapper(), Book.TABLE, new BookFieldsExtractor(), SAVE_BOOK, UPDATE_BOOK);
    }

    @Override
    public List<Book> findBooksPart(int startPosition, int endPosition) throws DaoException {
        return executeQuery(GET_BOOKS_PART, startPosition, endPosition);
    }

    @Override
    public Optional<Book> getBookByTitle(String title) throws DaoException {
        return executeForSingleResult(FIND_BOOK_BY_TITLE, title);
    }

    @Override
    public void increaseBookAmount(Integer id) throws DaoException {
        executeUpdate(INCREASE_BOOK_AMOUNT, id);
    }

    @Override
    public void decreaseBookAmount(Integer id) throws DaoException {
        executeUpdate(DECREASE_BOOK_AMOUNT, id);
    }

    @Override
    public Optional<Book> getById(int id) throws DaoException {
        return executeForSingleResult(FIND_BOOK_BY_ID, id);
    }

    @Override
    public void removeById(int id) throws DaoException {
        executeUpdate(DELETE_BOOK, id);
    }
}
