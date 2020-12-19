package com.epam.web.extractor;


import com.epam.web.entity.Identifiable;

import java.util.List;


public interface FieldsExtractor<T extends Identifiable> {
    List<Object> extract(T item);
}
