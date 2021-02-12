package com.spring.manju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.manju.bean.StockExchange;

@Repository
public interface ExchangeRepository extends JpaRepository<StockExchange,Long> {

}
