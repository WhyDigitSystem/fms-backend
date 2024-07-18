package com.base.basesetup.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ef_scaninvoicedtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargeParticularSIVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_scaninvoicedtlgen")
	@SequenceGenerator(name = "ef_scaninvoicedtlgen", sequenceName = "ef_scaninvoicedtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_scaninvoicedtlid")
	private Long id;
	@Column(name = "type")
	private String type;
	@Column(name = "chargecode")
	private String chargeCode;
	@Column(name = "chargename")
	private String chargeName;
	@Column(name = "taxable")
	private String taxable;
	@Column(name = "ccf")
	private String ccf;
	@Column(name = "applyon")
	private LocalDate applyOn;
	@Column(name = "qty")
	private int qty;
	@Column(name = "rate")
	private BigDecimal rate;
	@Column(name = "currency")
	private String currency;
	@Column(name = "fcamount")
	private BigDecimal fcAmount;
	@Column(name = "exrate")
	private BigDecimal exRate;
	@Column(name = "lcAmount")
	private BigDecimal lcAmount;
	@Column(name = "taxablepercentage")
	private String taxablePercentage;
	@Column(name = "tlcamount")
	private BigDecimal tlcAmount;
	@Column(name = "billamount")
	private BigDecimal billAmount;
	
	@ManyToOne
	@JoinColumn(name = "ef_scaninvoicehdrid")
	@JsonBackReference
	private AdvanceCanSIVO advanceCanSIVO;
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
}
