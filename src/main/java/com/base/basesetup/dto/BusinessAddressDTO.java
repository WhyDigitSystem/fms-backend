package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessAddressDTO {
	private Long id;
	private String state;
	private String businessPlace;
	private String cityName;
	private String address1;
	private String address2;
	private String contactPerson;
	private long contactPhoneNo;
	private String contactEmail;
}
