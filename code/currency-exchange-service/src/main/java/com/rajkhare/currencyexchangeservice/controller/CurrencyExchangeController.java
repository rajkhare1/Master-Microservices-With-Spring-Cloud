package com.rajkhare.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rajkhare.currencyexchangeservice.bean.CurrencyExchange;
import com.rajkhare.currencyexchangeservice.dao.CurrencyExchangeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<CurrencyExchange> getExchangeValue(@PathVariable String from,
			@PathVariable String to){
		
		log.info("getExchangeValue called with {} to {}",from,to);
		
		String port = environment.getProperty("local.server.port");
		
		CurrencyExchange response = repository.findByFromAndTo(from, to);
		
		if(response == null)
			throw new RuntimeException("Unable to find the data for "+from+" to "+to);
		
		response.setEnvironment(port);
		
		return new ResponseEntity<>(response,HttpStatusCode.valueOf(200));
	}

}
