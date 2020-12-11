package com.epam.web.dao.user;

import com.epam.web.dao.AbstractDao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.UserRowMapper;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login=? and password=?";

    public UserDaoImpl(Connection connection){
        super(connection,new UserRowMapper(),User.TABLE);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(
                FIND_BY_LOGIN_AND_PASSWORD,
                login,
                password);
    }

    @Override
    public Optional<User> getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(User item) {
        super.save(item);
    }

    @Override
    public void removeById(int id) {
        super.removeById(id);
    }

    protected String getTableName(){
        return User.TABLE;
    }
}
