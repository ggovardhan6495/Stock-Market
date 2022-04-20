package com.market.company.dao;

import javax.transaction.Transactional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.market.company.entity.StockDetailsEntity;

@Repository	
@Transactional
public interface StockDetailsEntityRepository extends MongoRepository<StockDetailsEntity, Integer>{

}
