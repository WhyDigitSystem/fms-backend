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
@Table(name = "designation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignationVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "designationgen")
	@SequenceGenerator(name = "designationgen",sequenceName = "designationseq",initialValue = 1000000001,allocationSize = 1)
	@Column(name="designationid")
	private Long designationId;
	@Column(name="designation", length = 30)
	private String designation;
	
	@Column(name="createdby", length = 30)
	private String createdBy;
	@Column(name="modifiedby", length = 30)
	private String updatedBy;
	@Column(name="orgid")
	private Long orgId;
	@Column(name="cancel")
	private boolean cancel;
	@Column(name="cancelremarks",length =50)
	private boolean cancelRemarks;
	private boolean active;
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}

