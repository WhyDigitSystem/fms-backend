package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionDTO {
	private Long id;
	private String regionCode;
	private String regionName;
	private Long orgId;

}
