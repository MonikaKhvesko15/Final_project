package com.epam.web.validator;

import com.epam.web.entity.Book;
import com.epam.web.exception.FieldValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BookValidator implements Validator<Book> {
    private static final int MIN_PAGES_AMOUNT = 1;
    private static final int MAX_PAGES_AMOUNT = 3000;
    private static final int MIN_BOOK_AMOUNT = 0;
    private static final int MAX_BOOK_AMOUNT = 1000;
    private static final int MIN_TITLE_LENGHT = 2;
    private static final int MAX_TITLE_LENGHT = 50;
    private final String AUTHOR_REGEX = "([^0-9!*$?]+){2,50}";


    @Override
    public boolean isInputDataCorrect(Book book) {
        boolean isValid = true;
        String title = book.getTitle();
        if (title.length() < MIN_TITLE_LENGHT || title.length() > MAX_TITLE_LENGHT) {
            isValid = false;
        }
        String author = book.getAuthor();
        if (!isCorrespondsRegex(author, AUTHOR_REGEX)) {
            isValid = false;
        }
        int pages = book.getPages();
        if (pages < MIN_PAGES_AMOUNT || pages > MAX_PAGES_AMOUNT) {
            isValid = false;
        }
        Integer amount = book.getAmount();
        if (amount < MIN_BOOK_AMOUNT || (amount > MAX_BOOK_AMOUNT)) {
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
