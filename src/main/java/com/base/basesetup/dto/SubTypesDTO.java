package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SubTypesDTO {
	private Long id;
	private String subType;
	private String subTypeCode;
	private String subTypeName;
	private String month;
	
}
