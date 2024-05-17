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
@Table(name = "businessaddress")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessAddressVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "businessaddressgen")
	@SequenceGenerator(name = "businessaddressgen", sequenceName = "businessaddressseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "businessaddressid")
	private Long id;
	@Column(name = "state")
	private String state;
	@Column(name = "businessplace")
	private String businessPlace;
	@Column(name = "cityname")
	private String cityName;
	@Column(name = "address1")
	private String address1;
	@Column(name = "address2")
	private String address2;
	@Column(name = "contactperson")
	private String contactPerson;
	@Column(name = "contactphoneno")
	private long contactPhoneNo;
	@Column(name = "contactemail")
	private String contactEmail;
	

	@ManyToOne
	@JoinColumn(name = "gstinid")
	@JsonBackReference
	private GstInVO gstInVO;

	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	
}
