package com.abid.sinkingship.config;

import com.abid.sinkingship.filtters.MyFirstFilter;
import com.abid.sinkingship.filtters.MySecondFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterAppConfig {


    @Bean
    public FilterRegistrationBean<MyFirstFilter> myFirstFilter() {
        FilterRegistrationBean<MyFirstFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFirstFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MySecondFilter> mySecondFilter() {
        FilterRegistrationBean<MySecondFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MySecondFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }


}
