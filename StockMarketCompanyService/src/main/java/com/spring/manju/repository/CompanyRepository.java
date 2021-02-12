package com.spring.manju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.manju.bean.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{

	public CompanyEntity findByCompanyCode(String companyCode);

	

}
