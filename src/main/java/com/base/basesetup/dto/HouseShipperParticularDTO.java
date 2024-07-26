package com.base.basesetup.dto;

import com.base.basesetup.entity.HouseBillOfLadingVO;
import com.base.basesetup.entity.HouseShipperParticularVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseShipperParticularDTO {
	private Long id;
	private String containerDetails;
	private String containerNo;
	private String qualityAndKindPackage;
	private String descriptionOfGoods;
	private String grossWeight;
	private String netWeight;
	private String agentAddress;
	private String deliveryAddress;
	private String measurement;
	private String placeDateOfIssue;
	
	private String NoOfOriginal;
	private String freightCharges;
	private String prepaid;
	private String collect;
	private String onBoard;
	private String noOfContainer;
	private String freightDetails;
	private String containerNo1;
	private String sealNo;
	private String GrossWtKgs;
	
	private String agentCarrier;
	private String signature;
	private String signatureBy;
	private String netWtKgs;
	private String packages;
	
}
