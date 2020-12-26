package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.dto.Order;
import com.epam.web.entity.OrderDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.order.OrderService;
import com.epam.web.service.order.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

public class OrderBookCommand implements Command {

    private final OrderService orderService;
    private static final String MESSAGE_JSP = "WEB-INF/views/message.jsp";

    public OrderBookCommand() {

        orderService = new OrderServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            HttpSession session = request.getSession();

            Integer userId = (Integer.valueOf(session.getAttribute("userId").toString()));

            String issueTypeString = request.getParameter("issue_type");
            Order.Type issueType = Order.Type.valueOf(issueTypeString.toUpperCase());
            String bookIdString = request.getParameter("bookId");
            Integer bookId = Integer.parseInt(bookIdString);

            LocalDate issueDate = LocalDate.now();
            LocalDate returnDate = issueDate.plusDays(60);

            OrderDto orderDto = new OrderDto(null, issueDate, returnDate, null, issueType, bookId, userId);
            orderService.createOrder(orderDto);

            request.setAttribute("bookOrdered", true);
            return CommandResult.forward(MESSAGE_JSP);

        } catch (ServiceException | ConnectionPoolException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
