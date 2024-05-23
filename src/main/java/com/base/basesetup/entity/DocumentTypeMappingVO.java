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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documenttypemapping")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeMappingVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documenttypemappinggen")
	@SequenceGenerator(name = "documenttypemappinggen", sequenceName = "documenttypemappingseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "documenttypemappingid")
	private Long id;
	@Column(name = "branch")
	private String branch;
	@Column(name = "financialyear")
	private String financialYear;
	
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
	
	
	@OneToMany(mappedBy = "documentTypeMappingVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MappingVO> mappingVO;
	

	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	
}
