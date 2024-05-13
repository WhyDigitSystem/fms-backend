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
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companygen")
	@SequenceGenerator(name = "companygen", sequenceName = "companyseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "companyid")
	private Long id;
	@Column(name = "company")
	private String companyName;
	@Column(name = "companycode")
	private String companyCode;
	@Column(name = "email")
	private String email;
	@Column(name = "phoneno")
	private Long phoneNo;
	@Column(name = "address")
	private String address;
	@Column(name = "country")
	private String country;
	@Column(name = "state")
	private String state;
	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private String pinCode;
	@Column(name = "adminemail")
	private String adminEmail;
	@Column(name = "passport")
	private String passport;
	@Column(name="userid")
    private String userId;
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
	@Column(name="active")
    private boolean active;
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

}
