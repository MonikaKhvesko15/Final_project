package com.epam.web.entity;
import com.epam.web.entity.dto.Order;
import com.epam.web.entity.dto.Order.Status;
import com.epam.web.entity.dto.Order.Type;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderDto implements Identifiable {

    private final Integer id;
    private final LocalDate issueDate;
    private final LocalDate returnDate;
    private final Order.Status status;
    private final Order.Type type;
    private final Integer bookId;
    private final Integer userId;


    public OrderDto(Integer id, LocalDate issueDate, LocalDate returnDate, Status status, Type type, Integer bookId, Integer userId) {
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
}
