package com.sample4poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/circuitbreaker")
public class CircuitBreakerController {
	
	@Autowired
	CircuitBreakerService circuitBreakerService;

	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public String one() {
		return circuitBreakerService.one();
	}
	
	@RequestMapping(value = "/two", method = RequestMethod.GET)
	public String two() {
		return circuitBreakerService.two();
	}
	
	@RequestMapping(value = "/three", method = RequestMethod.GET)
	public String three() {
		return circuitBreakerService.three();
	}

}
