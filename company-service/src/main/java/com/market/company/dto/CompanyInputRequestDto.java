package com.market.company.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CompanyInputRequestDto {
	private Integer id;
	private String compID;
	private String companyName;
	private String companyCeo;
	private String companyWebsite;
	private long companyTurnover;
	private String stockExchangeName;

}
