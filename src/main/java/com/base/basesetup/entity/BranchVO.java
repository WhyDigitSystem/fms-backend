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
@Table(name = "branch")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BranchVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branchgen")
	@SequenceGenerator(name = "branchgen", sequenceName = "branchseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "branchid")
	private Long id;
	@Column(name = "mastertype")
	private String mastertype;
	@Column(name = "company")
	private String company;
	@Column(name = "addressline1")
	private String addressLine1;
	@Column(name = "stcode")
	private String stCode;
	@Column(name = "stregno")
	private String stRegNo;
	@Column(name = "branchcode")
	private String branchCode;
	@Column(name = "addressline2")
	private String addressLine2;
	@Column(name = "panno")
	private String panNo;
	@Column(name = "gstin")
	private String gstIn;
	@Column(name = "branch")
	private String branchName;
	@Column(name = "country")
	private String country;
	@Column(name = "state")
	private String state;
	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private String pinCode;
	@Column(name = "stateno")
	private String stateNo;
	@Column(name = "statecode")
	private String stateCode;
	@Column(name = "region")
	private String region;
	@Column(name = "cgmprefix")
	private String cgmPrefix;
	@Column(name = "carnlogin")
	private String carnLogic;
	@Column(name = "racode")
	private String raCode;
	@Column(name = "lccurrency")
	private String lcCurrency;
	@Column(name = "letterpadfooter1")
	private String letterPadFooter1;
	@Column(name = "letterpadfooter2")
	private String letterPadFooter2;

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
