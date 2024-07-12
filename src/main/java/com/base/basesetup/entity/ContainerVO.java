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
@Table(name = "container")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContainerVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "containergen")
	@SequenceGenerator(name = "containergen", sequenceName = "containerseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "containerid")
	private Long id;
	@Column(name = "type")
	private String containerType;
	@Column(name = "category")
	private String category;
	@Column(name = "length")
	private float length;
	@Column(name = "width")
	private float width;
	@Column(name = "height")
	private float height;
	@Column(name = "weight")
	private float weight;
	@Column(name = "volume")
	private float volume;
	
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
	
	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

}
