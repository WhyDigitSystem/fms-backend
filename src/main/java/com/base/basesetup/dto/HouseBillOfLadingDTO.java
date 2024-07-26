package com.base.basesetup.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseBillOfLadingDTO {
	private Long id;
	private String hblNo;
	private LocalDate hbldate;
	private String uwlHblNo;
	private String siNo;
	private LocalDate siDate;
	private String jobNo;
	private LocalDate jobDate;
	private String mblNo;
	private boolean masterFinalized;
	
	private boolean active;
	private String createdBy;
	private String updatedBy;
	private Long orgId;
	
	List<HouseAddressDetailsDTO> houseAddressDetailsDTO;
	List<HouseShipperParticularDTO> HouseShipperParticularDTO;

}
