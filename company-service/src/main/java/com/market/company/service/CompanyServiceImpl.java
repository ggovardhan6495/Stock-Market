package com.market.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.market.company.dao.CompanyEntityRepository;
import com.market.company.dao.StockDetailsEntityRepository;
import com.market.company.entity.CompanyEntity;
import com.market.company.entity.StockDetailsEntity;

@Service
public class CompanyServiceImpl {

	@Autowired
	CompanyEntityRepository companyRepository;

	@Autowired
	StockDetailsEntityRepository stockRepository;
	
	public List<CompanyEntity> getAll(){
		return companyRepository.findAll();
	}
	
	public CompanyEntity create(@RequestBody CompanyEntity request) {
		return companyRepository.save(request);
	}
	
	public List<StockDetailsEntity> getAllStock(){
		return stockRepository.findAll();
	}
	
	public StockDetailsEntity createStock(@RequestBody StockDetailsEntity request) {
		return stockRepository.save(request);
	}
	
}
