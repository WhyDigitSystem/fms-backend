package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventsDTO {
    
	private Long id;
	private String eventDescription;
	private String eventType;
	private Long orgId;
	private String createdBy;
	private String updatedBy;
	private boolean active;

}
