package com.abid.sinkingship.config;

import com.abid.sinkingship.customerInterceptor.MyCustomInterceptor;
import com.abid.sinkingship.customerInterceptor.MyCustomInterceptorAOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    MyCustomInterceptor myCustomInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myCustomInterceptor)
                .addPathPatterns("/api/*") // intercepts requests for all apis
                .excludePathPatterns("/api/deleteUsers"); // except login
    }

}
