package com.epam.web.mapper;

import com.epam.web.entity.Book;
import com.epam.web.entity.Identifiable;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    //map string to obj
    T map(ResultSet resultSet) throws SQLException;
}
