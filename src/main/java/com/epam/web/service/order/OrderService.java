package com.epam.web.service.order;

import com.epam.web.entity.dto.Order;
import com.epam.web.entity.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.ServiceException;

import java.util.List;

public interface OrderService {
    void createOrder(OrderDto orderDto) throws ConnectionPoolException, ServiceException;
    List<Order> getOrdersPart(int startPosition, int endPosition) throws ServiceException;
}
