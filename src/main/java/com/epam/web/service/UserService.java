package com.epam.web.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.user.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import com.epam.web.util.CustomCipher;

import java.sql.SQLException;
import java.util.Optional;


public class UserService {
    private DaoHelperFactory daoHelperFactory;
    private CustomCipher cipher;

    public UserService() {
        this.daoHelperFactory = new DaoHelperFactory();
        this.cipher = new CustomCipher();
    }

    public Optional<User> login(String login, String password) throws ServiceException{

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            Optional<User> userOptional=userDao.findUserByLoginAndPassword(login, password);
            return userOptional;
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void updateUser(User user) throws ServiceException{
        try(DaoHelper daoHelper= daoHelperFactory.create()){
            UserDao dao=daoHelper.createUserDao();
            dao.save(user);
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
