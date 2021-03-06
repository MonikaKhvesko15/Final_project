package com.epam.web.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The {@code Order} class represents Order
 *
 * @author Monika Khvesko
 * @version 1.0
 */
public class Order implements Identifiable {
    //table name for orders
    public static final String TABLE = "orders";

    //columns for table
    public static final String ID = "id";
    public static final String ISSUE_DATE = "issue_date";
    public static final String RETURN_DATE = "return_date";
    public static final String STATUS = "status";
    public static final String TYPE = "type";
    public static final String USER_ID = "user_id";
    public static final String BOOK_ID = "book_id";

    public enum Status {
        ACCEPTED,
        UNDER_CONSIDERATION,
        COMPLETED,
        REJECTED;
    }

    public enum Type {
        READER_ROOM,
        SUBSCRIPTION;
    }

    private final Integer id;
    private final LocalDate issueDate;
    private final LocalDate returnDate;
    private final Status status;
    private final Type type;
    private final Integer bookId;
    private final Integer userId;


    public Order(Integer id, LocalDate issueDate, LocalDate returnDate, Status status, Type type, Integer bookId, Integer userId) {
        this.id = id;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.type = type;
        this.bookId = bookId;
        this.userId = userId;
    }

    @Override
    public Serializable getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Status getStatus() {
        return status;
    }

    public Type getType() {
        return type;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Integer getUserId() {
        return userId;
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
                Objects.equals(bookId, order.bookId) &&
                Objects.equals(userId, order.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issueDate, returnDate, status, type, bookId, userId);
    }
}
