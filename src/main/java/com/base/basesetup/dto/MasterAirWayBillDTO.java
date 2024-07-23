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
public class MasterAirWayBillDTO {

	private Long id;
	private String carrier;
	private String mawbNo;
	private String mawbNo1;
	private String pol;
	private String shipType;
	private String frtCurrency;
	private String otherDetails;
	private boolean onBoard;
	private LocalDate mawdDate;
	private String pod;
	private String freight;
	private BigDecimal exRate;
	private boolean preAlertSend;
	private boolean finalized;
	private String shipper;
	private String shipperAddType;
	private String shipperaddress;
	private String consignee;
	private String consigneeAddType;
	private String consigneeAddress;
	private String executingBranch;
	private BigDecimal totalHouseGrwt;
	private BigDecimal totalNoOfPkgs;
	private Long totalHouseChWt;
	private BigDecimal masterChwt;
	private Long volumeShare;

	private String createdBy;
	private String  updatedBy;
	private Long orgId;
    private boolean active;
	
	
	private List<HouseDetailsDTO> houseDetailsDTO;
	private List<CarrierDetailsDTO> carrierDetailsDTO;
	private List<DeclaredByDTO> declaredByDTO;
	private List<PrintDetailsDTO> printDetailsDTO;



}
