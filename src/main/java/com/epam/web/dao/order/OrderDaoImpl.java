package com.epam.web.dao.order;

import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.OrderFieldsExtractor;
import com.epam.web.dao.mapper.OrderRowMapper;
import com.epam.web.entity.Order;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.DaoException;

import java.sql.Connection;
import java.util.List;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

    private static final String INSERT_ORDER = "INSERT INTO orders (issue_date, return_date, type, user_id, book_id) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ORDER_PARTS = "SELECT * FROM orders limit ?, ?";

    public OrderDaoImpl(Connection connection) {
        super(connection, new OrderRowMapper(), Order.TABLE, new OrderFieldsExtractor());
    }

    @Override
    protected String getUpdateQuery() {
        return INSERT_ORDER;
    }

    @Override
    public List<Order> findOrdersPart(int startPosition, int endPosition) throws DaoException {
        return executeQuery(GET_ORDER_PARTS, startPosition, endPosition);
    }
}
