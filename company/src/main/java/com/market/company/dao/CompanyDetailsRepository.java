package com.market.company.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.market.company.entity.CompanyDetails;

@Repository	
@Transactional
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer>{

//	CompanyDetails save(CompanyInputRequestDto requestDto);(
	
	@Query("SELECT c from CompanyDetails c WHERE c.compID = :compID ")
	public CompanyDetails getCompanyDetailsById(@Param("compID") String compID);
}
