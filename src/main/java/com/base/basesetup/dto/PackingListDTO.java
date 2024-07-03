package com.base.basesetup.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackingListDTO {

	private Long id;
	private String sIdNO;
	private String custPoNo;
	private String custPoDt;
	private String industry;
	private String itemDescription;
	private int qty;
	private String uom;
	private String grWt;
	private String chWt;
	private BigDecimal dimL;
	private BigDecimal dimW;
	private BigDecimal dimH;
	private String unit;
	private BigDecimal volume;
}
