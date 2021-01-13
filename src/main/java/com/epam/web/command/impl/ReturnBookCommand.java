package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Book;
import com.epam.web.entity.Order;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.book.BookService;
import com.epam.web.service.book.BookServiceImpl;
import com.epam.web.service.order.OrderService;
import com.epam.web.service.order.OrderServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReturnBookCommand implements Command {
    private static final String ORDER_ID_PARAMETER = "orderId";
    private static final String BOOK_TITLE_PARAMETER = "bookTitle";
    private static final String VIEW_ORDERS_PAGE = "/controller?command=view_orders";

    private final OrderService orderService;
    private final BookService bookService;

    public ReturnBookCommand() {
        this.orderService = new OrderServiceImpl();
        this.bookService = new BookServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String orderIdString = request.getParameter(ORDER_ID_PARAMETER);
        Integer orderId = Integer.parseInt(orderIdString);

        String bookTitle = request.getParameter(BOOK_TITLE_PARAMETER);
        Book book = bookService.findBookByTitle(bookTitle).get();
        Integer bookId = (Integer) book.getId();

        Order.Status newStatus = Order.Status.COMPLETED;

        orderService.completeOrderById(orderId, bookId, newStatus);
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        return CommandResult.redirect(contextPath + VIEW_ORDERS_PAGE);
    }
}
