package com.epam.web.dao.helper;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.book.BookDaoImpl;
import com.epam.web.dao.user.UserDao;
import com.epam.web.dao.user.UserDaoImpl;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) throws ConnectionPoolException {
        this.connection = pool.getConnection();
    }

    //all dao use one connection

    public UserDao createUserDao(){
        return new UserDaoImpl(connection);
    }

    public BookDao createBookDao(){return new BookDaoImpl(connection);
    }



    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
