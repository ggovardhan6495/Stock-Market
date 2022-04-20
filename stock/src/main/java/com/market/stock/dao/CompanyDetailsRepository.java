package com.market.stock.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.stock.entity.CompanyDetails;

@Repository
@Transactional
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer>{

}
