package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
	private Long id;
	private String companyName;
	private String companyCode;
	private String email;
	private String phoneNo;
	private String address;
	private String country;
	private String state;
	private String city;
	private String pinCode;
	private String adminEmail;
	private String passport;
	private String userId;
	private Long orgId;
	private String createdBy;
	private boolean active;
}

