package com.epam.web.dao.impl.user;

import com.epam.web.dao.extractor.UserFieldsExtractor;
import com.epam.web.dao.AbstractDao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.dao.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? and password = SHA1(?)";
    private static final String UPDATE_USER_NAME_SURNAME = "UPDATE users SET firstname = ?, surname = ? WHERE id = ?";
    private static final String UPDATE_USER = "UPDATE users SET login=?, firstname=?, surname=?, role=? WHERE id = ?";
    private static final String SAVE_USER = "INSERT INTO users (login, password, firstname, surname, role) VALUES (?, SHA1(?), ?, ?, ?)";
    private static final String GET_READERS_PART = "SELECT * FROM users WHERE users.role='READER' limit ?, ?";
    private static final String GET_LIBRARIANS_PART = "SELECT * FROM users WHERE users.role='LIBRARIAN' limit ?, ?";
    private static final String SET_BLOCK_STATUS = "UPDATE users SET isBlocked=1 WHERE id= ?";
    private static final String SET_ENABLE_STATUS = "UPDATE users SET isBlocked=0 WHERE id= ?";

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

    @Override
    public List<User> findReadersPart(int startPosition, int endPosition) throws DaoException {
        return executeQuery(GET_READERS_PART, startPosition, endPosition);
    }

    @Override
    public List<User> findLibrariansPart(int startPosition, int endPosition) throws DaoException {
        return executeQuery(GET_LIBRARIANS_PART, startPosition, endPosition);
    }

    @Override
    public void blockUser(int id) throws DaoException {
        executeUpdate(SET_BLOCK_STATUS, id);
    }

    @Override
    public void unblockUser(int id) throws DaoException {
        executeUpdate(SET_ENABLE_STATUS, id);
    }

}
