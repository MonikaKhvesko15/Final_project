package com.epam.web.exception;

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
