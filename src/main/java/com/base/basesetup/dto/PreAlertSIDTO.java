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
public class PreAlertSIDTO {

	private Long id;
	private boolean direct;
	private boolean autoEdi;
	private String docNo;
	private LocalDate docDate;
	private String manifestNo;
	private boolean manifestDone;
	private boolean jobAssigned;
	private String smptNo;
	private String seaCarrier;
	private String itemDescription;
	private String masterNo;
	private LocalDate masterDate;
	private String igmNo;
	private LocalDate igmDate;
	private String vesselEta;
	private String masterFreight;
	private String localIgmNo;
	private LocalDate localIgmDate;
	private String noOfPkgs;
	private String grwtInKgs;
	private String defFreightCurr;
	private BigDecimal defFreightCurr1;
	private String pol;
	private String pod;
	private String cfs;
	private boolean containerAllocationDone;
	private String agent;
	private String consignee;
	private BigDecimal totPkgs;
	private BigDecimal totGrwt;
	private BigDecimal totVolume;
	private String eta1;
	private boolean cargoHandOver;
	private boolean emptyContReturn;
	private boolean emptyContSurrender;
	private String containerCount;
	private String containerReturnCount;
	private String emptyReturnCount;
	
	
	private String createdBy;
	private Long orgId;
    private boolean active;
	
	private List<VesselDetailsSIDTO> vesselDetailsSIDTO;

	private List<HouseParticularsSIDTO> houseParticularsSIDTO;

	private List<ContainerDetailsSIDTO> containerDetailsSIDTO;

	
}
