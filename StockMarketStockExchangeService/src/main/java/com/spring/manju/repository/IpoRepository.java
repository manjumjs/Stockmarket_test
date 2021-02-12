package com.spring.manju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.manju.bean.IpoDetail;

@Repository
public interface IpoRepository extends JpaRepository<IpoDetail, Long>{
	
	public List<IpoDetail> getAllByStockExchange(String stockExchange);

}
