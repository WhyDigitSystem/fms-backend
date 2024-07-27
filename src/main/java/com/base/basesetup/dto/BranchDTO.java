package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {

	private Long id;
	private String mastertype;
	private String company;
	private String addressLine1;
	private String stCode;
	private String stRegNo;
	private String branchCode;
	private String addressLine2;
	private String panNo;
	private String gstIn;
	private String branchName;
	private String country;
	private String state;
	private String city;
	private String pinCode;
	private String stateNo;
	private String stateCode;
	private String region;
	private String cgmPrefix;
	private String carnLogic;
	private String raCode;
	private String lcCurrency;
	private String letterPadFooter1;
	private String letterPadFooter2;

	private boolean active;
	private String createdBy;
	private Long orgId;
}
