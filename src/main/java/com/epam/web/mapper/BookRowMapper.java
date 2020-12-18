package com.epam.web.mapper;

import com.epam.web.entity.Book;
import com.epam.web.entity.Identifiable;
import com.epam.web.entity.Publisher;
import com.epam.web.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    private RowMapper<Publisher> publisherRowMapper;

    BookRowMapper(){
        publisherRowMapper=new PublisherRowMapper();
    }
    //create book from columns in database
    @Override
    public Book map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Book.ID);
        String title = resultSet.getString(Book.TITLE);
        String author = resultSet.getString(Book.AUTHOR);

        String pagesString = resultSet.getString(Book.PAGES);
        int pages = Integer.parseInt(pagesString);

        String amountString = resultSet.getString(Book.AMOUNT);
        int amount = Integer.parseInt(amountString);

        //Publisher publisher= publisherRowMapper.map(resultSet.);

        return null/*new Book(id, title, author, pages, amount, publisher)*/;
    }
}
