package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Order;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.order.OrderService;
import com.epam.web.service.order.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

public class OrderBookCommand implements Command {
    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";
    private static final String USER_ID_ATTRIBUTE = "userId";
    private static final String ISSUE_TYPE_PARAMETER = "issue_type";
    private static final String BOOK_ID_PARAMETER = "bookId";
    private static final String BOOK_ORDERED = "bookOrdered";

    private final OrderService orderService;

    public OrderBookCommand() {

        orderService = new OrderServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            HttpSession session = request.getSession();

            Integer userId = (Integer.valueOf(session.getAttribute(USER_ID_ATTRIBUTE).toString()));

            String issueTypeString = request.getParameter(ISSUE_TYPE_PARAMETER);
            Order.Type issueType = Order.Type.valueOf(issueTypeString.toUpperCase());

            String bookIdString = request.getParameter(BOOK_ID_PARAMETER);
            Integer bookId = Integer.parseInt(bookIdString);

            LocalDate issueDate = LocalDate.now();
            LocalDate returnDate = LocalDate.now();
            if (issueType == Order.Type.SUBSCRIPTION) {
                returnDate = issueDate.plusDays(30);
            }

            Order order = new Order(null, issueDate, returnDate, null, issueType, bookId, userId);
            orderService.createOrder(order);

            request.setAttribute(BOOK_ORDERED, true);
            return CommandResult.forward(MESSAGE_JSP);

        } catch (ServiceException | ConnectionPoolException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
