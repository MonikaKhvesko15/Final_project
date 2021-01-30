package com.epam.web.validator;

import com.epam.web.entity.User;
import com.epam.web.exception.FieldValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {
    private static final int MIN_PASSWORD_LENGHT = 5;
    private static final int MAX_PASSWORD_LENGHT = 20;
    private final String LOGIN_REGEX = "[^!@#$%^&*()+=-]+";
    private final String NAME_REGEX = "([A-Z]{1}[a-z]+)|([А-Я]{1}[а-яёЁ]+)";

    @Override
    public boolean isInputDataCorrect(User user) {
        boolean isValid = true;
        String login = user.getLogin();
        if (!isCorrespondsRegex(login, LOGIN_REGEX)) {
            isValid = false;
        }
        String name = user.getFirstname();
        if (!isCorrespondsRegex(name, NAME_REGEX)) {
            isValid = false;
        }
        String surname = user.getSurname();
        if (!isCorrespondsRegex(surname, NAME_REGEX)) {
            isValid = false;
        }
        String password = user.getPassword();
        if (password.length() < MIN_PASSWORD_LENGHT || password.length() > MAX_PASSWORD_LENGHT) {
            isValid = false;
        }
        return isValid;
    }

    private boolean isCorrespondsRegex(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
