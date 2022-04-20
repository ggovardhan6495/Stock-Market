package com.market.company.entity;

import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Company")
public class CompanyDetailsEntity {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private Integer id;
	
	private String compID;
	private String companyName;
	private String companyCeo;
	private String companyWebsite;
	private long companyTurnover;	
	private StockDetailsEntity stockDetails;
	
	public CompanyDetailsEntity() {
	}
	
	public CompanyDetailsEntity(Integer id, String compID, String companyName, String companyCeo, String companyWebsite,
			long companyTurnover, StockDetailsEntity stockDetails) {
		super();
		this.id = id;
		this.compID = compID;
		this.companyName = companyName;
		this.companyCeo = companyCeo;
		this.companyWebsite = companyWebsite;
		this.companyTurnover = companyTurnover;
		this.stockDetails = stockDetails;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompID() {
		return compID;
	}
	public void setCompID(String compID) {
		this.compID = compID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCeo() {
		return companyCeo;
	}
	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	public long getCompanyTurnover() {
		return companyTurnover;
	}
	public void setCompanyTurnover(long companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public StockDetailsEntity getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(StockDetailsEntity stockDetails) {
		this.stockDetails = stockDetails;
	}

	@Override
	public String toString() {
		return "CompanyDetailsEntity [id=" + id + ", compID=" + compID + ", companyName=" + companyName
				+ ", companyCeo=" + companyCeo + ", companyWebsite=" + companyWebsite + ", companyTurnover="
				+ companyTurnover + ", stockDetails=" + stockDetails + "]";
	}
	

	
}
