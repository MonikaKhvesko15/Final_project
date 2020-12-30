package com.epam.web.dao.publisher;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Publisher;
import com.epam.web.exception.DaoException;

import java.util.Optional;

public interface PublisherDao extends Dao<Publisher> {
    Optional<Publisher> getByName(String name) throws DaoException;
}
