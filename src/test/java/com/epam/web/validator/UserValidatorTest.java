package com.epam.web.validator;

import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import org.junit.Assert;
import org.junit.Test;

public class UserValidatorTest {
    @Test
    public void testUserValidatorShouldReturnTrueWhenDataCorrect() {
        //given
        User userCorrect = new User(1, "login", "pass", "Name", "Surname", Role.READER, false);
        Validator<User> userValidator = new UserValidator();

        //when
        boolean actual = userValidator.isInputDataCorrect(userCorrect);

        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testUserValidatorShouldReturnFalseWhenDataIncorrect() {
        //given
        User userIncorrect = new User(2, "abcdefABCDEF1234567890", "pass", "name", "surname", Role.READER, false);
        Validator<User> userValidator = new UserValidator();

        //when
        boolean actual = userValidator.isInputDataCorrect(userIncorrect);

        //then
        Assert.assertFalse(actual);
    }
}
