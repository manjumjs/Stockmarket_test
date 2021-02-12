package com.spring.manju.service;

import java.util.List;

import com.spring.manju.bean.StockExchange;

public interface StockExchangeService {
	
	public List<StockExchange> getAllStockExchange();
    public StockExchange addStockExchange(StockExchange exchange);
    public List<String> getCompaniesByExchange(String stockExchange);

}
