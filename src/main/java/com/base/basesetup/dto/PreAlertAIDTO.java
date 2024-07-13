package com.base.basesetup.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreAlertAIDTO {

	private Long id;
	private boolean direct;
	private boolean isAutoEdi;
	private String docNo;
	private LocalDate docDate;
	private String airCarrier;
	private String airCarrierType;
	private LocalDate flightDate;
	private LocalDateTime flightTime;
	private LocalDate masterDate;
	private String shipType;
	private BigDecimal grWt;
	private String pol;
	private LocalDate docDate1;
	private String flightNo;
	private Long masterNo;
	private Long masterNo1;
	private Long noOfPkgs;
	private BigDecimal chWt;
	private String pod;
	private boolean manifestDone;
	private String jobAssigned;
	private String agent;
	private String consignee;
	private String itemDescription;
	private Long igmNo;
	private LocalDate igmNoDate;
	private String defFreightCurr;
	private BigDecimal defFreightCurr1;
	private Long masterFreight;
	private Long airlineDoNo;
	private Long SectorAwd;
	private Long totHousePkgs;
	private BigDecimal totHouseGrwt;
	private BigDecimal totHouseChWt;
	
	private String  updatedBy;
	private Long orgId;
    private boolean active;
	private String createdBy;
	
	private List<HouseParticularsAIDTO> houseParticularsAIDTO;
	private List<PreAlertCarrierDetailsAIDTO> preAlertCarrierDetailsAIDTO;

}
