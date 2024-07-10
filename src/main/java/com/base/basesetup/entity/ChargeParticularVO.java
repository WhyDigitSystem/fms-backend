package com.base.basesetup.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
@Table(name = "ef_acaninvoicedtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargeParticularVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_acaninvoicedtlgen")
	@SequenceGenerator(name = "ef_acaninvoicedtlgen", sequenceName = "ef_acaninvoicedtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_acaninvoicedtlid")
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
	@Column(name = "billamount")
	private BigDecimal billAmount;
	
	@ManyToOne
	@JoinColumn(name = "ef_acaninvoicehdrid")
	@JsonBackReference
	private AdvanceCanAiVO advanceCanAiVO;
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	
}
