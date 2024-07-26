package com.base.basesetup.entity;

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
@Table(name="ef_sehshipperparticular")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseShipperParticularVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sehshipperparticulargen")
	@SequenceGenerator(name = "ef_sehshipperparticulargen", sequenceName = "ef_sehshipperparticularseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sehshipperparticularid")
	private Long id;
	@Column(name = "containerdetails")
	private String containerDetails;
	@Column(name = "containerno")
	private String containerNo;
	@Column(name = "qualityandkindpackage")
	private String qualityAndKindPackage;
	@Column(name = "descriptionofgoods")
	private String descriptionOfGoods;
	@Column(name = "grossweight")
	private String grossWeight;
	@Column(name = "netweight")
	private String netWeight;
	@Column(name = "agentaddress")
	private String agentAddress;
	@Column(name = "deliveryaddress")
	private String deliveryAddress;
	@Column(name = "measurement")
	private String measurement;
	@Column(name = "placedateofissue")
	private String placeDateOfIssue;
	
	@Column(name = "Noforiginal")
	private String NoOfOriginal;
	@Column(name = "freightcharges")
	private String freightCharges;
	@Column(name = "prepaid")
	private String prepaid;
	@Column(name = "collect")
	private String collect;
	@Column(name = "onboard")
	private String onBoard;
	@Column(name = "noofcontainer")
	private String noOfContainer;
	@Column(name = "freightdetails")
	private String freightDetails;
	@Column(name = "containerno1")
	private String containerNo1;
	@Column(name = "sealno")
	private String sealNo;
	@Column(name = "GrossWtKgs")
	private String GrossWtKgs;
	
	@Column(name = "agentcarrier")
	private String agentCarrier;
	@Column(name = "signature")
	private String signature;
	@Column(name = "signatureby")
	private String signatureBy;
	@Column(name = "netwtkgs")
	private String netWtKgs;
	@Column(name = "packages")
	private String packages;
	
	@ManyToOne
	@JoinColumn(name = "ef_sehouse")
	@JsonBackReference
	private HouseBillOfLadingVO houseBillOfLadingVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
