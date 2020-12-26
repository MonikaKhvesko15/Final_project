package com.epam.web.dao.mapper;

import com.epam.web.entity.Publisher;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PublisherRowMapper implements RowMapper<Publisher> {
    @Override
    public Publisher map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Publisher.ID);
        String name = resultSet.getString(Publisher.NAME);
        int year=resultSet.getInt(Publisher.ESTABLISH_YEAR);

        return new Publisher(id, name, year);
    }

}
