package com.epam.web.validator;

import com.epam.web.entity.User;
import com.epam.web.exception.FieldValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {
    private final String LOGIN_REGEX = "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d_]{0,20}$";
    //private final String PASSWORD_REGEX="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$";
    private final String NAME_REGEX = "([A-Z]{1}[a-z]+)|([А-Я]{1}[а-я]+)";

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
        return isValid;
    }

    private boolean isCorrespondsRegex(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
