package com.base.basesetup.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceCanAiDTO {

	private Long id;
	private String docId;
	private String billCurr;
	private BigDecimal bexRate;
	private String masterNo;
	private boolean taxExempt;
	private LocalDate docDate;
	private String houseNo;
	private String chargeScheme;
	private String billOfEntry;
	private String defFrtCurrType;
	private BigDecimal defFrtCurr;
	private Long totPkgs;
	private BigDecimal totChWt;
	private BigDecimal totGrWt;
	private BigDecimal usd;
	private String shipper;
	private String sAddType;
	private String sAddress;
	private String consignee;
	private String cAddType;
	private String cAddress;
	private String notify;
	private String nAddType;
	private String nAddress;
	private String billToParty;
	private String bAddType;
	private String bAddress;
	
	
	private String createdBy;
	private String  updatedBy;
	private Long orgId;
    private boolean active;
    
	private List<ChargeParticularDTO> chargeParticularDTO;

	
}
