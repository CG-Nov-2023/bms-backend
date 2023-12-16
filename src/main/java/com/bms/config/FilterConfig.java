package com.bms.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bms.filter.JwtAuthenticationFilter;

@Configuration
public class FilterConfig {
	
    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> myFilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> registration = new FilterRegistrationBean<JwtAuthenticationFilter>();
        registration.setFilter(new JwtAuthenticationFilter());
        registration.addUrlPatterns("/api/books");
        return registration;
    }

}
