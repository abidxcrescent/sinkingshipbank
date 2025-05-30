package com.abid.sinkingship.filtters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
    Sequence followed in Springboot is
        request ->
    a: servlet container ->
    b. filter chain:
            filter1 ->
            filter2 ->
            .
    c. dispatcher servlet (handles all requests "/*") ->
    d. interceptor
    e. controller
 */
public class MyFirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFirstFilter before doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MyFirstFilter after doFilter");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
