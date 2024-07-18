package com.base.basesetup.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargeParticularSIDTO {

	private Long id;
	private String type;
	private String chargeCode;
	private String chargeName;
	private String taxable;
	private String ccf;
	private LocalDate applyOn;
	private int qty;
	private BigDecimal rate;
	private String currency;
	private BigDecimal fcAmount;
	private BigDecimal exRate;
	private BigDecimal lcAmount;
	private String taxablePercentage;
	private BigDecimal tlcAmount;
	private BigDecimal billAmount;
}
