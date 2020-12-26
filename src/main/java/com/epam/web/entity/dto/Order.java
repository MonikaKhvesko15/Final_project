package com.epam.web.entity.dto;


import com.epam.web.entity.Book;
import com.epam.web.entity.Identifiable;
import com.epam.web.entity.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Order implements Identifiable {
    //table name for users
    public static final String TABLE = "orders";

    //columns for table
    public static final String ID = "id";
    public static final String ISSUE_DATE = "issue_date";
    public static final String RETURN_DATE = "return_date";
    public static final String STATUS = "status";
    public static final String TYPE = "type";


    @Override
    public Serializable getId() {
        return id;
    }


    public enum Status {
        ACCEPTED,
        UNDER_CONSIDERATION,
        FINISHED;
    }

    public enum Type {
        READER_ROOM,
        SUBSCRIPTION;
    }

    private Integer id;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private Order.Status status;
    private Order.Type type;
    private Book book;
    private User user;


    public Order() {
    }

    public Order(Integer id, LocalDate issueDate, LocalDate returnDate,Order.Status status, Order.Type type, Book book, User user) {
        this.id = id;
        this.issueDate=issueDate;
        this.returnDate=returnDate;
        this.status=status;
        this.type=type;
        this.book=book;
        this.user=user;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(issueDate, order.issueDate) &&
                Objects.equals(returnDate, order.returnDate) &&
                status == order.status &&
                type == order.type &&
                Objects.equals(book, order.book) &&
                Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issueDate, returnDate, status, type, book, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                ", type=" + type +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}
