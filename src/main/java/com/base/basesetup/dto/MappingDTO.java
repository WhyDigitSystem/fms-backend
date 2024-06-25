package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MappingDTO {

	private Long id;
	private String docType;
	private String subType;
	private String subTypeId;
	private String subTypeCode;
	private String docName;
	private String prefix;
	private boolean postFinance;
	private int lastNo;
	private boolean resetOnFinYear;
}
