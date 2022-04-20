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

import lombok.Data;

@Entity
@Table(name="TBL_STOCK_DETAILS")
@Data
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
}