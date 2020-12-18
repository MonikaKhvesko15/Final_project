package com.epam.web.mapper;

import com.epam.web.entity.Book;
import com.epam.web.entity.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

public class PublisherRowMapper implements RowMapper<Publisher> {
    @Override
    public Publisher map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Publisher.ID);
        String name = resultSet.getString(Publisher.NAME);
        String yearString = resultSet.getString(Publisher.YEAR);
        Year year=Year.parse(yearString);

        return new Publisher(id, name, year);
    }
}
