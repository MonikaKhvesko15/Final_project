package com.epam.web.validator;

import java.util.Map;

public class UserValidator {
    private static final String PASSWORD_REGEX = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,16}$";
    private static final String LOGIN_REGEX = "^\\p{L}{2,25}$";
    private static final String USERNAME_REGEX = "^\\p{L}{2,25}$";

    public static boolean isLoginValid(String login) {

        return isStringCorrect(login, LOGIN_REGEX) && !login.isEmpty();
    }

    public static boolean isPasswordValid(String password) {
        return isStringCorrect(password, PASSWORD_REGEX) && !password.isEmpty();
    }

    //for firstname, surname
    public static boolean isUsernameValid(String username) {

        return isStringCorrect(username, USERNAME_REGEX) && !username.isEmpty();
    }

    private static boolean isStringCorrect(String line, String regex) {
        boolean result = false;
        if (line != null) {
            result = line.matches(regex);
        }
        return result;
    }

}

