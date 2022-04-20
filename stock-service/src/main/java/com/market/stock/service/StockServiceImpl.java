package com.market.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.stock.dao.StockEntityRepository;
import com.market.stock.entity.StockEntity;

@Service
public class StockServiceImpl {

	@Autowired
	private StockEntityRepository repository;
	
	public StockEntity save(StockEntity stock) {
		return repository.save(stock);
	}
	
	public List<StockEntity> fetchAll() {
		return repository.findAll();
	}
	
	public List<StockEntity> fetchStockPrice(String compCode, String startDate, String endDate){
		return repository.fetchStockPrice(compCode, startDate, endDate);
	}

}
