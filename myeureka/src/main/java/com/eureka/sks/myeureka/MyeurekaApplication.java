package com.eureka.sks.myeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyeurekaApplication.class, args);
	}

}
