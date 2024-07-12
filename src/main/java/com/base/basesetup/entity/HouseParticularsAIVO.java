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
@Table(name = "ef_aiord_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseParticularsAIVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aiord_dtlgen")
	@SequenceGenerator(name = "ef_aiord_dtlgen", sequenceName = "ef_aiord_dtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aiord_dtlid")
	private Long id;
	@Column(name = "housenO")
	private String houseNO;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "jobno")
	private String jobNo;
	@Column(name = "jobbranch")
	private String jobBranch;
	@Column(name = "closed")
	private String closed;
	@Column(name = "pkgs")
	private Long pkgs;
	@Column(name = "grwt")
	private BigDecimal grwt;
	@Column(name = "chwt")
	private BigDecimal chwt;
	@Column(name = "shipper")
	private String shipper;
	@Column(name = "consignee")
	private String consignee;
	@Column(name = "bro")
	private String bro;
	@Column(name = "notify")
	private String notify;
	@Column(name = "salescategory")
	private String salesCategory;
	@Column(name = "salesperson")
	private String salesPerson;
	@Column(name = "pod")
	private String pod;
	@Column(name = "fpod")
	private String fpod;
	@Column(name = "incoterm")
	private String incoterm;
	@Column(name = "freight")
	private String freight;
	@Column(name = "industry")
	private String industry;
	@Column(name = "billofentry")
	private String billOfEntry;
	@Column(name = "itemdescription")
	private String itemDescription;
	
	
	@ManyToOne
	@JoinColumn(name = "ef_aiord_hdrid")
	@JsonBackReference
	private PreAlertAIVO preAlertAIVO;
	
	
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	
}
