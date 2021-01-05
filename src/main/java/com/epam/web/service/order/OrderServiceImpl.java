package com.epam.web.service.order;

import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.helper.DaoHelperImpl;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.mapper.OrderServiceMapper;
import com.epam.web.dao.order.OrderDao;
import com.epam.web.entity.Book;
import com.epam.web.entity.Order;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.sql.SQLException;
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
    public void createOrder(Order order) throws ConnectionPoolException, ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            BookDao bookDao = daoHelper.createBookDao();

            Integer bookId = order.getBookId();

            //transaction
            daoHelper.startTransaction();
            orderDao.save(order);
            bookDao.decreaseBookAmount(bookId);
            daoHelper.commitTransaction();

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void destroyOrder(Order order) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            BookDao bookDao = daoHelper.createBookDao();

            Integer id = (Integer) order.getId();
            Integer bookId = order.getBookId();

            //transaction
            daoHelper.startTransaction();
            orderDao.removeById(id);
            bookDao.increaseBookAmount(bookId);
            daoHelper.commitTransaction();

        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Order> getOrderById(Integer orderId) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            return orderDao.getById(orderId);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    @Override
    public List<OrderDto> getOrdersDtoPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            List<Order> orderList = orderDao.findOrdersPart(startPosition, endPosition);
            return orderServiceMapper.getAllOrdersDto(orderList);

        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void changeOrderStatus(Integer orederId, Order.Status newStatus) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            orderDao.updateStatus(orederId, newStatus.toString());
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


}
