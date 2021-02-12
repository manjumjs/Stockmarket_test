package com.spring.manju.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.manju.bean.CompanyEntity;
import com.spring.manju.bean.IpoDetail;
import com.spring.manju.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService service;
	
	//TO GET ALL COMPANIES
    @RequestMapping(value = "/company/all", method = RequestMethod.GET)
    public ResponseEntity<List<CompanyEntity>> getAllCompanyDetails()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getAllCompanies());
    }
  
    //TO ADD COMPANIES
    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public ResponseEntity<CompanyEntity> addCompany(@RequestBody CompanyEntity company)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCompany(company));
    }

  
    //TO GET COMPANY BY COMPANY CODE 
    @RequestMapping(value = "/company/companyCode/{companyCode}", method = RequestMethod.GET)
    public ResponseEntity<CompanyEntity> getCompanyByCompanyCode(@PathVariable String companyCode){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getCompanyByCompanyCode(companyCode));
    }


    //TO GET ALL STOCK FROM COMPANIES
    @RequestMapping(value = "/company/stock/{cCode}/{from}/{to}")
    public ResponseEntity<Double> getCompanyStockPrice(@PathVariable String cCode,@PathVariable String from,@PathVariable String to) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getCompanyStockPrice(cCode,from,to));
    }

    //TO GET IPO BY COMPANY NAME
    @RequestMapping(value = "/company/ipo/{cName}")
    public ResponseEntity<IpoDetail> getIpoDetails(@PathVariable String cName)
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getIpoDetails(cName));
    }
	
	

}
