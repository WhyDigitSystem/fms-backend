package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDTO {
	private Long id;
	private String screenName;
	private String screenCode;
	
    private boolean active;
	private String createdBy;
//	private Long orgId;
	
}
