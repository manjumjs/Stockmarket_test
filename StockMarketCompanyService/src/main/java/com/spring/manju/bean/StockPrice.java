package com.spring.manju.bean;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "stockprice")
public class StockPrice {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String companyCode;
	private String stock_exchange;
	private float current_price;
	private Date date;
	private Time time;
	
	public StockPrice() {}
	public StockPrice( String companyCode, String stock_exchange, float current_price, Date date, Time time) {
		
		
		this.companyCode = companyCode;
		this.stock_exchange = stock_exchange;
		this.current_price = current_price;
		this.date = date;
		this.time = time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStock_exchange() {
		return stock_exchange;
	}
	public void setStock_exchange(String stock_exchange) {
		this.stock_exchange = stock_exchange;
	}
	public float getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(float current_price) {
		this.current_price = current_price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	
	

}
