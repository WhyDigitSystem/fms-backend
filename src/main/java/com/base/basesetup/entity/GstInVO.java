package com.base.basesetup.entity;

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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gstin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GstInVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gstingen")
	@SequenceGenerator(name = "gstingen", sequenceName = "gstinseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "gstinid")
	private Long id;
	@Column(name = "pan")
	private String pan;
	@Column(name = "partyname")
	private String partyName;
	@Column(name = "accounttype")
	private String accountType;
	@Column(name = "panname")
	private String panName;
	@Column(name = "bussinesstype")
	private String bussinessType;
	@Column(name = "businesscategory")
	private String businessCategory;

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
	
	@OneToMany(mappedBy = "gstInVO", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<StateGstVO> stateGstVO;


	@OneToMany(mappedBy = "gstInVO", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<BusinessAddressVO> businessAddressVO;

	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
