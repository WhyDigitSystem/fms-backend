package com.base.basesetup.entity;

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
@Table(name="ef_aehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseAirWayBillVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aehousegen")
	@SequenceGenerator(name = "ef_aehousegen", sequenceName = "ef_aehouseseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aehouseid")
	private Long id;
	@Column(name = "hawbno")
	private String hawbNo;
	@Column(name = "hawbdate")
	private LocalDate hawbDate;
	@Column(name = "uwlhawb")
	private String uwlHawb;
	@Column(name = "sono")
	private String soNo;
	@Column(name = "sodate")
	private LocalDate soDate;
	@Column(name = "jobno")
	private String jobNO;
	@Column(name = "jobdate")
	private LocalDate jobDate;
	@Column(name = "mawbno")
	private String mawbNo;
	@Column(name = "masterfinalize")
	private boolean masterFinalize;
	
	@Column(name = "printshipper")
	private String printShipper;
	@Column(name = "shipperaddress")
	private String shipperAddress;
	@Column(name = "printnotify")
	private String printNotify;
	@Column(name = "notifyaddress")
	private String notifyAddress;
	@Column(name = "printnotify1")
	private String printNotify1;
	@Column(name = "printconsignee")
	private String printConsignee;
	@Column(name = "consigneeaddress")
	private String consigneeAddress;
	@Column(name = "accountinformation")
	private String accountInformation;
	@Column(name = "issuingconsolidation")
	private String issuingConsolidation;
	@Column(name = "iatacode")
	private String iataCode;
	@Column(name = "departure")
	private String departure;
	@Column(name = "iatacarrier")
	private String iataCarrier;
	@Column(name = "destination")
	private String destination;
	@Column(name = "destination1")
	private String destination1;
	@Column(name = "dvcarriage")
	private String dvCarriage;
	@Column(name = "dvcustomer")
	private String dvCustomer;
	@Column(name = "secondcarrier")
	private String secondCarrier;
	@Column(name = "thirdcarrier")
	private String thirdCarrier;
	
	
	
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
	
	@OneToMany(mappedBy = "houseAirWayBillVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<VoyageDetailsVO> voyageDetailsVO;
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
	
}
