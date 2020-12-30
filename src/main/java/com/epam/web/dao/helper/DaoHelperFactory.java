package com.epam.web.dao.helper;

import com.epam.web.dao.connection.ConnectionPool;
import com.epam.web.exception.ConnectionPoolException;

public class DaoHelperFactory {
    public DaoHelperImpl create() throws ConnectionPoolException {
        return new DaoHelperImpl(ConnectionPool.getInstance());
    }
}
