package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortDTO {

	private Long portId;

	private String port;

	private String country;

	private String type;

	private int code;

	private Long orgId;

	private boolean active;
}
