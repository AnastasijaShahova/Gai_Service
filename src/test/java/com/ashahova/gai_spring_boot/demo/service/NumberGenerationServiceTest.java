package com.ashahova.gai_spring_boot.demo.service;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class NumberGenerationServiceTest {

    @Autowired
    private NumberGenerationService numberGenerationService;

    @MockBean
    private File file;

    @Test
    void addRandom() {
        String randomCreated = numberGenerationService.addRandom();
        Assert.assertNotNull(randomCreated);
    }

    @Test
    void addNext() {
        String nextCreated = numberGenerationService.addNext();
        Assert.assertNotNull(nextCreated);
    }

    @Test
    void findNumberInFile() {
        String nextCreated = numberGenerationService.addNext();
        Assert.assertTrue(file.findStringFile(nextCreated));
    }

}