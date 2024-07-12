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
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documenttype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documenttypegen")
	@SequenceGenerator(name = "documenttypegen", sequenceName = "documenttypeseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "documenttypeid")
	private Long id;
	@Column(name = "document")
	private String documentName;
	@Column(name = "type")
	private String documentType;
	@Column(name = "description")
	private String documentDescription;
	@Column(name = "module")
	private String module;
	@Column(name = "submodule")
	private String subModule;
	@Column(name = "primarytable")
	private String primaryTable;
	@Column(name = "autogenfield")
	private String autoGenField;
	@Column(name = "prefixfield")
	private String prefixField;
	@Column(name = "documentcode")
	private String documentCode;
	@Column(name = "code")
	private String code;
	@Column(name = "finyr")
	private String finyr;
	@Column(name = "branch")
	private String branch;
	@Column(name="financetransaction")
    private boolean financeTransaction;
	@Column(name="postfinance")
    private boolean postFinance;
	@Column(name="nogeneration")
    private boolean noGeneration;
	@Column(name = "prefix")
	private String prefix;
	
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
	
	@OneToMany(mappedBy = "documentTypeVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<SubTypesVO> subTypesVO;
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
}
