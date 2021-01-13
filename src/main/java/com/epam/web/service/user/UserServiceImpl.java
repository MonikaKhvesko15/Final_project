package com.epam.web.service.user;

import com.epam.web.dao.impl.book.BookDao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.impl.user.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.FieldValidatorException;
import com.epam.web.exception.ServiceException;
import com.epam.web.validator.UserValidator;
import com.epam.web.validator.Validator;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {
    private DaoHelperFactory daoHelperFactory;
    private Validator<User> userValidator;

    public UserServiceImpl() {
        this.daoHelperFactory = new DaoHelperFactory();
        this.userValidator = new UserValidator();
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            Optional<User> userOptional = userDao.findUserByLoginAndPassword(login, password);
            return userOptional;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void editUser(User user) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao dao = daoHelper.createUserDao();
            if (userValidator.checkCorrectnessEnteredData(user)) {
                dao.updateFirstnameAndSurnameById((Integer) user.getId(), user.getFirstname(), user.getSurname());
            } else {
                throw new FieldValidatorException();
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> getReadersPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.findReadersPart(startPosition, endPosition);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> getLibrariansPart(int startPosition, int endPosition) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.findLibrariansPart(startPosition, endPosition);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void blockUserById(Integer id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            userDao.blockUser(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void unblockUserById(Integer id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            userDao.unblockUser(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
