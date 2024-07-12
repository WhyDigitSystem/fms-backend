package com.base.basesetup.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreAlertCarrierDetailsAIDTO {

	private Long id;
	private Long airLineCode;
	private String airLineName;
	private String flightNo;
	private LocalDate etd;
	private LocalDateTime etdTime;
	private LocalDate eta;
	private LocalDateTime etaTime;
	private String pol;
	private String pod;
	
}
