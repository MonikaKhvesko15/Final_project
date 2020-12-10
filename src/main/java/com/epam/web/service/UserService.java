package com.epam.web.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.user.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import com.epam.web.mapper.RowMapper;
import com.epam.web.mapper.UserRowMapper;
import com.epam.web.util.CustomCipher;
import com.epam.web.validator.UserValidator;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Optional;


public class UserService {
    private DaoHelperFactory daoHelperFactory;
    private CustomCipher cipher;

    public UserService() {
        this.daoHelperFactory = new DaoHelperFactory();
        this.cipher = new CustomCipher();
    }

    public boolean verifyCredentials(String login, String password) throws ServiceException {
        return getUserByLoginAndPassword(login, password).isPresent();
    }

    public Optional<User> getUserByLoginAndPassword(String login, String password) throws ServiceException {
        Optional<User> user = null;
        try (DaoHelper factory = daoHelperFactory.create()) {
            if (UserValidator.isLoginValid(login) && UserValidator.isPasswordValid(password)) {

                UserDao dao = factory.createUserDao();

                String encryptedPassword = cipher.encrypt(password);
                user = dao.findUserByEmailAndPassword(login, encryptedPassword);
            }
        } catch (DaoException | NoSuchAlgorithmException | SQLException e) {
            throw new ServiceException("Error while checking user for presence in database", e);
        }
        return user;
    }
}
