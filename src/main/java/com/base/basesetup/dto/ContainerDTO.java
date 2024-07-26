package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContainerDTO {
	private Long id;
	private String containerType;
	private String category;
	private float length;
	private float width;
	private float height;
	private float weight;
	private float volume;
	private Long orgId;
	private String createdBy;
	private boolean active;

}
