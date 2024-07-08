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
@Table(name = "ef_aemasterprintdtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrintDetailsVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aemasterprintdtlgen")
	@SequenceGenerator(name = "ef_aemasterprintdtlgen", sequenceName = "ef_aemasterprintdtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aemasterprintdtlid")
	private Long id;
	@Column(name = "carrierdtl")
	private String carrierDtl;
	@Column(name = "agentiata")
	private String agentIata;
	@Column(name = "deptairport")
	private String deptAirport;
	@Column(name = "destairport")
	private String destAirport;
	@Column(name = "iatacarrier")
	private String iataCarrier;
	@Column(name = "secondcarrier")
	private String secondCarrier;
	@Column(name = "secondcarrier1")
	private String secondCarrier1;
	@Column(name = "thirdcarrier")
	private String thirdCarrier;
	@Column(name = "thirdcarrier1")
	private String thirdcarrier1;
	@Column(name = "masterno")
	private String masterNo;
	@Column(name = "accountinfo")
	private String accountInfo;
	@Column(name = "carriage")
	private String carriage;
	@Column(name = "customer")
	private String customer;
	@Column(name = "accountno")
	private Long accountNo;
	@Column(name = "reqflight")
	private String reqFlight;
	@Column(name = "reqflightdate")
	private LocalDate reqFlightDate;
	@Column(name = "handinginfo")
	private String handingInfo;
	@Column(name = "noofpcs")
	private Long noOfPcs;
	@Column(name = "totalnoofpcs")
	private Long totalNoOfPcs;
	@Column(name = "grosswgt")
	private BigDecimal grossWgt;
	@Column(name = "totalcrosswgt")
	private BigDecimal totalCrossWgt;
	@Column(name = "kgbl")
	private BigDecimal kgbl;
	@Column(name = "rateclass")
	private String rateclass;
	@Column(name = "chargeweight")
	private String chargeweight;
	@Column(name = "ratecharge")
	private BigDecimal rateCharge;
	@Column(name = "total")
	private BigDecimal total;
	@Column(name = "sumoftotal")
	private BigDecimal sumOfTotal;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "Printnotify1")
	private String PrintNotify1;
	@Column(name = "Printnotify2")
	private String PrintNotify2;
	@Column(name = "myc")
	private BigDecimal myc;
	@Column(name = "xdc")
	private BigDecimal xdc;
	@Column(name = "ams")
	private BigDecimal ams;
	@Column(name = "valch")
	private BigDecimal valch;
	@Column(name = "tax")
	private BigDecimal tax;
	@Column(name = "ppd")
	private String ppd;
	@Column(name = "xcr")
	private BigDecimal xcr;
	@Column(name = "mdc")
	private BigDecimal mdc;
	@Column(name = "aws")
	private BigDecimal aws;
	@Column(name = "others")
	private BigDecimal others;
	@Column(name = "duoagentcharge")
	private BigDecimal duoAgentCharge;
	@Column(name = "preparedby")
	private BigDecimal preparedBy;
	
	@ManyToOne
	@JoinColumn(name = "ef_aemasterhdrid")
	@JsonBackReference
	private MasterAirWayBillVO masterAirWayBillVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();


	
}
