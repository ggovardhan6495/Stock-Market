package com.market.company.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Data
@Table(name="TBL_COMPANY_DETAILS")
public class CompanyDetails {

	@Id
	@Column(name="PK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NaturalId
	private String compID;
	@Column(name="CMP_NAME")
	private String companyName;
	@Column(name="CMP_CEO")
	private String companyCeo;
	@Column(name="CMP_WEBSITE")
	private String companyWebsite;
	@Column(name="CMP_TURNOVER")
	private long companyTurnover;
	
	@Column(name="STK_EXCNG_NAME")
	@Enumerated(EnumType.STRING)
	private StockExchangeNameEnum stockExchangeName;
}
