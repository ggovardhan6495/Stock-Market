package com.market.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.stock.dao.CompanyDetailsRepository;
import com.market.stock.entity.CompanyDetails;

@Service
public class CompanyDetailsServiceImpl {

	@Autowired
	private CompanyDetailsRepository companyDetailsRepository;
	
	
	public CompanyDetails save(CompanyDetails companyDetails) {
		return companyDetailsRepository.save(companyDetails);
	}
	
	public List<CompanyDetails> fetchAll() {
		return companyDetailsRepository.findAll();
	}
}
