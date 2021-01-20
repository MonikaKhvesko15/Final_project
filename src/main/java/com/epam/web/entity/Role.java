package com.epam.web.entity;

import java.util.Arrays;
import java.util.List;

/**
 * The {@code Role} enum represents all possible user roles with a list of available commands.
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public enum Role {

    GUEST(Arrays.asList("login", "book_catalog", "book_search", "login_page","registration_page","registration")),
    READER(Arrays.asList("login", "logout", "edit_user", "book_catalog", "book_search", "order_book", "reader_orders", "login_page", "home_page")),
    LIBRARIAN(Arrays.asList("login", "logout", "edit_user", "view_orders", "orders_history", "issue_book", "return_book", "login_page", "home_page")),
    ADMIN(Arrays.asList("login", "logout", "edit_user", "book_catalog", "book_search", "delete_book", "edit_book", "edit_book_page", "add_book",
            "view_readers", "view_librarians", "block_user", "unblock_user", "login_page", "home_page", "add_book_page"));

    private final List<String> capabilities;

    Role(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    public boolean hasAccess(String command) {
        return capabilities.contains(command);
    }

    @Override
    public String toString() {
        return "RoleAccessContext{" +
                "capabilities=" + capabilities +
                '}';
    }
}
