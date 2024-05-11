package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    private Long id;
	private String countryCode;
	private String country;
	private Long orgId;
	private String userId;
}
