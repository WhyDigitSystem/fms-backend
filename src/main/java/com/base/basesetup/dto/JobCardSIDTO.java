package com.base.basesetup.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobCardSIDTO {
	private Long id;
	private boolean verified;
	private LocalDate verifiedDate;
	private String verifiedBy;
	private boolean confirmed;
	private LocalDate confirmedDate;
	private String confirmedBy;
	private String jobNo;

	
	private Long orgId;
	private String createdBy;
	private boolean active;
}
