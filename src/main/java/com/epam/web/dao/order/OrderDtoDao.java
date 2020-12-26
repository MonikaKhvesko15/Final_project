package com.epam.web.dao.order;

import com.epam.web.dao.Dao;
import com.epam.web.entity.OrderDto;
import com.epam.web.exception.DaoException;

import java.util.List;

public interface OrderDtoDao extends Dao<OrderDto> {
    List<OrderDto> findOrdersPart(int startPosition, int endPosition) throws DaoException;
}
