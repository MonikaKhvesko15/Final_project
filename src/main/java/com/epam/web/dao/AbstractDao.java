package com.epam.web.dao;

import com.epam.web.dao.extractor.FieldsExtractor;
import com.epam.web.entity.Identifiable;
import com.epam.web.exception.DaoException;
import com.epam.web.dao.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {
    private Connection connection;
    private final RowMapper<T> mapper;
    private final String tableName;
    private FieldsExtractor<T> fieldsExtractor;
    private String saveQuery;
    private String updateQuery;

    protected AbstractDao(Connection connection, RowMapper<T> mapper, String tableName, FieldsExtractor<T> fieldsExtractor,
                          String saveQuery, String updateQuery) {

        this.connection = connection;
        this.mapper = mapper;
        this.tableName = tableName;
        this.fieldsExtractor = fieldsExtractor;
        this.saveQuery = saveQuery;
        this.updateQuery = updateQuery;
    }

    // this method executes any SQL queries and return it in List
    protected List<T> executeQuery(String query, Object... params) throws DaoException {

        List<T> entities = new ArrayList<>();

        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    protected void executeUpdate(String query, Object... params) throws DaoException {

        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    //in this method we write parameters in form ? then substitute them in the statement
    private PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 1; i <= params.length; i++) {
            statement.setObject(i, params[i - 1]);
        }
        return statement;
    }

    @Override
    public Optional<T> getById(int id) throws DaoException {
        return executeForSingleResult("SELECT * FROM " + tableName + " WHERE id= " + id);
    }

    @Override
    public List<T> findAll() throws DaoException {
        return executeQuery("SELECT * FROM " + tableName);
    }

    @Override
    public void save(T item) throws DaoException {
        List<Object> objectParams = fieldsExtractor.extract(item);
        if (item.getId() == null) {
            Object[] params = objectParams.toArray();
            executeUpdate(saveQuery, params);
        } else {
            Integer id = (Integer) item.getId();
            objectParams.add(id);
            Object[] params = objectParams.toArray();
            executeUpdate(updateQuery, params);
        }
    }

    @Override
    public void removeById(int id) throws DaoException {
        executeUpdate("DELETE FROM " + tableName + " WHERE id =" + id);
    }

    // this method executes any SQL queries and return it in Optional
    protected Optional<T> executeForSingleResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More than one record found");
        } else {
            return Optional.empty();
        }
    }
}
