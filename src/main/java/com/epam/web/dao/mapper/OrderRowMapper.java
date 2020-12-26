package com.epam.web.dao.mapper;

import com.epam.web.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Order.ID);
        LocalDate issueDate = LocalDate.parse(resultSet.getString(Order.ISSUE_DATE));
        LocalDate returnDate = LocalDate.parse(resultSet.getString(Order.RETURN_DATE));

        String statusString = resultSet.getString(Order.STATUS);
        Order.Status status = Order.Status.valueOf(statusString.toUpperCase());

        String typeString = resultSet.getString(Order.TYPE);
        Order.Type type = Order.Type.valueOf(typeString.toUpperCase());

        Integer userId = resultSet.getInt(Order.USER_ID);
        Integer bookId = resultSet.getInt(Order.BOOK_ID);

        return new Order(id, issueDate, returnDate, status, type, bookId, userId);
    }
}
