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
public class ContainerDetailsSODTO {
	private Long id;
	private String containerType;
	private String containerNo;
	private String sealNo;
	private String load;
	private BigDecimal qty;
	private BigDecimal volume;
	private BigDecimal pkgs;
	private BigDecimal grwt;
	
}
