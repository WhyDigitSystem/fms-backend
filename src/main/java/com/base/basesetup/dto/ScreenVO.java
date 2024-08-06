package com.base.basesetup.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "screen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreenVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "screengen")
	@SequenceGenerator(name = "screengen",sequenceName = "screenseq",initialValue = 1000000001,allocationSize = 1)
	@Column(name="screenid")
	private Long id;
	@Column(name="screenname")
	private String screenName;
	@Column(name="screencode")
	private String screenCode;
	
	@Column(name="active")
    private boolean active;
	@Column(name="createdby")
	private String createdBy;
	@Column(name="modifiedby")
	private String updatedBy;
//	@Column(name="orgid")
//	private Long orgId;
	@Column(name="cancel")
	private boolean cancel;
	@Column(name = "cancelremarks")
	private String cancelRemarks;
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}

