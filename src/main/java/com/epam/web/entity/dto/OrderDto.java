package com.epam.web.entity.dto;


import com.epam.web.entity.Book;
import com.epam.web.entity.Identifiable;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

//This object now contains all the information we want to show to the end-user
public class OrderDto implements Identifiable {

    @Override
    public Serializable getId() {
        return id;
    }

    private Integer id;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private Order.Status status;
    private Order.Type type;
    private String bookTitle;
    private String bookAuthor;
    private String userName;
    private String userSurname;


    public OrderDto() {
    }

    public OrderDto(Integer id, LocalDate issueDate, LocalDate returnDate, Order.Status status, Order.Type type, String bookTitle,
                    String bookAuthor, String userName, String userSurname) {
        this.id = id;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.type = type;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.userName = userName;
        this.userSurname = userSurname;
    }


    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Order.Status getStatus() {
        return status;
    }

    public Order.Type getType() {
        return type;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }


}
