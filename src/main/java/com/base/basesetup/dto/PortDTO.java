package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortDTO {

	private Long Id;

	private String port;

	private String country;

	private String type;

	private String code;

	private Long orgId;

	private String createdBy;
	private String updatedBy;
	private boolean active;

}
