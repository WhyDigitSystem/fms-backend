package com.base.basesetup.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContainerAllocationSIDTO {

	private Long id;
	private String masterNo;
	private LocalDate masterDate;
	private String orderNo;
	private LocalDate orderDate;
	private String pkgs;
	private String grwt;
	
	private String createdBy;
	private Long orgId;
    private boolean active;
	
	private List<ContainerDetailsDTO> containerDetailsDTO;

}
