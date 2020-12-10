package com.epam.web.dao;

import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.RowMapper;
import com.sun.corba.se.spi.ior.Identifiable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {
    private Connection connection;
    private final RowMapper<T> mapper;

    protected AbstractDao(Connection connection,RowMapper<T> mapper) {

        this.connection = connection;
        this.mapper=mapper;
    }

    // this method executes any SQL queries and return it in List
    protected List<T> executeQuery(String query,Object ...params) throws DaoException {

        List<T> entities = new ArrayList<>();

        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery(/*query*/)) {
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    //in this method we write parameters in form <<?>> then substitute them in the statement
    private PreparedStatement createStatement(String query, Object ...params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 1; i <= params.length; i++) {
            statement.setObject(i, params[i - 1]);
        }
        return statement;
    }

    @Override
    public Optional<T> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<T> findAll(String tablename) throws DaoException {
       //RowMapper<T> mapper = (RowMapper<T>)RowMapper.create(tablename);
       return executeQuery("SELECT * FROM "+tablename /*, mapper*/);
    }

    @Override
    public void save(T item) {

    }

    @Override
    public void removeById(int id) {

    }

    // this method executes any SQL queries and return it in Optional
    protected Optional<T> executeForSingleResult(String query,Object ...params) throws DaoException{
        List<T> items = executeQuery(query, params);
        if(items.size()==1){
            return Optional.of(items.get(0));
        }else if(items.size()>1){
            throw new IllegalArgumentException("More than one record found");
        }else{
            return Optional.empty();
        }
    }
}
