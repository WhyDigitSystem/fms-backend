package com.base.basesetup.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContainerDetailsSIDTO {
	
	private Long id;
	private String containerType;
	private String containerNo;
	private BigDecimal containerWt;
	private BigDecimal pkgs;
	private BigDecimal grwt;
	private String mLineNo;
	private String sLineNo;
	private String sealNo;
}
