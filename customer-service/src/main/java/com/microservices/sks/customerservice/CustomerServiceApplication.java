package com.microservices.sks.customerservice;

import com.microservices.sks.customerservice.model.Customer;
import com.microservices.sks.customerservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class CustomerServiceApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceApplication.class);

	@Autowired CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


		@Override
		public void run(String... args) throws Exception {
			customerRepository.save(new Customer(0, "monsieur Dupont", "dupont@gmail.com"));
			customerRepository.save(new Customer(0, "monsieur durand", "durand@gmail.com"));
			customerRepository.save(new Customer(0, "madame Reine", "reine@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
		}


}
