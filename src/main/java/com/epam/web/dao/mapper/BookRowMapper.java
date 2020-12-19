package com.epam.web.dao.mapper;

import com.epam.web.entity.Book;
import com.epam.web.entity.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    private RowMapper<Publisher> publisherRowMapper;

    public BookRowMapper() {
        publisherRowMapper = new PublisherRowMapper();
    }

    //create book from columns in database
    @Override
    public Book map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Book.ID);
        String title = resultSet.getString(Book.TITLE);
        String author = resultSet.getString(Book.AUTHOR);

        int pages = resultSet.getInt(Book.PAGES);

        Integer amount = resultSet.getInt(Book.AMOUNT);

        Publisher publisher = publisherRowMapper.map(resultSet);

        return new Book(id, title, author, pages, amount, publisher);
    }
}
