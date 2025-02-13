package com.base.basesetup.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countryseqgen")
    @SequenceGenerator(name = "countryseqgen", sequenceName = "Countryseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name="countryid")
	private Long id;
	
	@Column(name="code")
	private String countryCode;
	
	@Column(name="country")
	private String country;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "userid")
	private String userId;
	
	@Column(unique = true)
	private String dupchk;

	@Column(name = "cancel")
	private boolean cancel;

	@Column(name = "createdby")
	private String createdBy;

	@Column(name = "modifiedby")
	private String updatedBy;

	@Column(name = "cancelremarks")
	private String cancelRemarks;
	
	@Column(name="orgid")
	private Long orgId;
	
	
    @Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}


