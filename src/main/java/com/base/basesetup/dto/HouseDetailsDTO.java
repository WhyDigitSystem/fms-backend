package com.base.basesetup.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDetailsDTO {
	private Long id;
	private String jobNo;
	private String houseNo;
	private String sNo;
	private String hShipper;
	private String hConsignee;
	private Long pkgs;
	private BigDecimal grwt;
	private BigDecimal chwt;
	private String fpod;
	private String jobRemarks;


}
