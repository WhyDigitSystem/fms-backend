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
@Table(name = "ef_aemasterdtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseDetailsVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aemasterdtlgen")
	@SequenceGenerator(name = "ef_aemasterdtlgen", sequenceName = "ef_aemasterdtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aemasterdtlid")
	private Long id;
	@Column(name = "jobno")
	private String jobNo;
	@Column(name = "houseno")
	private String houseNo;
	@Column(name = "sno")
	private String sNo;
	@Column(name = "hshipper")
	private String hShipper;
	@Column(name = "hconsignee")
	private String hConsignee;
	@Column(name = "pkgs")
	private Long pkgs;
	@Column(name = "grwt")
	private BigDecimal grwt;
	@Column(name = "chwt")
	private BigDecimal chwt;
	@Column(name = "fpod")
	private String fpod;
	@Column(name = "jobremarks")
	private String jobRemarks;

	@ManyToOne
	@JoinColumn(name = "ef_aemasterhdrid")
	@JsonBackReference
	private MasterAirWayBillVO masterAirWayBillVO;
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	
}
