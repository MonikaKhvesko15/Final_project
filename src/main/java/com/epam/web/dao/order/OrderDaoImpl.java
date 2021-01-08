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

    private static final String SAVE_ORDER = "INSERT INTO orders (issue_date, return_date, type, user_id, book_id) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_ORDER = "UPDATE orders SET issue_date=?, return_date=?, type=?, user_id=?, book_id=? " +
            "WHERE id = ?";
    private static final String GET_ACTIVE_ORDERS_PART = "SELECT * FROM orders WHERE orders.status!='COMPLETED' AND orders.status!='REJECTED' limit ?, ?";
    private static final String UPDATE_ORDER_STATUS = "UPDATE orders SET status = ? WHERE id = ?";
    private static final String REJECT_PASSIVE_ORDERS_BY_BOOK_ID = "UPDATE orders SET status = 'REJECTED' WHERE orders.status='UNDER_CONSIDERATION' AND book_id = ?";

    public OrderDaoImpl(Connection connection) {
        super(connection, new OrderRowMapper(), Order.TABLE, new OrderFieldsExtractor(), SAVE_ORDER, UPDATE_ORDER);
    }

    @Override
    public List<Order> findActiveOrdersPart(int startPosition, int endPosition) throws DaoException {
        return executeQuery(GET_ACTIVE_ORDERS_PART, startPosition, endPosition);
    }

    @Override
    public void updateStatus(int id, String newStatus) throws DaoException {
        executeUpdate(UPDATE_ORDER_STATUS, newStatus, id);
    }

    @Override
    public void rejectPendingOrdersByBookId(Integer bookId) throws DaoException {
        executeUpdate(REJECT_PASSIVE_ORDERS_BY_BOOK_ID, bookId);
    }

}
