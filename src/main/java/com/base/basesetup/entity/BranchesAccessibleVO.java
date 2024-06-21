package com.base.basesetup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "branchesaccessible")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BranchesAccessibleVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branchesaccessiblegen")
	@SequenceGenerator(name = "branchesaccessiblegen", sequenceName = "branchesaccessibleseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "branchesaccessibleid")
	private Long id;
	@Column(name = "branch")
	private String branch;
	
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonBackReference
	private UserVO userVO;
	

	
	
}
