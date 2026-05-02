package com.example.studentapp;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new org.h2.server.web.JakartaWebServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        registrationBean.addInitParameter("webAllowOthers", "true");
        return registrationBean;
    }
}
