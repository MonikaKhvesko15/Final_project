package com.epam.web.exception;

/**
 * The {@code ConnectionPoolException} class is <em>unchecked
 * exception</em>. It can be thrown out of the method on a database connection error.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public class ConnectionPoolException extends RuntimeException {
    public ConnectionPoolException() {

    }

    public ConnectionPoolException(String message) {

        super(message);
    }

    public ConnectionPoolException(String message, Throwable cause) {

        super(message, cause);
    }

    public ConnectionPoolException(Throwable cause) {

        super(cause);
    }
}
