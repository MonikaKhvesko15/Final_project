package com.epam.web.command.factory;

import com.epam.web.command.impl.*;

public class CommandFactory {

    private static final String LOGIN_COMMAND = "login";
    private static final String LOGOUT_COMMAND = "logout";
    private static final String EDIT_USER_COMMAND = "edit_user";
    private static final String BOOK_CATALOG_COMMAND = "book_catalog";
    private static final String BOOK_SEARCH_COMMAND = "book_search";
    private static final String ORDER_BOOK_COMMAND = "order_book";
    private static final String VIEW_ORDERS_COMMAND = "view_orders";
    private static final String ISSUE_BOOK_COMMAND = "issue_book";
    private static final String RETURN_BOOK_COMMAND = "return_book";
    private static final String DELETE_BOOK_COMMAND = "delete_book";
    private static final String EDIT_BOOK_COMMAND = "edit_book";
    private static final String EDIT_BOOK_PAGE_COMMAND = "edit_book_page";


    private static final String LOGIN_PAGE_COMMAND = "login_page";
    private static final String LOGIN_PAGE = "WEB-INF/views/login.jsp";

    private static final String HOME_PAGE_COMMAND = "home_page";
    private static final String HOME_PAGE = "WEB-INF/views/home_page.jsp";


    //private static final String EDIT_BOOK_PAGE = "WEB-INF/views/edit_book_page.jsp";


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
                return new BookCatalogCommand();
            case BOOK_SEARCH_COMMAND:
                return new BookSearchCommand();
            case ORDER_BOOK_COMMAND:
                return new OrderBookCommand();
            case VIEW_ORDERS_COMMAND:
                return new ViewOrdersCommand();
            case ISSUE_BOOK_COMMAND:
                return new IssueBookCommand();
            case RETURN_BOOK_COMMAND:
                return new ReturnBookCommand();
            case DELETE_BOOK_COMMAND:
                return new DeleteBookCommand();
            case EDIT_BOOK_PAGE_COMMAND:
                return new EditBookPageCommand();
            case EDIT_BOOK_COMMAND:
                return new EditBookCommand();
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
