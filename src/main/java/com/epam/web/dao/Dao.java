package com.epam.web.dao;


import com.epam.web.entity.Identifiable;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;
/**
 * The {@code Dao} interface represents typical CRUD operations.
 *
 * @param <T>
 * @author Monika Khvesko
 * @version 1.0
 */
public interface Dao<T extends Identifiable> {

    Optional<T> getById(int id) throws DaoException;

    //read
    List<T> findAll() throws DaoException;

    //create/update
    // if entity has id -> update
    // else -> insert
    void save(T item) throws DaoException;

    //delete
    void removeById(int id) throws DaoException;
}
