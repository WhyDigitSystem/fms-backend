package com.base.basesetup.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_aesohdr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentAOVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipmentaogen")
	@SequenceGenerator(name = "shipmentaogen", sequenceName = "shipmentaoseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "shipmentaoid")
	private Long id;
	@Column(name = "docid")
	private String docId;
	@Column(name = "docdate")
	private LocalDate docDate;
	@Column(name = "globalshipno")
	private String globalShipNo;
	@Column(name = "pol")
	private String pol;
	@Column(name = "pod")
	private String pod;
	@Column(name = "jobno")
	private String jobNO;
	@Column(name = "jobdate")
	private LocalDate jobDate;
	@Column(name = "fpod")
	private String fpod;
	@Column(name = "nominatedby")
	private String nominatedBy;
	@Column(name = "hawbno")
	private String hawbNO;
	@Column(name = "hawbdate")
	private LocalDate hawbDate;
	@Column(name = "deliveryterms")
	private String deliveryTerms;
	@Column(name = "freight")
	private String freight;
	@Column(name = "mawbno")
	private String mawbNo;
	@Column(name = "mawbdate")
	private String mawbDate;
	@Column(name = "projectcargo")
	private boolean projectCargo;
	@Column(name = "directmaster")
	private boolean directMaster;
	@Column(name = "jobassigned")
	private boolean jobAssigned;
	@Column(name = "masterfinalize")
	private boolean masterFinalize;
	@Column(name = "shipperinvoiceno")
	private String shipperInvoiceNo;
	@Column(name = "billofentry")
	private String billOfEntry;
	@Column(name = "shipper")
	private String shipper;
	@Column(name = "saddtype")
	private String sAddType;
	@Column(name = "saddress")
	private String sAddress;
	@Column(name = "notify")
	private String notify;
	@Column(name = "naddtype")
	private String nAddType;
	@Column(name = "naddress")
	private String nAddress;
	@Column(name = "consignee")
	private String consignee;
	@Column(name = "caddtype")
	private String caddType;
	@Column(name = "caddress")
	private String cAddress;
	@Column(name = "salescategory")
	private String salesCategory;
	@Column(name = "salesperson")
	private String salesPerson;
	@Column(name = "totalnoofpkgs")
	private BigDecimal totalNoOfPkgs;
	@Column(name = "totalgrtwt")
	private BigDecimal totalGrtWt;
	@Column(name = "totalchwt")
	private BigDecimal totalChWt;
	@Column(name = "totalvolwt")
	private BigDecimal totalVolWt;
	@Column(name = "totestimatiomcost")
	private BigDecimal totEstimationCost;
	
	
	@Column(name = "cancel")
	private boolean cancel;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "modifiedby")
	private String  updatedBy;
	@Column(name = "cancelremarks")
	private String cancelRemarks;
	@Column(name="orgid")
	private Long orgId;
	@Column(name="active")
    private boolean active;
	
	@OneToMany(mappedBy = "shipmentAOVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PackingListVO> packingListVO;
	
	@OneToMany(mappedBy = "shipmentAOVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<CostEstimateVO> costEstimateVO;
	
	
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	
	

}
