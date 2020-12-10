package com.epam.web.dao.helper;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.exception.ConnectionPoolException;

public class DaoHelperFactory {
    public DaoHelper create() throws ConnectionPoolException {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
