package com.spring.manju.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.manju.bean.CompanyEntity;
import com.spring.manju.bean.IpoDetail;
import com.spring.manju.bean.StockPrice;
import com.spring.manju.repository.CompanyRepository;
import com.spring.manju.repository.IpoRepository;
import com.spring.manju.repository.StockRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
	IpoRepository ipoRepo;
	
	@Autowired
	StockRepository stockRepo;
	
	
	@Override
	@Transactional
    public List<CompanyEntity> getAllCompanies()
    {
		return companyRepo.findAll();
    }
	
    @Override
    @Transactional
    public CompanyEntity addCompany(CompanyEntity company){
    	return companyRepo.save(company);
    }

    @Override
    @Transactional
    public CompanyEntity getCompanyByCompanyCode(String companyCode)
    {
    	
    	return companyRepo.findByCompanyCode(companyCode);
    }

    @Override
    @Transactional
    public double getCompanyStockPrice(String companyCode, String from, String to) {
    	List<StockPrice> list=stockRepo.
    			findAllByCompanyCodeAndDateBetween(companyCode, Date.valueOf(from), Date.valueOf(to));
    	
    	double x = 0.0;
        for(int i=0;i<list.size();i++)
        {
            x = x + list.get(i).getCurrent_price();
        }
        x = x / list.size();
        return x;
    }


    @Override
    @Transactional
    public IpoDetail getIpoDetails(String cName)
    {
    	return ipoRepo.findByCompanyName(cName);
    }

}
