package com.epam.web.dao.extractor;

import com.epam.web.entity.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderDtoFieldsExtractor implements FieldsExtractor<OrderDto> {
    @Override
    public List<Object> extract(OrderDto orderDto) {
        List<Object> params = new ArrayList<>();
        //int id = (int) orderDto.getId();
        String issueDate = orderDto.getIssueDate().toString();
        String returnDate = orderDto.getReturnDate().toString();
        String type = orderDto.getType().toString();
        int userId = orderDto.getUserId();
        int bookId = orderDto.getBookId();

        //  params.add(id);
        params.add(issueDate);
        params.add(returnDate);
        params.add(type);
        params.add(userId);
        params.add(bookId);
        return params;
    }
}
