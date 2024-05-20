package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
	private Long Id;
	private String departmentCode;
	private String department;
	private Long orgId;
	private String createdBy;
	private String updatedBy;
	private boolean active;
}
