package com.spring.manju.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String company_name;
	private float turnover;
	private String ceo;
	private String board_of_directors;
	private String stock_exchanges;
	private String sector;
	private String brief_writeup;
	private String company_stock_code;
	
	public CompanyEntity() {}
	
	public CompanyEntity( String company_name, float turnover, String ceo, String board_of_directors,
			String stock_exchanges, String sector, String brief_writeup, String company_stock_code) {
		
		this.company_name = company_name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.board_of_directors = board_of_directors;
		this.stock_exchanges = stock_exchanges;
		this.sector = sector;
		this.brief_writeup = brief_writeup;
		this.company_stock_code = company_stock_code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public float getTurnover() {
		return turnover;
	}

	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoard_of_directors() {
		return board_of_directors;
	}

	public void setBoard_of_directors(String board_of_directors) {
		this.board_of_directors = board_of_directors;
	}

	public String getStock_exchanges() {
		return stock_exchanges;
	}

	public void setStock_exchanges(String stock_exchanges) {
		this.stock_exchanges = stock_exchanges;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getBrief_writeup() {
		return brief_writeup;
	}

	public void setBrief_writeup(String brief_writeup) {
		this.brief_writeup = brief_writeup;
	}

	public String getCompany_stock_code() {
		return company_stock_code;
	}

	public void setCompany_stock_code(String company_stock_code) {
		this.company_stock_code = company_stock_code;
	}
	
	
	

}
