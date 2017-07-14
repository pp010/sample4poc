package com.sample4poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CircuitBreakerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "onebackup", commandKey = "one")
	public String one() {
		System.out.println("<inside one>");
		return restTemplate.getForObject("http://server.cfapps.io/server", String.class);
	}

	public String onebackup() {
		System.out.println("<inside onebackup>");
		return "server is DOWN";
	}
	
	@HystrixCommand(fallbackMethod = "twobackup", commandKey = "two")
	public String two() {
		System.out.println("<inside two>");
		return restTemplate.getForObject("http://server.cfapps.io/server", String.class);
	}

	public String twobackup() {
		System.out.println("<inside twobackup>");
		return "server is DOWN";
	}
	
	@HystrixCommand(fallbackMethod = "threebackup", commandKey = "three")
	public String three() {
		System.out.println("<inside three>");
		return restTemplate.getForObject("http://server.cfapps.io/server", String.class);
	}

	public String threebackup() {
		System.out.println("<inside threebackup>");
		return "server is DOWN";
	}

}
