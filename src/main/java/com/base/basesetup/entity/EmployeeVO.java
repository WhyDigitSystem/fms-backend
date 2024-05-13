package com.base.basesetup.entity;

import java.time.LocalDate;

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
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeegen")
	@SequenceGenerator(name = "employeegen", sequenceName = "employeeseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "employeeid")
	private Long employeeId;

	@Column(name = "employeecode", length = 30)
	private String employeeCode;
	@Column(name = "employeename", length = 30)
	private String employeeName;
	@Column(name = "gender", length = 20)
	private String gender;
	@Column(name = "branch", length = 30)
	private String branch;
	@Column(name = "joiningdate")
	private LocalDate joiningDate;
	@Column(name = "department", length = 30)
	private String department;
	@Column(name = "designation", length = 30)
	private String designation;
	@Column(name = "appoinmenttype", length = 30)
	private String appoinmentType;
	@Column(name = "modeofentry", length = 30)
	private String modeOfEntry;
	@Column(name = "dateofbirth", length = 30)
	private String dateOfBirth;
	@Column(name = "leavingdate", length = 30)
	private LocalDate leavingDate;

	private boolean status;
	@Column(name = "createdby", length = 30)
	private String createdBy;
	@Column(name = "modifiedby", length = 30)
	private String updatedBy;
	@Column(name = "orgid")
	private Long orgId;
	@Column(name = "cancel")
	private boolean cancel;
	@Column(name = "cancelremarks", length = 50)
	private boolean cancelRemarks;
	private boolean active;

	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
}
