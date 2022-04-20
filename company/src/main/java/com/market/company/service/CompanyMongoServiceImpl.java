package com.market.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.market.company.dao.CompanyDetailsEntityRepository;
import com.market.company.dao.StockDetailsEntityRepository;
import com.market.company.entity.CompanyDetailsEntity;
import com.market.company.entity.StockDetailsEntity;

@Service
public class CompanyMongoServiceImpl {

	@Autowired
	CompanyDetailsEntityRepository mongoRepository;

	@Autowired
	StockDetailsEntityRepository stockMongoRepository;
	
	public List<CompanyDetailsEntity> getAll(){
		return mongoRepository.findAll();
	}
	
	public CompanyDetailsEntity create(@RequestBody CompanyDetailsEntity request) {
		return mongoRepository.save(request);
	}
	
	public List<StockDetailsEntity> getAllStock(){
		return stockMongoRepository.findAll();
	}
	
	public StockDetailsEntity createStock(@RequestBody StockDetailsEntity request) {
		return stockMongoRepository.save(request);
	}
	
}
