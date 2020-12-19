package com.epam.web.service.user;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.user.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import java.sql.SQLException;
import java.util.Optional;


public class UserServiceImpl implements UserService {
    private DaoHelperFactory daoHelperFactory;

    public UserServiceImpl() {
        this.daoHelperFactory = new DaoHelperFactory();
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            Optional<User> userOptional = userDao.findUserByLoginAndPassword(login, password);
            return userOptional;
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateUser(User user) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao dao = daoHelper.createUserDao();
            dao.updateFirstnameAndSurnameById((Integer) user.getId(), user.getFirstname(), user.getSurname());
        } catch (DaoException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
