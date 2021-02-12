package com.spring.manju;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.manju.bean.IpoDetail;
import com.spring.manju.bean.StockExchange;
import com.spring.manju.repository.ExchangeRepository;
import com.spring.manju.repository.IpoRepository;
import com.spring.manju.service.StockExchangeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class StockMarketStockExchangeServiceApplicationTests {

	@Autowired
	private StockExchangeServiceImpl service;

	@MockBean
	private ExchangeRepository repo;

	@MockBean
	private IpoRepository ipoRepo;

	@Test
	public void testgetAllStockExchange() {

		List<StockExchange> expected = createListOfStockExchange();
		when(repo.findAll()).thenReturn(expected);

		List<StockExchange> actual = service.getAllStockExchange();

		assertEquals(expected.get(0).getStock_exchange(), actual.get(0).getStock_exchange());
		assertEquals(expected.get(0).getContact_address(), actual.get(0).getContact_address());

	}

	@Test
	public void testaddStockExchange() {
		StockExchange expected = createStockExchange();
		when(repo.save(Mockito.any(StockExchange.class))).thenReturn(expected);

		StockExchange actual = service.addStockExchange(createStockExchange());

		assertEquals(expected.getStock_exchange(), actual.getStock_exchange());
		assertEquals(expected.getContact_address(), actual.getContact_address());
	}

	@Test
	public void testgetCompaniesByExchange() {

		when(ipoRepo.getAllByStockExchange(Mockito.any(String.class))).thenReturn(createListofIpoDetail());

		List<String> actual = service.getCompaniesByExchange("NSE");

		List<String> expected = new ArrayList<>();
		expected.add("Name1");
		expected.add("Name2");

		assertEquals(expected, actual);

	}

	public List<StockExchange> createListOfStockExchange() {

		List<StockExchange> list = new ArrayList<>();

		list.add(new StockExchange("BSE", "Mumbai"));

		return list;

	}

	public StockExchange createStockExchange() {
		return new StockExchange("BSE", "Mumbai");
	}

	public List<IpoDetail> createListofIpoDetail() {
		List<IpoDetail> list = new ArrayList<>();

		list.add(new IpoDetail("Name1", "NSE", 1289.2f, 10, java.util.Calendar.getInstance().getTime(), "remarks"));
		list.add(new IpoDetail("Name2", "NSE", 128.6f, 10, java.util.Calendar.getInstance().getTime(), "remarks"));
		return list;
	}
}
