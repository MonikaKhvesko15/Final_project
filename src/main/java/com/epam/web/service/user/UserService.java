package com.epam.web.service.user;

import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> login(String login, String password) throws ServiceException;
    void updateUser(User user) throws ServiceException;
    List<User> getReadersPart(int startPosition, int endPosition) throws ServiceException;
    List<User> getLibrariansPart(int startPosition, int endPosition) throws ServiceException;
    void blockUserById(Integer id) throws ServiceException;
    void unblockUserById(Integer id) throws ServiceException;

}
