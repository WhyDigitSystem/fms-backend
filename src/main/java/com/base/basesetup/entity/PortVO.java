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
@Table(name = "port")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portgen")
	@SequenceGenerator(name = "portgen", sequenceName = "portseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "portid")
	private Long id;

	@Column(name = "port")
	private String port;
	@Column(name = "country")
	private String country;
	@Column(name = "type")
	private String type;
	@Column(name = "code")
	private String code;

	private boolean status;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "modifiedby")
	private String updatedBy;
	@Column(name = "orgid")
	private Long orgId;
	@Column(name = "cancel")
	private boolean cancel;
	@Column(name = "cancelremarks")
	private boolean cancelRemarks;
	private boolean active;

	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
