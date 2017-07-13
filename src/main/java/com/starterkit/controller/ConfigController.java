package com.starterkit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/config")
public class ConfigController {
	
	@Value("${config_value}")
	String value;
	
	@Value("${request_Volume_Threshold}")
	String requestVolumeThreshold;
	
	@Value("${sleep_Window_In_Milliseconds}")
	String sleepWindowInMilliseconds;

	@RequestMapping(value = "/server", method = RequestMethod.GET)
	public String getData() {
		return String.format("configServer Value is: %s", value);
	}
	
	@RequestMapping(value = "/sleep", method = RequestMethod.GET)
	public String getSleep() {
		return String.format("sleepWindowInMilliseconds: %s", sleepWindowInMilliseconds);
	}
	
	@RequestMapping(value = "/fallback", method = RequestMethod.GET)
	public String getFallback() {
		return String.format("requestVolumeThreshold: %s", requestVolumeThreshold);
	}
	
}
