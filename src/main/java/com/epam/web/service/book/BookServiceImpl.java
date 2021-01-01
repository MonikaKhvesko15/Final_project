package com.epam.web.service.book;

import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.helper.DaoHelperImpl;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.entity.Book;
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

//    @Override
//    public List<Book> findAll() throws ServiceException {
//        try (DaoHelper daoHelper = daoHelperFactory.create()) {
//            BookDao bookDao = daoHelper.createBookDao();
//            return bookDao.findAllBooks();
//        } catch (ConnectionPoolException | SQLException | DaoException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }

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
    public void deleteBookById(Integer bookId) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            bookDao.removeById(bookId);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
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
