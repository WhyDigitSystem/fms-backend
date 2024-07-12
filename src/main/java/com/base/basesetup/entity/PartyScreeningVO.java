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
import com.fasterxml.jackson.annotation.JsonGetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partyscreening")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyScreeningVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partyscreeninggen")
	@SequenceGenerator(name = "partyscreeninggen", sequenceName = "partyscreeningseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "partyscreeningid")
	private Long id;
	@Column(name = "partytype")
	private String partyType;
	@Column(name = "entityname")
	private String entityName;
	@Column(name = "alternativeentitynames")
	private String alternativeEntityNames;
	@Column(name = "uniqueid")
	private long uniqueId;
	@Column(name = "includealias")
	private String includeAlias;
	@Column(name = "screeningstatus")
	private String screeningStatus;
	
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
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
}
