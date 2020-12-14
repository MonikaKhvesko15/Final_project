package com.epam.web.collector;


import com.epam.web.entity.Identifiable;

import java.util.List;


public interface ParameterCollector<T extends Identifiable> {
    List<Object> collect(T item);
}
