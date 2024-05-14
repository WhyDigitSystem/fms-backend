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
@Table(name = "subtypes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubTypesVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subtypesgen")
	@SequenceGenerator(name = "subtypesgen", sequenceName = "subtypeseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "subtypesid")
	private Long id;
	@Column(name = "subtype")
	private String subType;
	@Column(name = "subtypecode")
	private String subTypeCode;
	@Column(name = "subtypename")
	private String subTypeName;
	@Column(name = "month")
	private String month;
	
	@ManyToOne
	@JoinColumn(name = "documenttypeid")
	@JsonBackReference
	private DocumentTypeVO documentTypeVO;
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

}
