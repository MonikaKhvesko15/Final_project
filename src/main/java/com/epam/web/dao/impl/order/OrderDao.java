package com.epam.web.dao.impl.order;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Order;
import com.epam.web.exception.DaoException;

import java.util.List;
/**
 * The {@code OrderDao} interface complements Dao and represents specific method signatures
 * to work with Order.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public interface OrderDao extends Dao<Order> {
    List<Order> findActiveOrdersPart(int startPosition, int endPosition) throws DaoException;

    List<Order> findReaderOrdersPart(Integer userId, int startPosition, int endPosition) throws DaoException;

    List<Order> findAllOrdersPart(int startPosition, int endPosition) throws DaoException;

    void updateStatus(int id, String newStatus) throws DaoException;

    void rejectPendingOrdersByBookId(Integer bookId) throws DaoException;
}

