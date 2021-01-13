package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.order.OrderService;
import com.epam.web.service.order.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrdersHistoryCommand implements Command {
    private static final String CURRENT_PAGE_PARAMETER = "currentPage";
    private static final int FIRST_PAGE = 1;
    private static final int RECORDS_PER_PAGE = 20;
    private static final String ORDER_LIST_PARAMETER = "orderList";
    private static final String ORDERS_HISTORY_PAGE = "WEB-INF/views/orders_history.jsp";

    private final OrderService service;

    public OrdersHistoryCommand() {
        service = new OrderServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int currentPage;

        if (request.getParameter(CURRENT_PAGE_PARAMETER) != null) {
            currentPage = Integer.parseInt(request.getParameter(CURRENT_PAGE_PARAMETER));
        } else {
            currentPage = FIRST_PAGE;
        }

        List<OrderDto> orderList = service.getAllOrdersDtoPart((currentPage - 1) * RECORDS_PER_PAGE, RECORDS_PER_PAGE);

        request.setAttribute(ORDER_LIST_PARAMETER, orderList);
        request.setAttribute(CURRENT_PAGE_PARAMETER, currentPage);
        return CommandResult.forward(ORDERS_HISTORY_PAGE);
    }
}
