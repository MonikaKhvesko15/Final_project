package com.epam.web.dao.helper;

import com.epam.web.dao.connection.ConnectionPool;
import com.epam.web.dao.connection.ProxyConnection;
import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.book.BookDaoImpl;
import com.epam.web.dao.order.OrderDao;
import com.epam.web.dao.order.OrderDaoImpl;
import com.epam.web.dao.publisher.PublisherDao;
import com.epam.web.dao.publisher.PublisherDaoImpl;
import com.epam.web.dao.user.UserDao;
import com.epam.web.dao.user.UserDaoImpl;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;

import java.sql.SQLException;

public class DaoHelperImpl implements AutoCloseable, DaoHelper {

    private ProxyConnection connection;

    public DaoHelperImpl(ConnectionPool pool) throws ConnectionPoolException {
        this.connection = pool.getConnection();
    }

    //all dao use one connection
    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    @Override
    public BookDao createBookDao() {
        return new BookDaoImpl(connection);
    }

    @Override
    public OrderDao createOrderDao() {
        return new OrderDaoImpl(connection);
    }

    @Override
    public PublisherDao createPublisherDao() {
        return new PublisherDaoImpl(connection);
    }

    @Override
    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void commitTransaction() throws DaoException {
        try {
            connection.commit();
        } catch (SQLException commitException) {
            try {
                connection.rollback();
            } catch (SQLException rollbackException) {
                throw new DaoException(rollbackException);
            }
        }
    }


    @Override
    public void close() throws SQLException, DaoException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }
}
