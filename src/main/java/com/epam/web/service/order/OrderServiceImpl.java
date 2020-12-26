package com.epam.web.service.order;
import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.mapper.OrderServiceMapper;
import com.epam.web.dao.order.OrderDao;
import com.epam.web.entity.Order;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private DaoHelperFactory daoHelperFactory;
    private OrderServiceMapper orderServiceMapper;

    public OrderServiceImpl() {
        daoHelperFactory = new DaoHelperFactory();
        orderServiceMapper = new OrderServiceMapper();
    }

    @Override
    public void createOrder(Order order) throws ConnectionPoolException, ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            BookDao bookDao = daoHelper.createBookDao();

            Integer bookId = order.getBookId();

            //transaction
            daoHelper.startTransaction();
            orderDao.save(order);
            bookDao.updateBookAmount(bookId);
            daoHelper.commitTransaction();

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderDto> getOrdersDtoPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            List<Order> orderList = orderDao.findOrdersPart(startPosition, endPosition);
            return orderServiceMapper.getAllOrdersDto(orderList);

        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


}
