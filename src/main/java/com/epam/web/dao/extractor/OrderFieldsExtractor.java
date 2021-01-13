package com.epam.web.dao.extractor;

import com.epam.web.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderFieldsExtractor implements FieldsExtractor<Order> {
    @Override
    public List<Object> extract(Order order) {
        List<Object> params = new ArrayList<>();
        String issueDate = order.getIssueDate().toString();
        String returnDate = order.getReturnDate().toString();
        String type = order.getType().toString();
        int userId = order.getUserId();
        int bookId = order.getBookId();

        params.add(issueDate);
        params.add(returnDate);
        params.add(type);
        params.add(userId);
        params.add(bookId);
        return params;
    }
}
