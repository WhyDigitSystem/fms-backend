package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfValues1DTO {
	private Long id;
	private Long sNo;
	private String code;
	private String description;
	private boolean active;
}
