package com.rajkhare.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rajkhare.currencyconversionservice.bean.CurrencyConversion;
import com.rajkhare.currencyconversionservice.clients.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> calculateCurrencyConversion(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity){
		
		HashMap<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		
		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables );
		
		CurrencyConversion body = responseEntity.getBody();
		
		CurrencyConversion response = new CurrencyConversion();
		response.setId(body.getId());
		response.setFrom(from);
		response.setTo(to);
		response.setQuantity(quantity);
		response.setConversionMultiple(body.getConversionMultiple());
		response.setTotalCalculatedAmount(quantity.multiply(body.getConversionMultiple()));
		response.setEnvironment(body.getEnvironment()+" rest template");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> calculateCurrencyConversionFeign(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity){
		ResponseEntity<CurrencyConversion> feignResponse = proxy.getExchangeValue(from, to);
		CurrencyConversion body = feignResponse.getBody();
		
		CurrencyConversion response = new CurrencyConversion();
		response.setId(body.getId());
		response.setFrom(from);
		response.setTo(to);
		response.setQuantity(quantity);
		response.setConversionMultiple(body.getConversionMultiple());
		response.setTotalCalculatedAmount(quantity.multiply(body.getConversionMultiple()));
		response.setEnvironment(body.getEnvironment()+" feign");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
