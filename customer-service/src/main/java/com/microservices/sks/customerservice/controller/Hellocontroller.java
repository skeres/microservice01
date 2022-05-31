package com.microservices.sks.customerservice.controller;

import com.microservices.sks.customerservice.interfaces.FeignInventory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    FeignInventory  feignInventory;

    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot ! writing from customer controller hostname "+hostname;
    }

    @GetMapping("/callInventory")
    public String getIt() {
        return "le message de retour de inventory est : "+feignInventory.getInformation();
    }
}
