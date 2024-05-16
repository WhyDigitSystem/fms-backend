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
@Table(name = "listofvalues1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListOfValues1VO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "listofvalues1gen")
	@SequenceGenerator(name = "listofvalues1gen", sequenceName = "listofvalues1seq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "listofvalues1id")
	private Long id;
	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@Column(name = "active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "listofvaluesid")
	@JsonBackReference
	private ListOfValuesVO listOfValuesVO;
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

}
