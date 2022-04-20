package com.market.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.company.dao.CompanyDetailsRepository;
import com.market.company.dto.CompanyInputRequestDto;
import com.market.company.entity.CompanyDetails;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@Transactional(rollbackFor=Exception.class)
public class CompanyServiceImpl {

	@Autowired
	CompanyDetailsRepository companyRepository;
	
	public CompanyDetails registerCompany(CompanyDetails requestDto){
		return companyRepository.save(requestDto);
	}
	
	public List<CompanyDetails> fetchCompanyDetails(){
		return companyRepository.findAll();
	}
	
	public CompanyDetails fetchCompanyDetailsById(String companyId){
		return companyRepository.getCompanyDetailsById(companyId);
	}
}
