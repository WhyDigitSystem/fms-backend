package com.base.basesetup.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseAirWayBillDTO {
	private Long id;
	private String hawbNo;
	private LocalDate hawbDate;
	private String uwlHawb;
	private String soNo;
	private LocalDate soDate;
	private String jobNO;
	private LocalDate jobDate;
	private String mawbNo;
	private boolean masterFinalize;
	
	private String printShipper;
	private String shipperAddress;
	private String printNotify;
	private String notifyAddress;
	private String printNotify1;
	private String printConsignee;
	private String consigneeAddress;
	private String accountInformation;
	private String issuingConsolidation;
	private String iataCode;
	private String departure;
	private String iataCarrier;
	private String destination;
	private String destination1;
	private String dvCarriage;
	private String dvCustomer;
	private String secondCarrier;
	private String thirdCarrier;
	
	
	
	private String createdBy;
	private String  updatedBy;
	private Long orgId;
    private boolean active;
    
	private List<VoyageDetailsDTO> voyageDetailsDTO;

}
