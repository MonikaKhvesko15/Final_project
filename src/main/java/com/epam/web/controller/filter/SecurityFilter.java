package com.epam.web.controller.filter;


import com.epam.web.entity.Role;
import com.epam.web.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    private static final String USER_ATTRIBUTE = "user";
    private static final String COMMAND_PARAMETER = "command";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        Role role = null;
        if (user != null) {
            role = user.getRole();
        } else {
            role = Role.GUEST;
            session.setAttribute(User.ROLE, role);
        }
        String command = req.getParameter(COMMAND_PARAMETER);
        if ((command == null) || role.hasAccess(command)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (role == Role.GUEST) {
            ((HttpServletResponse) servletResponse).sendError(401);
        } else {
            ((HttpServletResponse) servletResponse).sendError(403);
        }
    }

    @Override
    public void destroy() {

    }
}
