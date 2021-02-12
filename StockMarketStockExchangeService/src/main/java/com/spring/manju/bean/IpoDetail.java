package com.spring.manju.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ipodetail")
public class IpoDetail {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String companyName;
	private String stockExchange;
	private float price_per_share;
	private int total_number_of_share;
	private Date open_date_time;
	private String remarks;
	
	public IpoDetail() {}
	public IpoDetail(String companyName, String stockExchange, float price_per_share,
			int total_number_of_share, Date open_date_time, String remarks) {
		
		
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.price_per_share = price_per_share;
		this.total_number_of_share = total_number_of_share;
		this.open_date_time = open_date_time;
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public float getPrice_per_share() {
		return price_per_share;
	}

	public void setPrice_per_share(float price_per_share) {
		this.price_per_share = price_per_share;
	}

	public int getTotal_number_of_share() {
		return total_number_of_share;
	}

	public void setTotal_number_of_share(int total_number_of_share) {
		this.total_number_of_share = total_number_of_share;
	}

	public Date getOpen_date_time() {
		return open_date_time;
	}

	public void setOpen_date_time(Date open_date_time) {
		this.open_date_time = open_date_time;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
