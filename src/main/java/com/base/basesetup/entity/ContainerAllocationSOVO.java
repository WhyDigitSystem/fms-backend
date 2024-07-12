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
@Table(name="ef_sesohdr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContainerAllocationSOVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sesohdrgen")
	@SequenceGenerator(name = "ef_sesohdrgen", sequenceName = "ef_sesohdrseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sesohdrid")
	private Long id;
	@Column(name = "docid")
	private String docId;
	@Column(name = "docdate")
	private LocalDate docDate;
	@Column(name = "globalshipno")
	private String globalShipNo;
	@Column(name = "pono")
	private String poNo;
	@Column(name = "jobno")
	private String jobNo;
	@Column(name = "pol")
	private String pol;
	@Column(name = "pod")
	private String pod;
	@Column(name = "hblno")
	private String hblNo;
	@Column(name = "fpod")
	private String fpod;
	@Column(name = "nominatedby")
	private String nominatedBy;
	@Column(name = "mblno")
	private String mblNo;
	@Column(name = "deliveryterms")
	private String deliveryTerms;
	@Column(name = "freight")
	private String freight;
	@Column(name = "directmaster")
	private boolean directMaster;
	@Column(name = "masterfinalized")
	private boolean masterFinalized;
	@Column(name = "totpkgs")
	private BigDecimal totPkgs;
	@Column(name = "totgrwt")
	private BigDecimal totGrWt;
	@Column(name = "totvolwt")
	private BigDecimal totVolWt;
	
	@Column(name = "ft20")
	private Long ft20;
	@Column(name = "ft40")
	private Long ft40;
	@Column(name = "ft45")
	private Long ft45;
	@Column(name = "cbm")
	private BigDecimal cbm;
	
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
	
	@OneToMany(mappedBy = "containerAllocationSOVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ContainerDetailsSOVO> containerDetailsSOVO;
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	

}
