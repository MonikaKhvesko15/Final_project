package com.epam.web.dao.impl.publisher;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Publisher;
import com.epam.web.exception.DaoException;

import java.util.Optional;

/**
 * The {@code PublisherDao} interface complements Dao and represents specific method signatures
 * to work with Publisher.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public interface PublisherDao extends Dao<Publisher> {
    Optional<Publisher> getByName(String name) throws DaoException;
}
