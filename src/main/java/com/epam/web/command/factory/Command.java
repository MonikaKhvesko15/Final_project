package com.epam.web.command.factory;

import com.epam.web.command.CommandResult;
import com.epam.web.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The {@code Command} interface represents method signature for executing the command.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}
