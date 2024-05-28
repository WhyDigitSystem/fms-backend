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
@Table(name = "stategst")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateGstVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "stategstgen")
	@SequenceGenerator(name = "stategstgen", sequenceName = "stategstseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "stategstid")
	private Long id;
	@Column(name = "stategst")
	private String stateGst;
	@Column(name = "gstin")
	private String gstIn;
	@Column(name = "statecode")
	private String stateCode;
	@Column(name = "contactperson")
	private String contactPerson;
	@Column(name = "contactphoneno")
	private String contactPhoneNo;
	@Column(name = "contactemail")
	private String contactEmail;
	
	
	@ManyToOne
	@JoinColumn(name = "gstinid")
	@JsonBackReference
	private GstInVO gstInVO ;

	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
