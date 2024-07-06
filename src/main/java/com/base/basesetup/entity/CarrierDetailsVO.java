package com.base.basesetup.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "ef_aemastercarrierdtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarrierDetailsVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aemastercarrierdtlgen")
	@SequenceGenerator(name = "ef_aemastercarrierdtlgen", sequenceName = "ef_aemastercarrierdtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aemastercarrierdtlid")
	private Long id;
	@Column(name = "frightno")
	private String frightNo;
	@Column(name = "etd")
	private LocalDate etd;
	@Column(name = "etdtime")
	private LocalDateTime etdTime;
	@Column(name = "eta")
	private LocalDate eta;
	@Column(name = "etatime")
	private LocalDateTime etaTime;
	@Column(name = "pol")
	private String pol;
	@Column(name = "pod")
	private String pod;
	
	@ManyToOne
	@JoinColumn(name = "ef_aemasterhdrid")
	@JsonBackReference
	private MasterAirWayBillVO masterAirWayBillVO;

	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
