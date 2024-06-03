package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanySetupDTO {

	private Long id;
	private String companyName;
	private String NoOfUser;
    private boolean active;
}
