package com.epam.web.service.book;

import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.helper.DaoHelperImpl;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.order.OrderDao;
import com.epam.web.entity.Book;
import com.epam.web.entity.Order;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private DaoHelperFactory daoHelperFactory;

    public BookServiceImpl() {

        this.daoHelperFactory = new DaoHelperFactory();
    }

    @Override
    public List<Book> getBooksPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            return bookDao.findBooksPart(startPosition, endPosition);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    @Override
    public Optional<Book> findBookByTitle(String title) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            return bookDao.getBookByTitle(title);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteBookById(Integer bookId) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            boolean result = false;
            BookDao bookDao = daoHelper.createBookDao();
            OrderDao orderDao = daoHelper.createOrderDao();
            List<Order> orders = orderDao.findAll();
            if (!isBookInAcceptedOrders(bookId, orders)) {
                //transaction
                daoHelper.startTransaction();
                bookDao.removeById(bookId);
                orderDao.rejectPendingOrdersByBookId(bookId);
                daoHelper.commitTransaction();

                result = true;
            }
            return result;
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private boolean isBookInAcceptedOrders(Integer bookId, List<Order> orders) {
        boolean result = false;
        for (Order order : orders) {
            if (order.getBookId() == bookId && order.getStatus() == Order.Status.ACCEPTED) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Optional<Book> getBookById(Integer bookId) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            return bookDao.getById(bookId);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void saveBook(Book book) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            bookDao.save(book);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


}
