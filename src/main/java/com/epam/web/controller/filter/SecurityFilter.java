//package com.epam.web.controller.filter;
//
//import com.epam.web.command.CommandResult;
//import com.epam.web.controller.filter.context.AccessContext;
//import com.epam.web.controller.filter.context.AccessContextHelper;
//import com.epam.web.entity.User;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//public class SecurityFilter implements Filter {
//
//    private static final String COMMAND_PARAMETER = "command";
//    private static final List<String> AVAILABLE_COMMAND = Arrays.asList("login_page", "home_page", "login");
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
////        HttpServletRequest request = (HttpServletRequest) servletRequest;
////        HttpServletResponse response = (HttpServletResponse) servletResponse;
////        HttpSession session = request.getSession();
////        String command = request.getParameter(COMMAND_PARAMETER);
////
////        if (command != null && !AVAILABLE_COMMAND.contains(command)) {
////            String roleString = session.getAttribute(User.ROLE).toString();
////            User.Role currentRole = User.Role.valueOf(roleString.toUpperCase());
////            AccessContextHelper accessContextHelper = new AccessContextHelper();
////            AccessContext accessContext = accessContextHelper.create(currentRole);
////
////            if (!accessContext.isContainsCommand(currentRole, command)) {
////                response.sendError(403);
////            }
////        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
