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
@Table(name = "ef_sido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryOrderSIVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sidogen")
	@SequenceGenerator(name = "ef_sidogen", sequenceName = "ef_sidoseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sidoid")
	private Long id;
	@Column(name = "dono")
	private String doNo;
	@Column(name = "dodate")
	private LocalDate doDate;
	@Column(name = "consignee")
	private String consignee;
	@Column(name = "irnno")
	private String irnNo;
	@Column(name = "candate")
	private LocalDate canDate;
	@Column(name = "totalPkgs")
	private BigDecimal totalPkgs;
	@Column(name = "brostatus")
	private String broStatus;
	@Column(name = "brorecd")
	private String broRecd;
	@Column(name = "jobno")
	private String jobNo;
	@Column(name = "jobdate")
	private LocalDate jobDate;
	@Column(name = "totalgrwt")
	private BigDecimal totalGrwt;
	@Column(name = "masterno")
	private String masterNo;
	@Column(name = "houseno")
	private String houseNo;
	@Column(name = "natureofgoods")
	private String natureOfGoods;
	@Column(name = "brorefno")
	private String broRefNo;
	@Column(name = "brorefdate")
	private LocalDate broRefDate;
	@Column(name = "igmno")
	private String igmNo;
	@Column(name = "itemno")
	private String itemNo;
	@Column(name = "canamount")
	private BigDecimal canAmount;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "orderto")
	private String orderTo;
	@Column(name = "cha")
	private String cha;
	@Column(name = "cfs")
	private String cfs;

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
