package com.epam.web.dao.extractor;

import com.epam.web.entity.Publisher;

import java.util.ArrayList;
import java.util.List;

public class PublisherFieldsExtractor implements FieldsExtractor<Publisher> {
    @Override
    public List<Object> extract(Publisher publisher) {
        List<Object> params = new ArrayList<>();
        String publisherName = publisher.getName();
        int establishYear = publisher.getEstablishyear();

        params.add(publisherName);
        params.add(establishYear);

        return params;
    }
}
