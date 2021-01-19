package com.epam.web.entity;

import java.io.Serializable;

/**
 * The {@code Identifiable} interface
 * provides unique identification of the entity.
 *
 * @param <T>
 * @author Monika Khvesko
 * @version 1.0
 */
public interface Identifiable<T extends Serializable> {
    T getId();
}
