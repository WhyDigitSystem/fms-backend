package com.base.basesetup.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userroles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRolesVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolesgen")
	@SequenceGenerator(name = "rolesgen", sequenceName = "rolesseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "userrolesid")
	private Long id;
	@Column(name = "role")
	private String role;
	@Column(name = "startdate")
	private LocalDate startdate;
	@Column(name = "enddate")
	private LocalDate enddate;
	
	@OneToMany(mappedBy = "userRolesVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ResponsibilitiesVO> responsibilityVO;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonBackReference
	private UserVO userVO;
	
	
	
}
