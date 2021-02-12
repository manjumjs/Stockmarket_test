package com.spring.manju;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.manju.bean.CompanyEntity;
import com.spring.manju.bean.IpoDetail;
import com.spring.manju.bean.StockPrice;
import com.spring.manju.repository.CompanyRepository;
import com.spring.manju.repository.IpoRepository;
import com.spring.manju.repository.StockRepository;
import com.spring.manju.service.CompanyServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class StockMarketApplicationTests {
	@Autowired
	CompanyServiceImpl cs;
	@MockBean
	CompanyRepository companyRepoMock;
	@MockBean
	StockRepository stockRepo;
	@MockBean
	IpoRepository ipoRepo;

	@Test
	public void testgetAllCompanies() {
		List<CompanyEntity> listExpected = new ArrayList<>();
		listExpected.add(createCompanyEntity());
		when(companyRepoMock.findAll()).thenReturn(listExpected);

		List<CompanyEntity> actual = cs.getAllCompanies();

		assertEquals(listExpected.get(0).getId(), actual.get(0).getId());
		assertEquals(listExpected.get(0).getCeo(), actual.get(0).getCeo());

	}

	@Test
	public void testaddCompany() {
		when(companyRepoMock.save(Mockito.any(CompanyEntity.class))).thenReturn(createCompanyEntity());

		CompanyEntity actual = cs.addCompany(createCompanyEntity());
		assertEquals(createCompanyEntity().getId(), actual.getId());
		assertEquals(createCompanyEntity().getCeo(), actual.getCeo());

	}

	@Test
	public void testgetCompanyByCompanyCode() {
		when(companyRepoMock.findByCompanyCode(Mockito.anyString())).thenReturn(createCompanyEntity());
		CompanyEntity actual = cs.getCompanyByCompanyCode(Mockito.anyString());

		assertEquals(createCompanyEntity().getId(), actual.getId());
		assertEquals(createCompanyEntity().getCeo(), actual.getCeo());
	}

	
	@Test
	public void testgetCompanyStockPrice() {
		
		
		List<StockPrice> expectedList = new ArrayList<>();
		expectedList.add(createStockPrice());
		when(stockRepo.findAllByCompanyCodeAndDateBetween(Mockito.anyString(), Mockito.any(Date.class), 
				Mockito.any(Date.class)))
				.thenReturn(expectedList);
		double actual = cs.getCompanyStockPrice("ABC", "2020-02-12", "2020-02-17");
		assertEquals(Double.toString(expectedList.get(0).getCurrent_price()), Double.toString(actual));

	}
	
	@Test
	public void testgetIpoDetails()
	{
		when(ipoRepo.findByCompanyName(Mockito.any(String.class))).thenReturn(createIpoEntity());
		
	}

	public CompanyEntity createCompanyEntity() {
		CompanyEntity c = new CompanyEntity();
		c.setId(1l);
		c.setCeo("abc");
		return c;
	}
	
	public IpoDetail createIpoEntity() {
		IpoDetail c = new IpoDetail();
		c.setCompanyName("abc");
		c.setPrice_per_share(6532.5f);
		
		return c;
	}

	public StockPrice createStockPrice() {
		StockPrice sp = new StockPrice();
		sp.setCompanyCode("ABC");
		sp.setCurrent_price(1347.5f);

		return sp;

	}

}
