package com.microservices.sks.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class Hellocontroller {

    @Value("${server.name.variable}")
    private String hostname;

    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot ! writing from inventory controller hostname "+hostname;
    }

    @GetMapping("/test")
    public String answerToInventoryService() {
        return "le test fonctionne";
    }


}
