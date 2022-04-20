package com.market.company.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CompanyInputRequestDto {
	private Integer id;
	private String compID;
	private String companyName;
	private String companyCeo;
	private String companyWebsite;
	private long companyTurnover;
	private String stockExchangeName;
}
