package com.mars;

import com.mars.filter.RestExceptionHandlerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Autowired
    private RestExceptionHandlerFilter restExceptionfilter;

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(restExceptionfilter);
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        return registration;
    }

}
