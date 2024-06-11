package com.base.basesetup.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RolesVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolesgen")
	@SequenceGenerator(name = "rolesgen", sequenceName = "rolesseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "rolesid")
	private Long id;
	@Column(name = "role")
	private String role;
	@Column(name = "startdate")
	private LocalDate startdate;
	@Column(name = "enddate")
	private LocalDate enddate;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonBackReference
	private UserVO userVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
