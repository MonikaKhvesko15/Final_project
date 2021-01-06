package com.epam.web.dao.mapper;

import com.epam.web.entity.Identifiable;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {
    //map string to obj
    T map(ResultSet resultSet) throws SQLException;
}
