package com.epam.web.service.order;

import com.epam.web.dao.impl.book.BookDao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.impl.order.OrderDao;
import com.epam.web.entity.Order;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private DaoHelperFactory daoHelperFactory;
    private OrderServiceMapper orderServiceMapper;

    public OrderServiceImpl() {
        daoHelperFactory = new DaoHelperFactory();
        orderServiceMapper = new OrderServiceMapper();
    }

    @Override
    public void createOrder(Order order) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            BookDao bookDao = daoHelper.createBookDao();

            Integer bookId = order.getBookId();

            //transaction
            daoHelper.startTransaction();
            orderDao.save(order);
            bookDao.decreaseBookAmount(bookId);
            daoHelper.commitTransaction();

        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void completeOrderById(Integer orderId, Integer bookId, Order.Status newStatus) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            BookDao bookDao = daoHelper.createBookDao();

            //transaction
            daoHelper.startTransaction();
            orderDao.updateStatus(orderId, newStatus.toString());
            bookDao.increaseBookAmount(bookId);
            daoHelper.commitTransaction();

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    @Override
    public List<OrderDto> getActiveOrdersDtoPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            List<Order> orderList = orderDao.findActiveOrdersPart(startPosition, endPosition);
            return orderServiceMapper.getAllOrdersDto(orderList);

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<OrderDto> getReaderOrdersDtoPart(Integer userId, int startPosition, int endPosition) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            List<Order> orderList = orderDao.findReaderOrdersPart(userId, startPosition, endPosition);
            return orderServiceMapper.getAllOrdersDto(orderList);

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<OrderDto> getAllOrdersDtoPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            List<Order> orderList = orderDao.findAllOrdersPart(startPosition, endPosition);
            return orderServiceMapper.getAllOrdersDto(orderList);

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void changeOrderStatus(Integer orederId, Order.Status newStatus) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            orderDao.updateStatus(orederId, newStatus.toString());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


}
