package com.base.basesetup.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrintDetailsDTO {

	
	private Long id;
	private String carrierDtl;
	private String agentIata;
	private String deptAirport;
	private String destAirport;
	private String iataCarrier;
	private String secondCarrier;
	private String secondCarrier1;
	private String thirdCarrier;
	private String thirdcarrier1;
	private String masterNo;
	private String accountInfo;
	private String carriage;
	private String customer;
	private Long accountNo;
	private String reqFlight;
	private LocalDate reqFlightDate;
	private String handingInfo;
	private Long noOfPcs;
	private Long totalNoOfPcs;
	private BigDecimal grossWgt;
	private BigDecimal totalCrossWgt;
	private BigDecimal kgbl;
	private String rateclass;
	private String chargeweight;
	private BigDecimal rateCharge;
	private BigDecimal total;
	private BigDecimal sumOfTotal;
	private String remarks;
	private String PrintNotify1;
	private String PrintNotify2;
	private BigDecimal myc;
	private BigDecimal xdc;
	private BigDecimal ams;
	private BigDecimal valch;
	private BigDecimal tax;
	private String ppd;
	private BigDecimal xcr;
	private BigDecimal mdc;
	private BigDecimal aws;
	private BigDecimal others;
	private BigDecimal duoAgentCharge;
	private BigDecimal preparedBy;
	
}
