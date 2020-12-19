package com.epam.web.controller;

import com.epam.web.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    private static final String COMMAND_PARAMETER = "command";
    public static final String ADMIN_WORD = "admin";
    public static final String ROLE = "role";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String command = request.getParameter(COMMAND_PARAMETER);
        //
        if (command != null && command.contains(ADMIN_WORD)) {
            HttpSession session = request.getSession();
            User.Role role = (User.Role) session.getAttribute(ROLE);
            if (!User.Role.ADMIN.equals(role)) {
                response.sendError(404);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
