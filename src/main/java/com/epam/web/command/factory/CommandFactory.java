package com.epam.web.command.factory;

import com.epam.web.command.impl.*;

public class CommandFactory {

    private static final String LOGIN_COMMAND = "login";
    private static final String LOGOUT_COMMAND = "logout";
    private static final String EDIT_USER_COMMAND = "edit_user";
    private static final String BOOK_CATALOG_COMMAND = "book_catalog";


    private static final String LOGIN_PAGE_COMMAND = "login_page";
    private static final String LOGIN_PAGE = "WEB-INF/views/login.jsp";

    private static final String HOME_PAGE_COMMAND = "home_page";
    private static final String HOME_PAGE = "WEB-INF/views/home_page.jsp";

    public static Command create(String сommandName) {
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            case LOGIN_PAGE_COMMAND:
                return new GoToPageCommand(LOGIN_PAGE);
            case LOGOUT_COMMAND:
                return new LogoutCommand();
            case HOME_PAGE_COMMAND:
                return new GoToPageCommand(HOME_PAGE);
            case EDIT_USER_COMMAND:
                return new EditUserCommand();
            case BOOK_CATALOG_COMMAND:
                return new ViewAllBooksCommand();

            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
