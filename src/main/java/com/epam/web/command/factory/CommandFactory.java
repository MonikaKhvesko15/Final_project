package com.epam.web.command.factory;

import com.epam.web.command.impl.EditUserCommand;
import com.epam.web.command.impl.GoToPageCommand;
import com.epam.web.command.impl.LoginCommand;

public class CommandFactory {

    private static final String LOGIN_COMMAND = "login";
    private static final String EDIT_USER_COMMAND = "edit_user";

    public static Command create(String сommandName) {
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            case EDIT_USER_COMMAND:
                return new EditUserCommand();
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
