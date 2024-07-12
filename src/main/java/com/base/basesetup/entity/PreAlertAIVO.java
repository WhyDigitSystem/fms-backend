package com.base.basesetup.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@Table(name="ef_aiord_hdr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreAlertAIVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_aiord_hdrgen")
	@SequenceGenerator(name = "ef_aiord_hdrgen", sequenceName = "ef_aiord_hdrseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_aiord_hdrid")
	private Long id;
	@Column(name = "direct")
	private boolean direct;
	@Column(name = "docno")
	private String docNo;
	@Column(name = "docdate")
	private LocalDate docDate;
	@Column(name = "aircarrier")
	private String airCarrier;
	@Column(name = "aircarriertype")
	private String airCarrierType;
	@Column(name = "flightdate")
	private LocalDate flightDate;
	@Column(name = "flighttime")
	private LocalDateTime flightTime;
	@Column(name = "masterdate")
	private LocalDate masterDate;
	@Column(name = "shiptype")
	private String shipType;
	@Column(name = "grwt")
	private BigDecimal grWt;
	@Column(name = "pol")
	private String pol;
	@Column(name = "docdate1")
	private LocalDate docDate1;
	@Column(name = "flightno")
	private String flightNo;
	@Column(name = "masterno")
	private Long masterNo;
	@Column(name = "masterno1")
	private Long masterNo1;
	@Column(name = "noofpkgs")
	private Long noOfPkgs;
	@Column(name = "chwt")
	private BigDecimal chWt;
	@Column(name = "pod")
	private String pod;
	@Column(name = "manifestdone")
	private boolean manifestDone;
	@Column(name = "jobassigned")
	private String jobAssigned;
	@Column(name = "agent")
	private String agent;
	@Column(name = "consignee")
	private String consignee;
	@Column(name = "itemdescription")
	private String itemDescription;
	@Column(name = "igmno")
	private Long igmNo;
	@Column(name = "igmnodate")
	private LocalDate igmNoDate;
	@Column(name = "deffreightcurr")
	private String defFreightCurr;
	@Column(name = "deffreightcurr1")
	private BigDecimal defFreightCurr1;
	@Column(name = "masterfreight")
	private Long masterFreight;
	@Column(name = "airlinedono")
	private Long airlineDoNo;
	@Column(name = "Sectorawd")
	private Long SectorAwd;
	@Column(name = "tothousepkgs")
	private Long totHousePkgs;
	@Column(name = "tothousegrwt")
	private BigDecimal totHouseGrwt;
	@Column(name = "tothousechwt")
	private BigDecimal totHouseChWt;
	
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
	
	@OneToMany(mappedBy = "preAlertAIVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<HouseParticularsAIVO> houseParticularsAIVO;
	
	@OneToMany(mappedBy = "preAlertAIVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PreAlertCarrierDetailsAIVO> preAlertCarrierDetailsAIVO;
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
	
	
}
