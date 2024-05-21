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
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventsVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eventsgen")
	@SequenceGenerator(name = "eventsgen", sequenceName = "eventsseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "eventsid")
	private Long id;
	@Column(name = "eventid")
	private String eventid;
	@Column(name = "description")
	private String eventDescription;
	@Column(name = "type")
	private String eventType;
	
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
}
