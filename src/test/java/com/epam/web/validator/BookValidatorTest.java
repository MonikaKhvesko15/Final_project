package com.epam.web.validator;

import com.epam.web.entity.Book;
import com.epam.web.entity.Publisher;
import org.junit.Assert;
import org.junit.Test;

public class BookValidatorTest {

    @Test
    public void testBookValidatorShouldReturnTrueWhenDataCorrect() {
        //given
        Publisher publisher = new Publisher();
        Book bookCorrect = new Book(1, "Война и Мир", "Лев Толстой", 100, 10, publisher, false);
        Validator<Book> bookValidator = new BookValidator();

        //when
        boolean actual = bookValidator.isInputDataCorrect(bookCorrect);

        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testBookValidatorShouldReturnFalseWhenDataIncorrect() {
        //given
        Publisher publisher = new Publisher();
        Book bookIncorrect = new Book(2, "A", "Auhor123", -100, -10, publisher, true);
        Validator<Book> bookValidator = new BookValidator();

        //when
        boolean actual = bookValidator.isInputDataCorrect(bookIncorrect);

        //then
        Assert.assertFalse(actual);
    }
}
