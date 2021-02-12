package com.spring.manju.service;


import java.util.List;
import java.util.Optional;
import com.spring.manju.bean.CompanyEntity;
import com.spring.manju.bean.IpoDetail;


public interface CompanyService {
	
	public List<CompanyEntity> getAllCompanies();
    public CompanyEntity addCompany(CompanyEntity companyDTO);
    public CompanyEntity getCompanyByCompanyCode(String companyCode);
    public double getCompanyStockPrice(String companyCode, String from, String to);
    public IpoDetail getIpoDetails(String companyName);
	
	

}
