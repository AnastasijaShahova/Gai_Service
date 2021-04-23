package com.ashahova.gai_spring_boot.demo;

import com.ashahova.gai_spring_boot.demo.servlet.GaiServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServlet;

@SpringBootApplication
public class SpringBootGaiApplication {

    @Bean
    public ServletRegistrationBean exampleServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                httpServlet(), "/gai/number/random","/gai/number/next");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public HttpServlet httpServlet() {
        return new GaiServlet();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGaiApplication.class, args);
    }


}
