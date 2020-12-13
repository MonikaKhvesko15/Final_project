package com.epam.web.command.factory;

import com.epam.web.command.impl.GoToPageCommand;
import com.epam.web.command.impl.LoginCommand;

public class CommandFactory {

    private static final String LOGIN_COMMAND = "login";
    private static final String MAIN_PAGE_COMMAND = "main_page";

    public static Command create(String сommandName) {
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
