package com.base.basesetup.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostEstimateDTO {

	private Long id;
	private String partyVendor;
	private String linearCarrier;
	private String billToCustomer;
	private String chargeCode;
	private String description;
	private String amountInInr;
	private LocalDate estimatePayDate;
	private LocalDate funReqDate;
	
}
