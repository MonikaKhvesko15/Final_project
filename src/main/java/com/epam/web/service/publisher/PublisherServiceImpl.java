package com.epam.web.service.publisher;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.helper.DaoHelperImpl;
import com.epam.web.dao.publisher.PublisherDao;
import com.epam.web.entity.Publisher;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.sql.SQLException;
import java.util.Optional;

public class PublisherServiceImpl implements PublisherService {
    private DaoHelperFactory daoHelperFactory;

    public PublisherServiceImpl() {
        this.daoHelperFactory = new DaoHelperFactory();
    }

    @Override
    public Optional<Publisher> getPublisherByName(String publisherName) throws ServiceException {
        try (DaoHelperImpl daoHelper = daoHelperFactory.create()) {
            PublisherDao publisherDao= daoHelper.createPublisherDao();
            return publisherDao.getByName(publisherName);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
