package com.epam.web.dao.order;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Order;
import com.epam.web.exception.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> findOrdersPart(int startPosition, int endPosition) throws DaoException;
}
