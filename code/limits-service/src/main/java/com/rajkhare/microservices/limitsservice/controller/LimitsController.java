package com.rajkhare.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajkhare.microservices.limitsservice.bean.Limit;
import com.rajkhare.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration config;

	@GetMapping("/limits")
	public Limit getLimit() {
		return Limit.builder().minimum(config.getMinimum()).maximum(config.getMaximum()).build();
	}
}
