package com.epam.web.dao.mapper;

import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.helper.DaoHelperImpl;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.user.UserDao;
import com.epam.web.entity.Book;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceMapper {
    private DaoHelperFactory daoHelperFactory;

    public OrderServiceMapper() {
        this.daoHelperFactory = new DaoHelperFactory();

    }

    public List<OrderDto> getAllOrdersDto(List<Order> orderList) throws DaoException, ConnectionPoolException, ServiceException {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto orderDto = convertToOrderDto(order);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    private OrderDto convertToOrderDto(Order order) throws ConnectionPoolException, DaoException, ServiceException {

        Integer id = (Integer) order.getId();
        LocalDate issueDate = order.getIssueDate();
        LocalDate returnDate = order.getReturnDate();
        Order.Status status = order.getStatus();
        Order.Type type = order.getType();

        Integer bookId = order.getBookId();
        Integer userId = order.getUserId();

        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            UserDao userDao = daoHelper.createUserDao();

            Book book = bookDao.getById(bookId).get();
            User user = userDao.getById(userId).get();

            String bookTitle = book.getTitle();
            String author = book.getAuthor();

            String username = user.getFirstname();
            String surname = user.getSurname();
            return new OrderDto(id, issueDate, returnDate, status, type, bookTitle, author, username, surname);
        } catch (DaoException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }
}
