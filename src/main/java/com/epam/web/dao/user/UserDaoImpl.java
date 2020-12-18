package com.epam.web.dao.user;

import com.epam.web.collector.UserParameterCollector;
import com.epam.web.dao.AbstractDao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.UserRowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? and password = SHA1(?)";
    private static final String UPDATE_USER = "UPDATE users set firstname = ?, surname = ? where id = ?";

    public UserDaoImpl(Connection connection){
        super(connection,new UserRowMapper(),User.TABLE,new UserParameterCollector());
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

    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_USER;
    }

    @Override
    public void removeById(int id) {
        super.removeById(id);
    }

    protected String getTableName(){
        return User.TABLE;
    }
}
