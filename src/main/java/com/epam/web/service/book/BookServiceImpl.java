package com.epam.web.service.book;

import com.epam.web.dao.book.BookDao;
import com.epam.web.dao.helper.DaoHelper;
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

    @Override
    public List<Book> findAll() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            BookDao bookDao = daoHelper.createBookDao();
            return bookDao.findAllBooks();
        } catch (ConnectionPoolException | SQLException | DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return Optional.empty();
    }
}
