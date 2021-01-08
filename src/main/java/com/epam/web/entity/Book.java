package com.epam.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Identifiable {

    //table name for books
    public static final String TABLE = "books";

    //columns for table
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String PAGES = "pages";
    public static final String AMOUNT = "amount";
    public static final String STATUS = "isDeleted";


    @Override
    public Serializable getId() {
        return id;
    }

    private Integer id;
    private String title;
    private String author;
    private int pages;
    private Integer amount;
    private Publisher publisher;
    private boolean isDeleted;

    Book() {

    }

    public Book(Integer id, String title, String author, int pages, Integer amount, Publisher publisher, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.amount = amount;
        this.publisher = publisher;
        this.isDeleted = isDeleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
