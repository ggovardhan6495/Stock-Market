package com.market.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.stock.entity.CompanyDetails;
import com.market.stock.entity.StockEntity;
import com.market.stock.service.CompanyDetailsServiceImpl;
import com.market.stock.service.StockServiceImpl;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private CompanyDetailsServiceImpl companyService;

	@Autowired
	private StockServiceImpl stockService;
	
	@PostMapping("/create")
	public StockEntity save(@RequestBody StockEntity stock) {
		return stockService.save(stock);
	}
	
	@GetMapping("/getAll")
	public List<StockEntity> fetchAll() {
		return stockService.fetchAll();
	}

	@GetMapping("/stockPrice")
	public List<StockEntity> fetchStockPrice(@RequestParam(name="compCode") String compCode, @RequestParam(name="startDate") String startDate, @RequestParam(name="endDate") String endDate){
		return stockService.fetchStockPrice(compCode, startDate, endDate);
	}

	
	@PostMapping("/cmp/create")
	public CompanyDetails saveCmpDetails(@RequestBody CompanyDetails companyDetails) {
		return companyService.save(companyDetails);
	}
	
	@GetMapping("/cmp/getAll")
	public List<CompanyDetails> fetchAllCmpDetails() {
		return companyService.fetchAll();
	}
	

}
