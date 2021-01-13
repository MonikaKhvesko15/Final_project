package com.epam.web.validator;

import com.epam.web.exception.FieldValidatorException;

public interface Validator<T> {
    boolean checkCorrectnessEnteredData(T item) throws FieldValidatorException;
}
