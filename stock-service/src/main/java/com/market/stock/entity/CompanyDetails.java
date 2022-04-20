package com.market.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TBL_COMPANY_DETAILS")
@Data
public class CompanyDetails {
	
	@Id
	@Column(name="PK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="STOCK_EXCHANGE_NAME")
	private String stockExchangeName;
	
	@Column(name="COMPANY_CODE")
	private String companyCode;
	
	public CompanyDetails() {
	
	}
}