package com.epam.web.service.order;

import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.order.OrderDtoDao;
import com.epam.web.entity.dto.Order;
import com.epam.web.entity.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private DaoHelperFactory daoHelperFactory;

    public OrderServiceImpl() {
        daoHelperFactory = new DaoHelperFactory();
    }

    @Override
    public void createOrder(OrderDto orderDto) throws ConnectionPoolException, ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDtoDao orderDtoDao = daoHelper.createOrderDtoDao();
            BookDao bookDao = daoHelper.createBookDao();

            Integer bookId = orderDto.getBookId();

            //transaction
            daoHelper.startTransaction();
            orderDtoDao.save(orderDto);
            bookDao.updateBookAmount(bookId);
            daoHelper.commitTransaction();

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getOrdersPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDtoDao orderDtoDao = daoHelper.createOrderDtoDao();
            return orderDtoDao.findOrdersPart(startPosition, endPosition);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
