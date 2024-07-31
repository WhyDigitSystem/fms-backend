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
public class ShipmentAODTO {
	private Long id;
	private String docId;
	private LocalDate docDate;
	private String pol;
	private String pod;
	private String fpod;
	private String nominatedBy;
	private String deliveryTerms;
	private String freight;
	private boolean projectCargo;
	private boolean directMaster;
	private boolean jobAssigned;
	private String shipperInvoiceNo;
	private String billOfEntry;
	private String shipper;
	private String sAddType;
	private String sAddress;
	private String notify;
	private String nAddType;
	private String nAddress;
	private String consignee;
	private String caddType;
	private String cAddress;
	private String salesCategory;
	private String salesPerson;
	private BigDecimal totalNoOfPkgs;
	private BigDecimal totalGrtWt;
	private BigDecimal totalChWt;
	private BigDecimal totalVolWt;
	private BigDecimal totEstimationCost;
	
	
	
	private boolean cancel;
	private String createdBy;
	private String cancelRemarks;
	private Long orgId;
    private boolean active;
    
    
	private List<CostEstimateDTO> costEstimateDTO;
	private List<PackingListDTO> packingListDTO;


	
}
