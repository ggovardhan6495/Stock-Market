 package com.market.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TBL_STOCK_DETAILS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDetails {
	@Id
	@Column(name="PK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(name="STK_PRICE")
	private long stockPrice;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(referencedColumnName = "compID") private CompanyDetails fk;
	 */
//	public StockDetails() {
//	
//	}
//	
//	public StockDetails(Integer id, long stockPrice, CompanyDetails fk) {
//		super();
//		Id = id;
//		this.stockPrice = stockPrice;
//		this.fk = fk;
//	}
}
