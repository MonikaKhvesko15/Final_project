package com.epam.web.dao.extractor;


import com.epam.web.entity.Book;
import com.epam.web.entity.Publisher;

import java.util.ArrayList;
import java.util.List;

public class BookFieldsExtractor implements FieldsExtractor<Book> {
    @Override
    public List<Object> extract(Book book) {
        List<Object> params = new ArrayList<>();
        // Integer id=(Integer) book.getId();
        String title = book.getTitle();
        String author = book.getAuthor();
        int pages = book.getPages();
        Integer amount = book.getAmount();
        Publisher publisher = book.getPublisher();
        Integer publisher_id = (Integer) publisher.getId();
        //params.add(id);
        params.add(title);
        params.add(author);
        params.add(pages);
        params.add(amount);
        params.add(publisher_id);
        return params;
    }
}
