package com.epam.web.dao.order;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Order;
import com.epam.web.exception.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> findActiveOrdersPart(int startPosition, int endPosition) throws DaoException;
    void updateStatus(int id, String newStatus) throws DaoException;
    void rejectPendingOrdersByBookId(Integer bookId) throws DaoException;
}

