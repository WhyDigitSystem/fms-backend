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
@Table(name = "ef_aemasterhdr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MasterAirWayBillVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aemasterhdrgen")
	@SequenceGenerator(name = "ef_aemasterhdrgen", sequenceName = "ef_aemasterhdrseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aemasterhdrid")
	private Long id;
	@Column(name = "carrier")
	private String carrier;
	@Column(name = "mawbno")
	private String mawbNo;
	@Column(name = "pol")
	private String pol;
	@Column(name = "shiptype")
	private String shipType;
	@Column(name = "frtcurrency")
	private String frtCurrency;
	@Column(name = "otherdetails")
	private String otherDetails;
	@Column(name = "onboard")
	private boolean onBoard;
	@Column(name = "mawddate")
	private LocalDate mawdDate;
	@Column(name = "pod")
	private String pod;
	@Column(name = "freight")
	private String freight;
	@Column(name = "exrate",precision = 20,scale = 7)
	private BigDecimal exRate;
	@Column(name = "prealertsend")
	private boolean preAlertSend;
	@Column(name = "finalized")
	private boolean finalized;
	@Column(name = "shipper")
	private String shipper;
	@Column(name = "shipperaddtype")
	private String shipperAddType;
	@Column(name = "shipperaddress")
	private String shipperaddress;
	@Column(name = "consignee")
	private String consignee;
	@Column(name = "consigneeaddtype")
	private String consigneeAddType;
	@Column(name = "consigneeaddress")
	private String consigneeAddress;
	@Column(name = "executingbranch")
	private String executingBranch;
	@Column(name = "totalhousegrwt")
	private BigDecimal totalHouseGrwt;
	@Column(name = "totalnoofpkgs")
	private BigDecimal totalNoOfPkgs;
	@Column(name = "totalhousechwt")
	private Long totalHouseChWt;
	@Column(name = "masterchwt")
	private BigDecimal masterChwt;
	@Column(name = "volumeshare")
	private Long volumeShare;
	
	
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
	
	
	@OneToMany(mappedBy = "masterAirWayBillVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<HouseDetailsVO> houseDetailsVO;
	
	@OneToMany(mappedBy = "masterAirWayBillVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<CarrierDetailsVO> carrierDetailsVO;
	
	@OneToMany(mappedBy = "masterAirWayBillVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<DeclaredByVO> declaredByVO;
	
	@OneToMany(mappedBy = "masterAirWayBillVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PrintDetailsVO> printDetailsVO;
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
}
