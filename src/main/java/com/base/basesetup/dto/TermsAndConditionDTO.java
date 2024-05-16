package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermsAndConditionDTO {
	private Long id;
	private String branch;
	private String documentType;
	private String terms;
	private String partyType;
	private Long orgId;

}
