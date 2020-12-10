package com.epam.web.mapper;

import com.epam.web.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    //create user from columns in database
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        int user_id = resultSet.getInt(User.USER_ID);
        String name = resultSet.getString(User.FIRSTNAME);
        String login = resultSet.getString(User.LOGIN);
        String password = resultSet.getString(User.PASSWORD);
        String firstname = resultSet.getString(User.FIRSTNAME);
        String surname = resultSet.getString(User.SURNAME);
        User.Role role = (User.Role) resultSet.getObject(User.ROLE);
        User.Status status = (User.Status) resultSet.getObject(User.STATUS);

        return new User(user_id, login, password, firstname, surname, role, status);
    }
}
