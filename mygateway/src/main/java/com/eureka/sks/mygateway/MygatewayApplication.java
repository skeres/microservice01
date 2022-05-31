package com.eureka.sks.mygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MygatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MygatewayApplication.class, args);
	}

	/*
	use case 1 : bean below "dynamicRoutes" is in comment (not active )
	use http://localhost:8888/customers/ or http://localhost:8888/products or http://localhost:8888/customers/1
	to see load balancer effect

	use case 2 : bean below "dynamicRoutes" is NOT in comment ( active ! )
	use http://localhost:8888/INVENTORY-SERVICE/products/1 to see load balancer effect
	 */


	@Bean
	public DiscoveryClientRouteDefinitionLocator dynamicRoutes(org.springframework.cloud.client.discovery.ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties) {
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
	}



}
