package com.base.basesetup.entity;

import java.math.BigDecimal;

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
@Table(name = "ef_aemasterchargedtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeclaredByVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aemasterchargedtlgen")
	@SequenceGenerator(name = "ef_aemasterchargedtlgen", sequenceName = "ef_aemasterchargedtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aemasterchargedtlid")
	private Long id;
	@Column(name = "chargetype")
	private String chargeType;
	@Column(name = "code")
	private String code;
	@Column(name = "chargecode")
	private String chargeCode;
	@Column(name = "chargedesc")
	private String chargeDesc;
	@Column(name = "currency")
	private String currency;
	@Column(name = "exrate")
	private BigDecimal exRate;
	@Column(name = "applyon")
	private String applyOn;
	@Column(name = "qty")
	private BigDecimal qty;
	@Column(name = "rate")
	private String rate;
	@Column(name = "fcaccount")
	private BigDecimal fcAccount;
	@Column(name = "lcaccount")
	private BigDecimal lcAccount;
	@Column(name = "payto")
	private String payTo;
	@Column(name = "terms")
	private String terms;
	
	@ManyToOne
	@JoinColumn(name = "ef_aemasterhdrid")
	@JsonBackReference
	private MasterAirWayBillVO masterAirWayBillVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
