package com.epam.web.service.order;

import com.epam.web.entity.Order;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/**
 * The {@code OrderService} interface represents specific method signatures to work with orders.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public interface OrderService {

    void createOrder(Order order) throws ServiceException;

    List<OrderDto> getActiveOrdersDtoPart(int startPosition, int endPosition) throws ServiceException;

    List<OrderDto> getReaderOrdersDtoPart(Integer userId, int startPosition, int endPosition) throws ServiceException;

    List<OrderDto> getAllOrdersDtoPart(int startPosition, int endPosition) throws ServiceException;

    void changeOrderStatus(Integer orederId, Order.Status newStatus) throws ServiceException;

    void completeOrderById(Integer orderId, Integer bookId, Order.Status newStatus) throws ServiceException;
}
