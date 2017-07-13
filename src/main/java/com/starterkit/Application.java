/**
 * 
 */
package com.starterkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * This is a Spring boot application class which implements a CommandLineRunner.
 * This class will create and load all the required beans during runtime
 * 
 * @author Anand.Kittappa@cognizant.com.
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class Application {
	/**
	 * Loading all the required beans for this demo application
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(new Object[] { Application.class }, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate rest() {
		return new RestTemplate();
	}
}
