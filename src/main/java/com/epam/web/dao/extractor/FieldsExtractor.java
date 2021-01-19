package com.epam.web.dao.extractor;


import com.epam.web.entity.Identifiable;

import java.util.List;

/**
 * The {@code FieldsExtractor} interface represents method signatures
 * for extracting data from objects into a List.
 *
 * @param <T>
 * @author Monika Khvesko
 * @version 1.0
 */
public interface FieldsExtractor<T extends Identifiable> {
    List<Object> extract(T item);
}
