package com.epam.web.mapper;

import com.epam.web.entity.Book;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;
import com.sun.corba.se.spi.ior.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    //map string to obj
    T map(ResultSet resultSet) throws SQLException;

    //factory method
    //create concrete mapper from table name

//    static RowMapper<? extends Identifiable> create(String table) {
//        switch (table) {
//            case User.TABLE:
//                return new UserRowMapper();
//            case Book.TABLE:
//                //return new BookRowMapper();
//            case Order.TABLE:
//                //return new OrderRowMapper();
//            default:
//                throw new IllegalArgumentException("Unknown table = " + table);
//        }
//    }
}
