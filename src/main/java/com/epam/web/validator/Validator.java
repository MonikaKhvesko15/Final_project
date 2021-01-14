package com.epam.web.validator;

public interface Validator<T> {
    boolean isInputDataCorrect(T item);
}
