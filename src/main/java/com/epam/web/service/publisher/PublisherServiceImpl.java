package com.epam.web.service.publisher;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.impl.publisher.PublisherDao;
import com.epam.web.entity.Publisher;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.util.Optional;

public class PublisherServiceImpl implements PublisherService {
    private DaoHelperFactory daoHelperFactory;

    public PublisherServiceImpl() {
        this.daoHelperFactory = new DaoHelperFactory();
    }

    @Override
    public Optional<Publisher> getPublisherByName(String publisherName) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            PublisherDao publisherDao= daoHelper.createPublisherDao();
            return publisherDao.getByName(publisherName);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
