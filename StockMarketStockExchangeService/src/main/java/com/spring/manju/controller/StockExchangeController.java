package com.spring.manju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.manju.bean.StockExchange;
import com.spring.manju.service.StockExchangeService;

@RestController
public class StockExchangeController {

	@Autowired
	StockExchangeService service;

	// TO GET ALL STOCK EXCHANGE
	@RequestMapping(value = "/exchange/all", method = RequestMethod.GET)
	public ResponseEntity<List<StockExchange>> getStockExchangeList() {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.getAllStockExchange());
	}

	// TO ADD STOCK TO EXCHANGE MARKET
	@RequestMapping(value = "/exchange/add", method = RequestMethod.POST)
	public ResponseEntity<StockExchange> addStockExchangeList(@RequestBody StockExchange exchange) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.addStockExchange(exchange));
	}

	// TO GET STOCKS OF COMPANIES
	@RequestMapping(value = "/exchange/{exchange}/companies", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getCompaniesByExchange(@PathVariable String exchange) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.getCompaniesByExchange(exchange));
	}

}
