package com.market.company.entity;


import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection ="Company")
@Data
@NoArgsConstructor
public class CompanyEntity {

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
	
}
