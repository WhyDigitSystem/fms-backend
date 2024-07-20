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
@Table(name="ef_aehousevoyagedetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoyageDetailsVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aehousevoyagedetailsgen")
	@SequenceGenerator(name = "ef_aehousevoyagedetailsgen", sequenceName = "ef_aehousevoyagedetailsseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aehousevoyagedetailsid")
	private Long id;
	@Column(name = "handlinginformation")
	private String handlingInformation;
	@Column(name = "noofpieces")
	private Long noOfPieces;
	@Column(name = "grossweight")
	private BigDecimal grossWeight;
	@Column(name = "rateclass")
	private String rateClass;
	@Column(name = "commodityitemno")
	private String commodityItemNo;
	@Column(name = "chargeableweightrate")
	private BigDecimal chargeableWeightRate;
	@Column(name = "ppd")
	private String ppd;
	@Column(name = "charge")
	private BigDecimal charge;
	@Column(name = "total")
	private Long total;
	
	@Column(name = "qtyoffoods")
	private String qtyOfFoods;
	@Column(name = "signature")
	private String signature;
	@Column(name = "myc")
	private BigDecimal myc;
	@Column(name = "xcr")
	private BigDecimal xcr;
	@Column(name = "xdc")
	private BigDecimal xdc;
	@Column(name = "mdc")
	private BigDecimal mdc;
	@Column(name = "ams")
	private BigDecimal ams;
	@Column(name = "awb")
	private BigDecimal awb;
	@Column(name = "valch")
	private BigDecimal valCh;
	@Column(name = "others")
	private BigDecimal others;
	@Column(name = "tax")
	private BigDecimal tax;
	@Column(name = "dueagentcharge")
	private BigDecimal dueAgentCharge;
	@Column(name = "printtype")
	private String printType;
	
	@ManyToOne
	@JoinColumn(name = "ef_aehouseid")
	@JsonBackReference
	private HouseAirWayBillVO houseAirWayBillVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	
}
