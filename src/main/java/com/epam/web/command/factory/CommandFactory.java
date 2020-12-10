package com.epam.web.command.factory;

import com.epam.web.command.impl.LoginCommand;
import com.epam.web.command.impl.ShowPageCommand;

public class CommandFactory {

    private static final String LOGIN_COMMAND = "login";
    public static final String MAIN_PAGE_COMMAND = "main_page";

    public static Command create(String parameterCommand) {
        switch (parameterCommand) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            case MAIN_PAGE_COMMAND:
                return new ShowPageCommand("/WEB-INF/views/main.jsp");
                //...
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
