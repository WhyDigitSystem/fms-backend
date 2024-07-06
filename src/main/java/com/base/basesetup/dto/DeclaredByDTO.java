package com.base.basesetup.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclaredByDTO {

	private Long id;
	private String chargeType;
	private String code;
	private String chargeCode;
	private String chargeDesc;
	private String currency;
	private BigDecimal exRate;
	private String applyOn;
	private BigDecimal qty;
	private String rate;
	private BigDecimal fcAccount;
	private BigDecimal lcAccount;
	private String payTo;
	private String terms;
}
