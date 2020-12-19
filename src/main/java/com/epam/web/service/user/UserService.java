package com.epam.web.service.user;

import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String login, String password) throws ServiceException;
    void updateUser(User user) throws ServiceException;
}
