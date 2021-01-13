package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.user.UserService;
import com.epam.web.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewLibrariansCommand implements Command {
    private static final String CURRENT_PAGE_PARAMETER = "currentPage";
    private static final int FIRST_PAGE = 1;
    private static final int RECORDS_PER_PAGE = 20;
    private static final String LIBRARIAN_LIST_PARAMETER = "librarianList";
    private static final String LIBRARIANS_PAGE = "WEB-INF/views/all_librarians.jsp";

    private final UserService service;

    public ViewLibrariansCommand() {
        service = new UserServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int currentPage;

        if (request.getParameter(CURRENT_PAGE_PARAMETER) != null) {
            currentPage = Integer.parseInt(request.getParameter(CURRENT_PAGE_PARAMETER));
        } else {
            currentPage = FIRST_PAGE;
        }

        List<User> librarianList = service.getLibrariansPart((currentPage - 1) * RECORDS_PER_PAGE, RECORDS_PER_PAGE);

        request.setAttribute(LIBRARIAN_LIST_PARAMETER, librarianList);
        request.setAttribute(CURRENT_PAGE_PARAMETER, currentPage);

        return CommandResult.forward(LIBRARIANS_PAGE);
    }
}
