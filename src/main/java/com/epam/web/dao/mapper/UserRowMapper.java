package com.epam.web.dao.mapper;

import com.epam.web.entity.Role;
import com.epam.web.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    //create user from columns in database
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(User.ID);
        String name = resultSet.getString(User.FIRSTNAME);
        String login = resultSet.getString(User.LOGIN);
        String password = resultSet.getString(User.PASSWORD);
        String firstname = resultSet.getString(User.FIRSTNAME);
        String surname = resultSet.getString(User.SURNAME);

        String roleString = resultSet.getString(User.ROLE);
        Role role = Role.valueOf(roleString.toUpperCase());

        boolean isBlocked = resultSet.getBoolean(User.STATUS);

        return new User(id, login, password, firstname, surname, role, isBlocked);
    }
}
