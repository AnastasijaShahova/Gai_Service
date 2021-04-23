package com.ashahova.gai_spring_boot.demo.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NumberStorage {

    private File file;

    @PostConstruct
    public void init() {
        file = new File();
    }

}
