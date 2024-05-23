package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DesignationDTO {
	private Long Id;
	private String designation;
	private Long orgId;
	private String createdBy;
	private String updatedBy;
	private boolean active;
}
