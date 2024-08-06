package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypesDTO {

    private Long id;
	private String screenCode;
	private String screenName;
	private String docCode;
	
    private boolean active;
	private String createdBy;
	private Long orgId;
	
}
