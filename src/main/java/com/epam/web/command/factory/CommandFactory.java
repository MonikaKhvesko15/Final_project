package com.epam.web.command.factory;

import com.epam.web.command.impl.LoginCommand;

public class CommandFactory {

    private static final String LOGIN_COMMAND = "login";

    public static Command create(String сommandName) {
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
                //...
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
