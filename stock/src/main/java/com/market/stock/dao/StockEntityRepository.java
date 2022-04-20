package com.market.stock.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.market.stock.entity.StockEntity;

@Repository
@Transactional
public interface StockEntityRepository extends JpaRepository<StockEntity, Integer>{

	@Query("SELECT stk FROM StockEntity stk WHERE stk.companyCode=:compCode and (stk.date BETWEEN :startDate AND :endDate)")
	List<StockEntity> fetchStockPrice(@Param("compCode") String compCode, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
