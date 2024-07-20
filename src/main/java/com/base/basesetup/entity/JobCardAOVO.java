package com.base.basesetup.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.fasterxml.jackson.annotation.JsonGetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ef_aejobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobCardAOVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aejobsgen")
	@SequenceGenerator(name = "ef_scaninvoicehdrgen", sequenceName = "ef_aejobsseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aejobsid")
	private Long id;
	@Column(name = "ordno")
	private String ordNo;
	@Column(name = "orddt")
	private LocalDate ordDt;
	@Column(name = "masterno")
	private String masterNo;
	@Column(name = "masterdt")
	private LocalDate masterDt;
	@Column(name = "direct")
	private boolean direct;
	@Column(name = "project")
	private boolean project;
	@Column(name = "finalized")
	private boolean finalized;
	@Column(name = "masterbranch")
	private String masterBranch;
	@Column(name = "mshipper")
	private String mShipper;
	@Column(name = "mconsignee")
	private String mConsignee;
	@Column(name = "mcarrier")
	private String mCarrier;
	@Column(name = "mfreight")
	private String mFreight;
	@Column(name = "jobno")
	private String jobNo;
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
	@Column(name = "uwlhouseno")
	private String uwlHouseNo;
	@Column(name = "hshipper")
	private String hShipper;
	@Column(name = "hconsignee")
	private String hConsignee;
	@Column(name = "totalpkgs")
	private BigDecimal totalPkgs;
	@Column(name = "totalgrwt")
	private BigDecimal totalGrwt;
	@Column(name = "chwt")
	private BigDecimal chwt;
	@Column(name = "hfreight")
	private String hFreight;
	@Column(name = "salesperson")
	private String salesPerson;
	@Column(name = "customerinfo")
	private String customerInfo;
	@Column(name = "shipperinvoiceno")
	private String shipperInvoiceNo;
	@Column(name = "billofentry")
	private String billOfEntry;
	@Column(name = "assval")
	private String assVal;
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
	@Column(name = "estimatingsailingdate")
	private LocalDate estimatingSailingDate;
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

	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}

}
