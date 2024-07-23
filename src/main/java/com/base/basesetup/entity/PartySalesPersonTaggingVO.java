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
@Table(name = "partysalespersontagging")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartySalesPersonTaggingVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partysalespersontagginggen")
	@SequenceGenerator(name = "partysalespersontagginggen", sequenceName = "partysalespersontaggingseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "partysalespersontaggingid")
	private Long id;
	@Column(name = "salesperson")
	private String salesPerson;
	@Column(name = "empcode")
	private String empCode;
	@Column(name = "salesbranch")
	private String salesBranch;
	@Column(name = "effectivefrom")
	private String effectiveFrom;
	@Column(name = "effectivetill")
	private String effectiveTill;
	
	@ManyToOne
	@JoinColumn(name = "partymasterid")
	@JsonBackReference
	private PartyMasterVO partyMasterVO;
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
