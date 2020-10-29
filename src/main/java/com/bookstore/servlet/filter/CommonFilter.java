package com.bookstore.servlet.filter;

import lombok.extern.log4j.Log4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebFilter({ "/login", "/logout", "/registration"})
public class CommonFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("new incoming request to " + ((HttpServletRequest)servletRequest).getServletPath());

        ((HttpServletResponse)servletResponse).addHeader("StackId", "product-app");

        filterChain.doFilter(servletRequest,servletResponse);

        log.info("Welcome ");
    }

    @Override
    public void destroy() {

    }
}
