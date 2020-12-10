package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.sun.corba.se.spi.ior.Identifiable;
import java.util.List;
import java.util.Optional;

//CRUD
public interface Dao<T extends Identifiable> {

    Optional<T> getById(int id);

    //read
    List<T> findAll(String tablename) throws DaoException;

    //create/update
    // if entity has id -> update
    // else -> insert
    void save(T item);

    //delete
    void removeById(int id);
}
