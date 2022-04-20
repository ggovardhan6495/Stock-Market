 package com.market.stock.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TBL_STOCK_DETAILS")
public class StockEntity {
	@Id
	@Column(name="PK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="STOCK_PRICE")
	private BigDecimal stockPrice;
	
	@Column(name="DATE")
	private String date = new SimpleDateFormat("yyyy-MM-dd",   Locale.getDefault()).format(new Date());;
	
	@Column(name="TIME")
	private String time =  new SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(new Date());

	
	@Column(name="STOCK_EXCHANGE_NAME")
	private String stockExchangeName;
	
	@Column(name="COMPANY_CODE")
	private String companyCode;

	public StockEntity() {
	
	}

	

	public StockEntity(Integer id, BigDecimal stockPrice, String date, String time, String stockExchangeName,
			String companyCode) {
		super();
		this.id = id;
		this.stockPrice = stockPrice;
		this.date = date;
		this.time = time;
		this.stockExchangeName = stockExchangeName;
		this.companyCode = companyCode;
	}



	public Integer getId() {
		return id;
	}

	
	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	@Override
	public String toString() {
		return "StockEntity [id=" + id + ", stockPrice=" + stockPrice + ", date=" + date + ", time=" + time
				+ ", stockExchangeName=" + stockExchangeName + ", companyCode=" + companyCode + "]";
	}


	
	
	
	
}
