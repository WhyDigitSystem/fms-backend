package com.base.basesetup.entity;

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
@Table(name = "t_aesocost")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CostEstimateVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_aesocostgen")
	@SequenceGenerator(name = "t_aesocostgen", sequenceName = "t_aesocostseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "t_aesocostid")
	private Long id;
	@Column(name = "partyvendor")
	private String partyVendor;
	@Column(name = "linearcarrier")
	private String linearCarrier;
	@Column(name = "billtocustomer")
	private String billToCustomer;
	@Column(name = "chargecode")
	private String chargeCode;
	@Column(name = "description")
	private String description;
	@Column(name = "amountininr")
	private String amountInInr;
	@Column(name = "estimatepaydate")
	private LocalDate estimatePayDate;
	@Column(name = "funreqdate")
	private LocalDate funReqDate;
	
	
	
	@ManyToOne
	@JoinColumn(name = "shipmentaoid")
	@JsonBackReference
	private ShipmentAOVO shipmentAOVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	
	
}
