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
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_sesohdr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentSOVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_sesohdrgen")
	@SequenceGenerator(name = "t_sesohdrgen", sequenceName = "t_sesohdrseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "t_sesohdrid")
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
	@Column(name = "shippingbill")
	private String shippingBill;
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "documentreceived")
	private boolean documentReceived;
	@Column(name = "pickupdone")
	private boolean pickUpDone;
	@Column(name = "customsclearancedone")
	private boolean customsClearanceDone;
	@Column(name = "documentreceiveddate")
	private LocalDate documentReceiveddate;
	@Column(name = "pickupdonedate")
	private LocalDate pickUpDonedate;
	@Column(name = "customsclearancedonedate")
	private LocalDate customsClearanceDonedate;
	@Column(name = "containercount")
	private Long containerCount;
	@Column(name = "cfcinwarddate")
	private LocalDate cfcInwardDate;
	@Column(name = "contbookingdate")
	private LocalDate contBookingDate;
	@Column(name = "emptycontpickupdate")
	private LocalDate emptyContPickupDate;
	@Column(name = "stuffingdate")
	private LocalDate stuffingDate;
	@Column(name = "railmentdate")
	private LocalDate railmentDate;
	@Column(name = "contterminalhandover")
	private LocalDate contTerminalHandover;	
	@Column(name = "cargohandover")
	private boolean cargoHandOver;
	@Column(name = "cargohandoverdate")
	private LocalDate cargoHandOverDate;
	@Column(name = "emptycontreturn")
	private boolean emptyContReturn;
	@Column(name = "emptycontreturndate")
	private LocalDate emptyContReturnDate;
	@Column(name = "emptycontsurrender")
	private boolean emptyContSurrender;
	@Column(name = "emptycontsurrenderdate")
	private LocalDate emptyContSurrenderDate;
	@Column(name = "containerreturncount")
	private Long containerReturnCount;
	@Column(name = "emptyreturnremarks")
	private String emptyReturnRemarks;
	
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
	
	@OneToMany(mappedBy = "shipmentSOVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<SoPackingListVO> soPackingListVO;
	
	@OneToMany(mappedBy = "shipmentSOVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<SoCostEstimateVO> soCostEstimateVO;
	
	
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
}
