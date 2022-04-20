package com.market.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.company.entity.CompanyDetailsEntity;
import com.market.company.entity.StockDetailsEntity;
import com.market.company.service.CompanyMongoServiceImpl;
import com.market.company.service.SequenceGeneratorService;

@RestController
@RequestMapping("/mongo")
public class CompanyMongoController {

	@Autowired
	private CompanyMongoServiceImpl service;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/getAll")
	public List<CompanyDetailsEntity> getAll(){
		return service.getAll();
	}

	@PostMapping("/create")
	public CompanyDetailsEntity create(@RequestBody CompanyDetailsEntity request) {
		request.setId(sequenceGeneratorService.generateSequence(request.SEQUENCE_NAME));
		return service.create(request);
	}

	@GetMapping("/getAllStock")
	public List<StockDetailsEntity> getAllStock(){
		return service.getAllStock();
	}
	@PostMapping("/createStock")
	public StockDetailsEntity createStock(@RequestBody StockDetailsEntity request) {
		return service.createStock(request);
	}
}
