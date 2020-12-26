package com.epam.web.dao.mapper;

import com.epam.web.entity.OrderDto;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDtoRowMapper implements RowMapper<OrderDto> {
    @Override
    public OrderDto map(ResultSet resultSet) throws SQLException {
        return null;
    }
}
