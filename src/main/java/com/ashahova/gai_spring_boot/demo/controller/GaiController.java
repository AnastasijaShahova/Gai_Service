package com.ashahova.gai_spring_boot.demo.controller;


import com.ashahova.gai_spring_boot.demo.service.NumberGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GaiController {

    @Autowired
    NumberGenerationService numberGenerationService;

    @GetMapping("/gai/rest/random")
    public String addRandom() {
        return numberGenerationService.addRandom();
    }
    @GetMapping("/gai/rest/next")
    public String addNext()  {
        return numberGenerationService.addNext();
    }
}