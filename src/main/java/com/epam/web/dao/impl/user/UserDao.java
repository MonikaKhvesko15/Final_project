package com.epam.web.dao.impl.user;

import com.epam.web.dao.Dao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * The {@code UserDao} interface complements Dao and represents specific method signatures
 * to work with User.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public interface UserDao extends Dao<User> {

    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;

    void updateFirstnameAndSurnameById(int id, String firstname, String surname) throws DaoException;

    List<User> findReadersPart(int startPosition, int endPosition) throws DaoException;

    List<User> findLibrariansPart(int startPosition, int endPosition) throws DaoException;

    void blockUser(int id) throws DaoException;

    void unblockUser(int id) throws DaoException;
}
