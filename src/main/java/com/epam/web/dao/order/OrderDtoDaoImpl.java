package com.epam.web.dao.order;

import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.OrderDtoFieldsExtractor;
import com.epam.web.dao.mapper.OrderDtoRowMapper;
import com.epam.web.entity.dto.Order;
import com.epam.web.entity.OrderDto;
import com.epam.web.exception.DaoException;

import java.sql.Connection;
import java.util.List;

public class OrderDtoDaoImpl extends AbstractDao<OrderDto> implements OrderDtoDao {

    private static final String INSERT_ORDER = "INSERT INTO orders (issue_date, return_date, type, user_id, book_id) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ORDER_PARTS = "";

    public OrderDtoDaoImpl(Connection connection) {
        super(connection, new OrderDtoRowMapper(), Order.TABLE, new OrderDtoFieldsExtractor());
    }

    @Override
    protected String getUpdateQuery() {
        return INSERT_ORDER;
    }

    @Override
    public List<OrderDto> findOrdersPart(int startPosition, int endPosition) throws DaoException {
        return executeQuery(GET_ORDER_PARTS, startPosition, endPosition);
    }
}
