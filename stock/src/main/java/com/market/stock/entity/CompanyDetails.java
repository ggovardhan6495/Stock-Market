package com.market.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TBL_COMPANY_DETAILS")
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

	public CompanyDetails(Integer id, String stockExchangeName, String companyCode) {
		this.id = id;
		this.stockExchangeName = stockExchangeName;
		this.companyCode = companyCode;
	}

	public Integer getId() {
		return id;
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

	@Override
	public String toString() {
		return "CompanyDetails [id=" + id + ", stockExchangeName=" + stockExchangeName + ", companyCode=" + companyCode
				+ "]";
	}
	
	
	
}
