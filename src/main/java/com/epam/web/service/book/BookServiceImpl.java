package com.epam.web.service.book;

import com.epam.web.dao.impl.book.BookDao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.impl.order.OrderDao;
import com.epam.web.entity.Book;
import com.epam.web.entity.Order;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.FieldValidatorException;
import com.epam.web.exception.ServiceException;
import com.epam.web.validator.BookValidator;
import com.epam.web.validator.Validator;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private DaoHelperFactory daoHelperFactory;
    private Validator<Book> bookValidator;

    public BookServiceImpl() {

        this.daoHelperFactory = new DaoHelperFactory();
        this.bookValidator = new BookValidator();
    }

    @Override
    public List<Book> getBooksPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            return bookDao.findBooksPart(startPosition, endPosition);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    @Override
    public Optional<Book> findBookByTitle(String title) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            return bookDao.getBookByTitle(title);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteBookById(Integer bookId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            OrderDao orderDao = daoHelper.createOrderDao();
            List<Order> orders = orderDao.findAll();
            //transaction
            daoHelper.startTransaction();
            bookDao.removeById(bookId);
            orderDao.rejectPendingOrdersByBookId(bookId);
            daoHelper.commitTransaction();

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Book> getBookById(Integer bookId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            return bookDao.getById(bookId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void saveBook(Book book) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            if (bookValidator.isInputDataCorrect(book)) {
                bookDao.save(book);
            } else {
                throw new FieldValidatorException();
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


}
