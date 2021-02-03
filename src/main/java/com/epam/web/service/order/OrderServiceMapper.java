package com.epam.web.service.order;

import com.epam.web.dao.impl.book.BookDao;
import com.epam.web.dao.helper.DaoHelperImpl;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.impl.user.UserDao;
import com.epam.web.entity.Book;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code OrderServiceMapper} class represents service for converting user objects into user objects Dto.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public class OrderServiceMapper {
    private DaoHelperFactory daoHelperFactory;

    public OrderServiceMapper() {
        this.daoHelperFactory = new DaoHelperFactory();

    }

    public List<OrderDto> getAllOrdersDto(List<Order> orderList) throws ServiceException {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto orderDto = convertToOrderDto(order);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    private OrderDto convertToOrderDto(Order order) throws ServiceException {

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
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }
}
