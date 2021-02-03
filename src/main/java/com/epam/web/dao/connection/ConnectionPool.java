package com.epam.web.dao.connection;

import com.epam.web.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance = null;
    private Queue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> usingConnections;
    private static final int POOL_SIZE = 10;
    private static final Lock CONNECTIONS_LOCKER = new ReentrantLock();
    private static final Lock INSTANCE_LOCKER = new ReentrantLock();
    private static final AtomicBoolean isCreated = new AtomicBoolean();
    private ProxyConnectionCreator proxyConnectionCreator;

    private ConnectionPool() throws ConnectionPoolException {
        proxyConnectionCreator = new ProxyConnectionCreator();
        freeConnections = new ArrayDeque<>();
        usingConnections = new ArrayDeque<>();

        for (int i = 0; i < POOL_SIZE; i++) {
            ProxyConnection proxyConnection = proxyConnectionCreator.create();
            freeConnections.add(proxyConnection);
        }
    }

    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            INSTANCE_LOCKER.lock();
            try {
                if (!isCreated.get()) {
                    instance = new ConnectionPool();
                    isCreated.set(true);
                }
            } catch (ConnectionPoolException e) {
                LOGGER.fatal(e.getMessage());
                throw new RuntimeException("Error connecting to database");
            } finally {
                INSTANCE_LOCKER.unlock();
            }
        }
        return instance;
    }

    public ProxyConnection getConnection() throws ConnectionPoolException {
        CONNECTIONS_LOCKER.lock();
        try {
            ProxyConnection proxyConnection = freeConnections.poll();
            if (!proxyConnection.isValid(1)) {
                proxyConnection = proxyConnectionCreator.create();
            }
            usingConnections.offer(proxyConnection);
            return proxyConnection;
        } catch (SQLException e) {
            throw new ConnectionPoolException(e.getMessage(), e);
        } finally {
            CONNECTIONS_LOCKER.unlock();
        }
    }

    public void killConnections() {
        usingConnections.forEach(this::releaseConnection);
        closeQueueConnections(freeConnections);
    }

    public void releaseConnection(ProxyConnection connection) {
        CONNECTIONS_LOCKER.lock();
        try {
            if (usingConnections.contains(connection)) {
                usingConnections.remove(connection);
                freeConnections.offer(connection);
            }
        } finally {
            CONNECTIONS_LOCKER.unlock();
        }
    }

    private void closeQueueConnections(Queue<ProxyConnection> freeConnections) {
        freeConnections.forEach(connection -> {
            try {
                connection.reallyClose();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
    }
}

