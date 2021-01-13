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
    private final String AUTHOR_REGEX = "^([a-z ,.'-]+)|([А-яа-я ,.'-]+)$";
    private final String TITLE_REGEX = "^([a-z ,.'-]+)|([А-яа-я ,.'-]+)$";


    @Override
    public boolean checkCorrectnessEnteredData(Book book) throws FieldValidatorException {
        boolean isValid = true;
        String title = book.getTitle();
        if (!isCorrespondsRegex(title, TITLE_REGEX)) {
            isValid = false;
            //throw new FieldValidatorException();
        }
        String author = book.getAuthor();
        if (!isCorrespondsRegex(author, AUTHOR_REGEX)) {
            isValid = false;
            //throw new FieldValidatorException();
        }
        int pages = book.getPages();
        if (pages < MIN_PAGES_AMOUNT || pages > MAX_PAGES_AMOUNT) {
            isValid = false;
            //throw new FieldValidatorException();
        }
        Integer amount = book.getAmount();
        if (amount < MIN_BOOK_AMOUNT || (amount > MAX_BOOK_AMOUNT)) {
            isValid = false;
            //throw new FieldValidatorException();
        }
        return isValid;
    }

    private boolean isCorrespondsRegex(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
