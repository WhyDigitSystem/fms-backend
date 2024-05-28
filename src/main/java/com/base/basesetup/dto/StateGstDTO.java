package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateGstDTO {
	private Long id;
	private String stateGst;
	private String gstIn;
	private String stateCode;
	private String contactPerson;
	private String contactPhoneNo;
	private String contactEmail;
}
