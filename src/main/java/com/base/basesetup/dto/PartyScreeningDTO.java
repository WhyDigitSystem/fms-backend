package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyScreeningDTO {
	private Long id;
	private String partyType;
	private String entityName;
	private String alternativeEntityNames;
	private long uniqueId;
	private String includeAlias;
	private String screeningstatus;
	private long orgId;

	
}
