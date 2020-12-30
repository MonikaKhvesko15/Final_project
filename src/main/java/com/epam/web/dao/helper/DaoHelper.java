package com.epam.web.dao.helper;

import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.order.OrderDao;
import com.epam.web.dao.publisher.PublisherDao;
import com.epam.web.dao.user.UserDao;
import com.epam.web.exception.DaoException;

public interface DaoHelper {
    UserDao createUserDao();

    BookDao createBookDao();

    OrderDao createOrderDao();

    PublisherDao createPublisherDao();

    void startTransaction() throws DaoException;

    void commitTransaction() throws DaoException;

}
