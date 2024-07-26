package com.base.basesetup.dto;

import javax.persistence.Column;

import com.base.basesetup.entity.HouseAddressDetailsVO;
import com.base.basesetup.entity.HouseBillOfLadingVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseAddressDetailsDTO {
	private Long id;
	private String printShipper;
	private String blNo;
	private String shipperAddress;
	private String printConsignee;
	private String consigneeAddress;
	private String printNotify;
	private String notifyAddress;
	private String vesselVoyageNo;
	private String portOfreceipt;
	private String portOfDelivery;

	private String modesOfTransport;
	private String placeOfAcceptance;
	private String dateOfAcceptance;
	private String PrintConsignee;
	private String portOfDischarge;
	private String finalDestination;
}
