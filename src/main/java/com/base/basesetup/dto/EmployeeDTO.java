package com.base.basesetup.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private Long employeeId;
	
	private Long OrgId;

	private String employeeCode;

	private String employeeName;

	private String gender;

	private String branch;

	private LocalDate joiningDate;

	private String department;

	private String designation;

	private String appoinmentType;

	private String modeOfEntry;

	private String dateOfBirth;

	private LocalDate leavingDate;
	
	private boolean status;

}
