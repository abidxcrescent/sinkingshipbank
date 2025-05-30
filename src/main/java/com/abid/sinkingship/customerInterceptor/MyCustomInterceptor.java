package com.abid.sinkingship.customerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
    Custom interceptor works on a controller which intercepts a request
    we can perform certain tasks even before request reaches the
    controller method like:
        logging
        caching
        security
 */
@Component
public class MyCustomInterceptor implements HandlerInterceptor {

    /*
        Runs before the actual controller method
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle MyCustomInterceptor");
        return true;
    }

    /*
        Runs after the controller method
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle MyCustomInterceptor");
    }

    /*
        Runs after controller method even if there is any exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion MyCustomInterceptor");
    }

}
