package com.epam.web.dao.user;

import com.epam.web.dao.Dao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    //specific methods for userDao

    Optional<User> findUserByEmailAndPassword(String login, String password) throws DaoException;
}
