package com.rajkhare.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajkhare.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
