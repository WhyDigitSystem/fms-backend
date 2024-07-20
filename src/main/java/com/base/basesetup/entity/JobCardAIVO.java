package com.base.basesetup.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ef_aijobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobCardAIVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aijobsgen")
	@SequenceGenerator(name = "ef_aijobsgen", sequenceName = "ef_aijobsseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aijobsid")
	private Long id;
	@Column(name = "ordno")
	private String ordNo;
	@Column(name = "orddt")
	private LocalDate ordDt;
	@Column(name = "masterno")
	private Long masterNo;
	@Column(name = "masterdt")
	private LocalDate masterDt;

	@Column(name = "pkgs")
	private BigDecimal pkgs;
	@Column(name = "grwt")
	private BigDecimal grwt;
	
	@Column(name = "agent")
	private String agent;
	@Column(name = "mconsignee")
	private String mConsignee;
	@Column(name = "mcarrier")
	private String mCarrier;
	
	@Column(name = "Jobno")
	private String JobNo;
	@Column(name = "jobdate")
	private LocalDate jobDate;
	@Column(name = "houseno")
	private String houseNo;
	@Column(name = "housedate")
	private LocalDate houseDate;
	@Column(name = "pol")
	private String pol;
	@Column(name = "pod")
	private String pod;
	@Column(name = "finalpod")
	private String finalpod;
	@Column(name = "jobbranch")
	private String jobBranch;
	@Column(name = "chwt")
	private BigDecimal chwt;
	@Column(name = "hshipper")
	private String hShipper;
	@Column(name = "hconsignee")
	private String hConsignee;
	@Column(name = "notify")
	private String notify;
	@Column(name = "totalpkgs")
	private BigDecimal totalPkgs;
	@Column(name = "totalgrwt")
	private BigDecimal totalGrwt;
	@Column(name = "arrivedpkgs")
	private BigDecimal arrivedPkgs;
	@Column(name = "arrivedgrwt")
	private BigDecimal arrivedGrwt;
	@Column(name = "hfreight")
	private String hFreight;
	@Column(name = "salesperson")
	private String salesPerson;
	@Column(name = "customerinfo")
	private String customerInfo;
	@Column(name = "can")
	private String can;
	@Column(name = "ovinvoice")
	private String ovInvoice;
	@Column(name = "do")
	private String do1;
	@Column(name = "bro")
	private String bro;
	@Column(name = "shipperinvoiceno")
	private String shipperInvoiceNo;
	@Column(name = "billofentry")
	private String billOfEntry;
	@Column(name = "assval")
	private String assVal;
	@Column(name = "arrivedate")
	private LocalDate arrivedDate;
	@Column(name = "lossType")
	private String lossType;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "income")
	private BigDecimal income;
	@Column(name = "expense")
	private BigDecimal expense;
	@Column(name = "profit")
	private BigDecimal profit;
	@Column(name = "continuedjob")
	private boolean continuedJob;
	@Column(name = "estimatedarrival")
	private LocalDate estimatedArrival;
	@Column(name = "opsclosed")
	private boolean opsClosed;
	@Column(name = "opscloseddate")
	private LocalDate opsClosedDate;
	@Column(name = "closedBy")
	private String closedBy;
	@Column(name = "confirmed")
	private boolean confirmed;
	@Column(name = "confirmeddate")
	private LocalDate confirmedDate;
	@Column(name = "confirmedby")
	private String confirmedBy;

	@Column(name = "active")
	private boolean active;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "modifiedby")
	private String updatedBy;
	@Column(name = "orgid")
	private Long orgId;
	@Column(name = "cancel")
	private boolean cancel;
	@Column(name = "cancelremarks")
	private boolean cancelRemarks;

}
