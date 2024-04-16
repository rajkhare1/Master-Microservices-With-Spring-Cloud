package com.rajkhare.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("limits-service")
@Getter
@Setter
@Component
public class Configuration {
	
	private int minimum;
	private int maximum;
	

}
