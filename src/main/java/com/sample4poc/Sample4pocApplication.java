package com.sample4poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class Sample4pocApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(Sample4pocApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate rest() {
		return new RestTemplate();
	}

}
