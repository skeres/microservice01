package com.microservices.sks.customerservice.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "inventory-service")
public interface FeignInventory {

    @GetMapping(value = "/test")
    public String getInformation();

}
