package com.epam.web.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocaleFilter implements Filter {
    private static final String LANG_PARAMETER = "language";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String language = req.getParameter(LANG_PARAMETER);
        if (language != null) {
            req.getSession().setAttribute(LANG_PARAMETER, language);
        } else {
            req.getSession().setAttribute(LANG_PARAMETER, "ru");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
