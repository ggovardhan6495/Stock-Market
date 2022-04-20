package com.market.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.company.dto.CompanyInputRequestDto;
import com.market.company.entity.CompanyDetails;
import com.market.company.service.CompanyServiceImpl;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyServiceImpl service;
	
	@PostMapping("/register")
	public CompanyDetails registerCompany(@RequestBody CompanyDetails requestDto){
		return service.registerCompany(requestDto);
	}
	
	@GetMapping("/getall")
	public List<CompanyDetails> fetchCompanyDetails(){
		return service.fetchCompanyDetails();
	}
	
	@GetMapping("/info/{companycode}")
	public CompanyDetails fetchCompanyDetailsById(@PathVariable String companycode){
		return service.fetchCompanyDetailsById(companycode);
	}
	
	

}
