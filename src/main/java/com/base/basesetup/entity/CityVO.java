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
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "citygen")
	@SequenceGenerator(name = "citygen",sequenceName = "cityseq",initialValue = 1000000001,allocationSize = 1)
	@Column(name="cityid")
	private Long id;
	
	@Column(name="code")
	private String cityCode;
	@Column(name="country")
	private String country;
	@Column(name="city")
    private String cityName;
	@Column(name="state")
    private String state;
	@Column(name="active")
    private boolean active;
	@Column(unique = true)
	private String dupchk;
	@Column(name="createdby")
	private String createdBy;
	@Column(name="modifiedby")
	private String updatedBy;
	@Column(name="orgid")
	private Long orgId;
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


