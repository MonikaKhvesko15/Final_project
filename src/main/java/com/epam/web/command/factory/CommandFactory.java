package com.epam.web.command.factory;

import com.epam.web.command.impl.EditUserCommand;
import com.epam.web.command.impl.GoToPageCommand;
import com.epam.web.command.impl.LoginCommand;
import com.epam.web.command.impl.LogoutCommand;

public class CommandFactory {

    private static final String LOGIN_COMMAND = "login";
    private static final String LOGOUT_COMMAND = "logout";
    private static final String EDIT_USER_COMMAND = "edit_user";


    private static final String LOGIN_PAGE_COMMAND = "login_page";
    private static final String LOGIN_PAGE = "WEB-INF/views/login.jsp";

    private static final String READER_HOME_PAGE_COMMAND = "reader_home_page";
    private static final String READER_HOME_PAGE = "WEB-INF/views/reader_home_page.jsp";

    private static final String LIBRARIAN_HOME_PAGE_COMMAND = "librarian_home_page";
    private static final String LIBRARIAN_HOME_PAGE = "WEB-INF/views/librarian_home_page.jsp";

    private static final String ADMIN_HOME_PAGE_COMMAND = "admin_home_page";
    private static final String ADMIN_HOME_PAGE = "WEB-INF/views/admin_home_page.jsp";

    private static final String MESSAGE_PAGE_COMMAND = "message_page";
    private static final String MESSAGE_PAGE = "WEB-INF/views/message.jsp";


    public static Command create(String сommandName) {
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            case LOGIN_PAGE_COMMAND:
                return new GoToPageCommand(LOGIN_PAGE);
            case LOGOUT_COMMAND:
                return new LogoutCommand();
            case READER_HOME_PAGE_COMMAND:
                return new GoToPageCommand(READER_HOME_PAGE);
            case LIBRARIAN_HOME_PAGE_COMMAND:
                return new GoToPageCommand(LIBRARIAN_HOME_PAGE);
            case ADMIN_HOME_PAGE_COMMAND:
                return new GoToPageCommand(ADMIN_HOME_PAGE);
            case MESSAGE_PAGE_COMMAND:
                return new GoToPageCommand(MESSAGE_PAGE);
            case EDIT_USER_COMMAND:
                return new EditUserCommand();

            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
