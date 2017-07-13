package com.starterkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CircuitBreakerService {
	



	@Value("${request_Volume_Threshold}")
	String requestVolumeThreshold;
	
	@Value("${sleep_Window_In_Milliseconds}")
	String sleepWindowInMilliseconds;

	@Autowired
	RestTemplate restTemplate;
	


	@HystrixCommand(fallbackMethod = "getBackupGuide", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5") })
	public String getGuide() {
		System.out.println("<inside getGuid>");
		return restTemplate.getForObject("//mservice/config/server", String.class);
	}

	public String getBackupGuide() {
		System.out.println("<inside getbackupGuide>");
		return "server is DOWN";
	}
}
