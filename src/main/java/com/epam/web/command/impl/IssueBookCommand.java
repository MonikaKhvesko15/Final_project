package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.Order;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.order.OrderService;
import com.epam.web.service.order.OrderServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IssueBookCommand implements Command {
    private static final String ORDER_ID_PARAMETER = "orderId";
    private static final String VIEW_ORDERS_PAGE = "/controller?command=view_orders";

    private final OrderService service;

    public IssueBookCommand() {
        this.service = new OrderServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String orderIdString = request.getParameter(ORDER_ID_PARAMETER);
        Integer orderId = Integer.parseInt(orderIdString);
        Order.Status newStatus = Order.Status.ACCEPTED;
        service.changeOrderStatus(orderId, newStatus);

        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        return CommandResult.redirect(contextPath + VIEW_ORDERS_PAGE);
    }
}
