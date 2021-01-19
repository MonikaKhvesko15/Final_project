package com.epam.web.dao.mapper;

import com.epam.web.entity.Identifiable;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code RowMapper} interface represents
 * method signatures for mapping strings to an object.
 *
 * @param <T>
 * @author Monika Khvesko
 * @version 1.0
 */
public interface RowMapper<T extends Identifiable> {
    T map(ResultSet resultSet) throws SQLException;
}
