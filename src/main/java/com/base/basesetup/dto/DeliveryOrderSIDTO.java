package com.base.basesetup.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryOrderSIDTO {
	private Long id;
	private String doNo;
	private LocalDate doDate;
	private String consignee;
	private String irnNo;
	private LocalDate canDate;
	private BigDecimal totalPkgs;
	private String broStatus;
	private String broRecd;
	private String jobNo;
	private LocalDate jobDate;
	private BigDecimal totalGrwt;
	private String masterNo;
	private String houseNo;
	private String natureOfGoods;
	private String broRefNo;
	private LocalDate broRefDate;
	private String igmNo;
	private String itemNo;
	private BigDecimal canAmount;
	private String remarks;
	private String orderTo;
	private String cha;
	private String cfs;

	private boolean active;
	private String createdBy;
	private Long orgId;

}
