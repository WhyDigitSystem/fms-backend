package com.base.basesetup.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfValuesDTO {
	private Long id;
	private String listCode;
	private String listDescription;
	private Long orgId;
	private String createdBy;
	private String updatedBy;
	private boolean active;
		
	private List<ListOfValues1DTO> ListOfValues1DTO;

}
