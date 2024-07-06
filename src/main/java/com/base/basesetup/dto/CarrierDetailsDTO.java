package com.base.basesetup.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrierDetailsDTO {

	private Long id;
	@Column(name = "frightno")
	private String frightNo;
	@Column(name = "etd")
	private LocalDate etd;
	@Column(name = "etdtime")
	private LocalDateTime etdTime;
	@Column(name = "eta")
	private LocalDate eta;
	@Column(name = "etatime")
	private LocalDateTime etaTime;
	@Column(name = "pol")
	private String pol;
	@Column(name = "pod")
	private String pod;
	
}
