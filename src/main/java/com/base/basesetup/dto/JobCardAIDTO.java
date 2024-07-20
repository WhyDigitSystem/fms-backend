package com.base.basesetup.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobCardAIDTO {
	private Long id;
	private boolean opsClosed;
	private LocalDate opsClosedDate;
	private String closedBy;
	private boolean confirmed;
	private LocalDate confirmedDate;
	private String confirmedBy;
	private String jobNo;

	
	private Long orgId;
	private String updatedBy;
	private String createdBy;
	private boolean active;
}
