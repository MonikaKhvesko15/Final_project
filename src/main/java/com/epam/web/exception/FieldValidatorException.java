package com.epam.web.exception;

/**
 * The {@code FieldValidatorException} class is <em>checked
 * exception</em>.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public class FieldValidatorException extends ServiceException {
    public FieldValidatorException() {

    }

    public FieldValidatorException(String message) {

        super(message);
    }

    public FieldValidatorException(String message, Throwable cause) {

        super(message, cause);
    }

    public FieldValidatorException(Throwable cause) {

        super(cause);
    }
}
