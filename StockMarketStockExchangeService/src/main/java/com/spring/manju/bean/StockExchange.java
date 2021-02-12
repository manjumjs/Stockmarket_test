package com.spring.manju.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stockexchange")
public class StockExchange {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String stock_exchange;
	private String contact_address;
	
	public StockExchange() {}
	
	public StockExchange(String stock_exchange,String contact_address) {
		
		
		this.stock_exchange = stock_exchange;
		this.contact_address = contact_address;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStock_exchange() {
		return stock_exchange;
	}
	public void setStock_exchange(String stock_exchange) {
		this.stock_exchange = stock_exchange;
	}
	
	public String getContact_address() {
		return contact_address;
	}
	public void setContact_address(String contact_address) {
		this.contact_address = contact_address;
	}
	
	
}
