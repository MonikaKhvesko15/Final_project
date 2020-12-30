package com.epam.web.dao.publisher;

import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.PublisherFieldsExtractor;
import com.epam.web.dao.mapper.PublisherRowMapper;
import com.epam.web.entity.Publisher;
import com.epam.web.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class PublisherDaoImpl extends AbstractDao<Publisher> implements PublisherDao {
    private static final String FIND_PUBLISHER_BY_NAME = "SELECT publishers.id, publishers.name, publishers.establish_year\n" +
            "FROM publishers WHERE publishers.name = ?";

    public PublisherDaoImpl(Connection connection) {
        super(connection, new PublisherRowMapper(), Publisher.TABLE, new PublisherFieldsExtractor());
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }

    @Override
    public Optional<Publisher> getByName(String name) throws DaoException {
        return executeForSingleResult(FIND_PUBLISHER_BY_NAME, name);
    }
}
