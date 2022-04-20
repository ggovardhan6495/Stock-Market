package com.market.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.company.entity.CompanyEntity;
import com.market.company.entity.StockDetailsEntity;
import com.market.company.service.CompanyServiceImpl;
import com.market.company.service.SequenceGeneratorService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyServiceImpl service;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/getAll")
	public List<CompanyEntity> getAll(){
		return service.getAll();
	}

	@PostMapping("/create")
	public CompanyEntity create(@RequestBody CompanyEntity request) {
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
