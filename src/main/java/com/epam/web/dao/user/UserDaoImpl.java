package com.epam.web.dao.user;

import com.epam.web.dao.extractor.UserFieldsExtractor;
import com.epam.web.dao.AbstractDao;
import com.epam.web.entity.Book;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.dao.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? and password = SHA1(?)";
    private static final String UPDATE_USER_NAME_SURNAME = "UPDATE users SET firstname = ?, surname = ? WHERE id = ?";
    private static final String UPDATE_USER = "UPDATE users SET login=?, password=?, firstname=?, surname=?, role=?, isBlocked=? WHERE id = ?";
    private static final String SAVE_USER = "INSERT INTO users (login, password, firstname, surname, role, isBlocked) VALUES (?, ?, ?, ?, ?, ?)";

    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper(), User.TABLE, new UserFieldsExtractor(), SAVE_USER, UPDATE_USER);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(
                FIND_BY_LOGIN_AND_PASSWORD,
                login,
                password);
    }


    @Override
    public void updateFirstnameAndSurnameById(int id, String firstname, String surname) throws DaoException {
        executeUpdate(UPDATE_USER_NAME_SURNAME, firstname, surname, id);
    }

}
