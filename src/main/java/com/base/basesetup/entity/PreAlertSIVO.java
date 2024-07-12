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
@Table(name="ef_siord_hdr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreAlertSIVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_siord_hdrgen")
	@SequenceGenerator(name = "ef_siord_hdrgen", sequenceName = "ef_siord_hdrseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_siord_hdrid")
	private Long id;
	@Column(name = "direct")
	private boolean direct;
	@Column(name = "autoedi")
	private boolean autoEdi;
	@Column(name = "docno")
	private String docNo;
	@Column(name = "docdate")
	private LocalDate docDate;
	@Column(name = "manifestno")
	private String manifestNo;
	@Column(name = "manifestdone")
	private boolean manifestDone;
	@Column(name = "jobassigned")
	private boolean jobAssigned;
	@Column(name = "smptno")
	private String smptNo;
	@Column(name = "seacarrier")
	private String seaCarrier;
	@Column(name = "itemdescription")
	private String itemDescription;
	@Column(name = "masterno")
	private String masterNo;
	@Column(name = "masterdate")
	private LocalDate masterDate;
	@Column(name = "igmno")
	private String igmNo;
	@Column(name = "igmdate")
	private LocalDate igmDate;
	@Column(name = "vesseleta")
	private String vesselEta;
	@Column(name = "masterfreight")
	private String masterFreight;
	@Column(name = "localigmno")
	private String localIgmNo;
	@Column(name = "localigmdate")
	private LocalDate localIgmDate;
	@Column(name = "noofpkgs")
	private String noOfPkgs;
	@Column(name = "grwtinkgs")
	private String grwtInKgs;
	@Column(name = "deffreightcurr")
	private String defFreightCurr;
	@Column(name = "deffreightcurr1")
	private BigDecimal defFreightCurr1;
	@Column(name = "pol")
	private String pol;
	@Column(name = "pod")
	private String pod;
	@Column(name = "cfs")
	private String cfs;
	@Column(name = "containerallocationdone")
	private boolean containerAllocationDone;
	@Column(name = "agent")
	private String agent;
	@Column(name = "consignee")
	private String consignee;
	@Column(name = "totpkgs")
	private BigDecimal totPkgs;
	@Column(name = "totgrwt")
	private BigDecimal totGrwt;
	@Column(name = "totvolume")
	private BigDecimal totVolume;
	@Column(name = "eta1")
	private String eta1;
	@Column(name = "cargohandover")
	private boolean cargoHandOver;
	@Column(name = "emptycontReturn")
	private boolean emptyContReturn;
	@Column(name = "emptycontsurrender")
	private boolean emptyContSurrender;
	@Column(name = "containercount")
	private String containerCount;
	@Column(name = "containerreturncount")
	private String containerReturnCount;
	@Column(name = "emptyreturncount")
	private String emptyReturnCount;
	
	
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
	
	@OneToMany(mappedBy = "preAlertSIVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<VesselDetailsSIVO> vesselDetailsSIVO;
	

	@OneToMany(mappedBy = "preAlertSIVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<HouseParticularsSIVO> houseParticularsSIVO;
	

	@OneToMany(mappedBy = "preAlertSIVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ContainerDetailsSIVO> containerDetailsSIVO;
	

	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
}
