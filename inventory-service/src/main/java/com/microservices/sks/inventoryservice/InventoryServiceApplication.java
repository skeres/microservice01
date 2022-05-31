package com.microservices.sks.inventoryservice;

import com.microservices.sks.inventoryservice.model.Product;
import com.microservices.sks.inventoryservice.service.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner  {
	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceApplication.class);

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productRepository.save(new Product(0, "Apple 200", 1200));
		productRepository.save(new Product(0, "Zen Book",750));
		productRepository.save(new Product(0, "Lenovo", 980));
		productRepository.findAll().forEach(System.out::println);
	}
}
