package com.epam.web.dao.impl.book;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Book;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The {@code BookDao} interface complements Dao and represents specific method signatures
 * to work with Book.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public interface BookDao extends Dao<Book> {

    List<Book> findBooksPart(int startPosition, int endPosition) throws DaoException;

    Optional<Book> getBookByTitle(String title) throws DaoException;

    void increaseBookAmount(Integer id) throws DaoException;

    void decreaseBookAmount(Integer id) throws DaoException;

}
