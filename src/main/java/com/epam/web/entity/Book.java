package com.epam.web.entity;



import java.io.Serializable;

public class Book implements Identifiable {

    //table name for books
    public static final String TABLE = "books";

    //columns for table
    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String NUMB_OF_PAGES = "numb_of_pages";
    public static final String YEAR_OF_PUBLISHING = "year_of_publishing";
    public static final String AMOUNT = "amount";

    @Override
    public Serializable getId() {
        return null;
    }
}
