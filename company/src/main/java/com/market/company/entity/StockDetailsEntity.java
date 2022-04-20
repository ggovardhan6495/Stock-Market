package com.market.company.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="StockDetails")
public class StockDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private long stockPrice;
	private String stockExchangeName;
	
	public StockDetailsEntity() {
	
	}

	public StockDetailsEntity(Integer id, long stockPrice, String stockExchangeName) {
		super();
		this.id = id;
		this.stockPrice = stockPrice;
		this.stockExchangeName = stockExchangeName;
	}

	public Integer getId() {
		return id;
	}

	public long getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(long stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	@Override
	public String toString() {
		return "StockDetailsEntity [id=" + id + ", stockPrice=" + stockPrice + ", stockExchangeName="
				+ stockExchangeName + "]";
	}
	
	
	
}
