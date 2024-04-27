package com.rajkhare.currencyexchangeservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CircuitBreakerController {

	@GetMapping("/sample-api")
//	@Retry(name = "sample-api",fallbackMethod = "hardCodedFallbackMethod")
//	@CircuitBreaker(name = "default",fallbackMethod = "hardCodedFallbackMethod")
	@RateLimiter(name = "default")
	public String sampleApi() {
		log.info("Sample Api call received");
//		ResponseEntity<String> forEntity = new RestTemplate()
//				.getForEntity("http://localhost:8080/some-dummy-url",String.class);
//		return forEntity.getBody();
		
		return "sample-api";
	}
	
	public String hardCodedFallbackMethod(Exception ex) {
		return "fallback-response";
	}
}
