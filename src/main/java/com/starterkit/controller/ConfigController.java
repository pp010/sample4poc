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

	@RequestMapping(value = "/server", method = RequestMethod.GET)
	public String getData() {
		return String.format("configServer Value is: %s", value);
	}

}
