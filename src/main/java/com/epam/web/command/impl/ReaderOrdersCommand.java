package com.epam.web.command.impl;

import com.epam.web.command.CommandResult;
import com.epam.web.command.factory.Command;
import com.epam.web.entity.User;
import com.epam.web.entity.dto.OrderDto;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.order.OrderService;
import com.epam.web.service.order.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

public class ReaderOrdersCommand implements Command {
    private static final String CURRENT_PAGE_PARAMETER = "currentPage";
    private static final int FIRST_PAGE = 1;
    private static final int RECORDS_PER_PAGE = 20;
    private static final String ORDER_LIST_PARAMETER = "orderList";
    private static final String MY_ORDERS_PAGE = "WEB-INF/views/my_orders.jsp";
    private static final String CURRENT_DATA_ATTRIBUTE = "currentData";
    private static final String USER_ATTRIBUTE = "user";

    private final OrderService service;

    public ReaderOrdersCommand() {
        service = new OrderServiceImpl();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int currentPage;
        HttpSession session = request.getSession();

        if (request.getParameter(CURRENT_PAGE_PARAMETER) != null) {
            currentPage = Integer.parseInt(request.getParameter(CURRENT_PAGE_PARAMETER));
        } else {
            currentPage = FIRST_PAGE;
        }

        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        Integer userId = (Integer) user.getId();

        List<OrderDto> orderList = service.getReaderOrdersDtoPart(userId,(currentPage - 1) * RECORDS_PER_PAGE, RECORDS_PER_PAGE);

        request.setAttribute(ORDER_LIST_PARAMETER, orderList);
        request.setAttribute(CURRENT_PAGE_PARAMETER, currentPage);
        request.setAttribute(CURRENT_DATA_ATTRIBUTE, LocalDate.now());

        return CommandResult.forward(MY_ORDERS_PAGE);
    }
}
