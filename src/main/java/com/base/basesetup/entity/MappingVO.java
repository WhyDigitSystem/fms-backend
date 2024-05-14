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
@Table(name = "mapping")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MappingVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mappinggen")
	@SequenceGenerator(name = "mappinggen", sequenceName = "mappingseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "mappingid")
	private Long id;
	@Column(name = "doctype")
	private String docType;
	@Column(name = "subtype")
	private String subType;
	@Column(name = "subtypeid")
	private String subTypeId;
	@Column(name = "subtypecode")
	private String subTypeCode;
	@Column(name = "docname")
	private String docname;
	@Column(name = "prefix")
	private String prefix;
	@Column(name = "postfinance")
	private boolean postFinance;
	@Column(name = "lastno")
	private int lastNo;
	@Column(name = "resetonfinyesr")
	private boolean resetOnFinYear;
	
	@ManyToOne
	@JoinColumn(name = "documenttypemappingid")
	@JsonBackReference
	private DocumentTypeMappingVO documentTypeMappingVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
