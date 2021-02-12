package com.spring.manju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.manju.bean.IpoDetail;
import com.spring.manju.bean.StockExchange;
import com.spring.manju.repository.ExchangeRepository;
import com.spring.manju.repository.IpoRepository;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {
	@Autowired
	private ExchangeRepository exchangeRepo;

	@Autowired
	private IpoRepository ipoRepo;

	@Override
	@Transactional
	public List<StockExchange> getAllStockExchange() {

		return exchangeRepo.findAll();

	}

	@Override
	@Transactional
	public StockExchange addStockExchange(StockExchange exchange) {

		exchangeRepo.save(exchange);

		return exchange;
	}

	@Override
	@Transactional
	public List<String> getCompaniesByExchange(String stockExchange) {

		List<IpoDetail> list = ipoRepo.getAllByStockExchange(stockExchange);

		List<String> companyName = new ArrayList<>();

		for (IpoDetail ipo : list) {
			companyName.add(ipo.getCompanyName());
		}

		return companyName;

	}

}
