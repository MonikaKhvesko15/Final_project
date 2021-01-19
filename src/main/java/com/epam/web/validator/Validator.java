package com.epam.web.validator;

/**
 * The {@code Validator} interface represents method signatures to check the received data.
 *
 * @param <T>
 * @author Monika Khvesko
 * @version 1.0
 */
public interface Validator<T> {
    boolean isInputDataCorrect(T item);
}
