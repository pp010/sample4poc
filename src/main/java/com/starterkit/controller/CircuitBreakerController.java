package com.starterkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starterkit.service.CircuitBreakerService;

@RestController
@RequestMapping(value = "/circuit")
public class CircuitBreakerController {

	@Autowired
	CircuitBreakerService circuitBreakerService;

	@RequestMapping(value = "/breaker", method = RequestMethod.GET)
	public String circuitBreaker() {
		return circuitBreakerService.getGuide();
	}

}