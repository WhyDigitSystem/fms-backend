package com.base.basesetup.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GstInDTO {
	private Long id;
	private String pan;
	private String partyName;
	private String accountType;
	private String panName;
	private String bussinessType;
	private String businessCategory;
	private Long orgId;

 private List<StateGstDTO> stateGstDTO;
 
 private List<BusinessAddressDTO> businessAddressDTO;

}
