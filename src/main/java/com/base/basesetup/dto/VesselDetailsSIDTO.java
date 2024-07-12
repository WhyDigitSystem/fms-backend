package com.base.basesetup.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VesselDetailsSIDTO {

	private Long id;
	private String type;
	private String vesselName;
	private String voyage;
	private String etd;
	private LocalDate etdTime;
	private String eta;
	private LocalDate etaTime;
	private String pol;
	private String pod;
	
}
