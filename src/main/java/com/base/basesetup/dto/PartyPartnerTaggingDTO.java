package com.base.basesetup.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyPartnerTaggingDTO {
	private Long id;
	@Column(name = "partnername")
	private String partnerName;
}
