package com.epam.web.exception;
/**
 * The {@code DaoException} class is <em>checked
 * exception</em>.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public class DaoException extends Exception {

    public DaoException() {

    }

    public DaoException(String message) {

        super(message);
    }

    public DaoException(String message, Throwable cause) {

        super(message, cause);
    }

    public DaoException(Throwable cause) {

        super(cause);
    }
}
