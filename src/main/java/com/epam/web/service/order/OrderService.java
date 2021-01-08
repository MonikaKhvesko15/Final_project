package com.epam.web.service.order;

import com.epam.web.entity.Book;
import com.epam.web.entity.Order;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.ServiceException;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void createOrder(Order order) throws ConnectionPoolException, ServiceException;

    List<OrderDto> getOrdersDtoPart(int startPosition, int endPosition) throws ServiceException;

    void changeOrderStatus(Integer orederId, Order.Status newStatus) throws ServiceException;

    Optional<Order> getOrderById(Integer orderId) throws ServiceException;
}
