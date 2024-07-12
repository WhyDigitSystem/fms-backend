package com.base.basesetup.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContainerAllocationSODTO {
	
	private Long id;
	private String docId;
	private LocalDate docDate;
	private String globalShipNo;
	private String poNo;
	private String jobNo;
	private String pol;
	private String pod;
	private String hblNo;
	private String fpod;
	private String nominatedBy;
	private String mblNo;
	private String deliveryTerms;
	private String freight;
	private boolean directMaster;
	private boolean masterFinalized;
	private BigDecimal totPkgs;
	private BigDecimal totGrWt;
	private BigDecimal totVolWt;
	private Long ft20;
	private Long ft40;
	private Long ft45;
	private BigDecimal cbm;
	
	private String createdBy;
	private String  updatedBy;
	private Long orgId;
    private boolean active;
    
	private List<ContainerDetailsSODTO> containerDetailsSODTO;

}
