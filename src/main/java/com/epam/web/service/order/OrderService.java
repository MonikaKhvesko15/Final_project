package com.epam.web.service.order;

import com.epam.web.entity.Order;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.ServiceException;

import java.util.List;

public interface OrderService {
    void createOrder(Order order) throws ConnectionPoolException, ServiceException;

    List<OrderDto> getOrdersDtoPart(int startPosition, int endPosition) throws ServiceException;

    void changeOrderStatus(Integer orederId, Order.Status newStatus) throws ServiceException;
}
