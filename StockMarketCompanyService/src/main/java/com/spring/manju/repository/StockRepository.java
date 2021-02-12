package com.spring.manju.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.manju.bean.StockPrice;

@Repository
public interface StockRepository extends JpaRepository<StockPrice, Long> {
	
	public List<StockPrice> findAllByCompanyCodeAndDateBetween(String companyCode, Date from, Date to);

}
