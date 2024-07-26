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
@Table(name="ef_sehaddressdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseAddressDetailsVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sehaddressdetailsgen")
	@SequenceGenerator(name = "ef_sehaddressdetailsgen", sequenceName = "ef_sehaddressdetailsseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sehaddressdetailsid")
	private Long id;
	@Column(name = "printshipper")
	private String printShipper;
	@Column(name = "blno")
	private String blNo;
	@Column(name = "shipperaddress")
	private String shipperAddress;
	@Column(name = "printconsignee")
	private String printConsignee;
	@Column(name = "consigneeaddress")
	private String consigneeAddress;
	@Column(name = "printnotify")
	private String printNotify;
	@Column(name = "notifyaddress")
	private String notifyAddress;
	@Column(name = "vesselvoyageno")
	private String vesselVoyageNo;
	@Column(name = "portofreceipt")
	private String portOfreceipt;
	@Column(name = "portofdelivery")
	private String portOfDelivery;
	@Column(name = "modesoftransport")
	private String modesOfTransport;
	@Column(name = "placeofacceptance")
	private String placeOfAcceptance;
	@Column(name = "dateofacceptance")
	private String dateOfAcceptance;
	@Column(name = "printconsignee1")
	private String PrintConsignee1;
	@Column(name = "portofdischarge")
	private String portOfDischarge;
	@Column(name = "finaldestination")
	private String finalDestination;
	
	@ManyToOne
	@JoinColumn(name = "ef_sehouse")
	@JsonBackReference
	private HouseBillOfLadingVO houseBillOfLadingVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
}
