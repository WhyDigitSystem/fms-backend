package com.base.basesetup.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoyageDetailsDTO {
	private Long id;
	private String handlingInformation;
	private Long noOfPieces;
	private BigDecimal grossWeight;
	private String rateClass;
	private String commodityItemNo;
	private BigDecimal chargeableWeightRate;
	private String ppd;
	private BigDecimal charge;
	private Long total;
	
	private String qtyOfFoods;
	private String signature;
	private BigDecimal myc;
	private BigDecimal xcr;
	private BigDecimal xdc;
	private BigDecimal mdc;
	private BigDecimal ams;
	private BigDecimal awb;
	private BigDecimal valCh;
	private BigDecimal others;
	private BigDecimal tax;
	private BigDecimal dueAgentCharge;
	private String printType;
	
}
