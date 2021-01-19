package com.epam.web.dao.helper;

import com.epam.web.dao.impl.book.BookDao;
import com.epam.web.dao.impl.order.OrderDao;
import com.epam.web.dao.impl.publisher.PublisherDao;
import com.epam.web.dao.impl.user.UserDao;
import com.epam.web.exception.DaoException;

/**
 * The {@code DaoHelper} interface represents method signatures to create
 * specific dao in such a way that all Dao use one connection.
 * This interface also contains method signatures for working with transactions.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public interface DaoHelper extends AutoCloseable {
    UserDao createUserDao();

    BookDao createBookDao();

    OrderDao createOrderDao();

    PublisherDao createPublisherDao();

    void startTransaction() throws DaoException;

    void commitTransaction() throws DaoException;

    void close() throws DaoException;

}
