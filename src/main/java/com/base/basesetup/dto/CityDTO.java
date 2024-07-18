package com.base.basesetup.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
	private Long id;
	private String cityCode;
	private String country;
	private String cityName;
	private String state;
	private Long orgId;
	private boolean active;
	private String createdBy;
	private String updatedBy;

}