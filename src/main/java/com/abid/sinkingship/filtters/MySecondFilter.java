package com.abid.sinkingship.filtters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class MySecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("SecondFilter after");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
