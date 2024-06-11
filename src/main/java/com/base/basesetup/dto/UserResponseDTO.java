package com.base.basesetup.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

	private Long userId;
	private String userName;
	private String password;
	private String userType;
	private boolean allIndiaAccess;
	private String employeeCode;
	private String employeeName;
	private String email;
    private String reportingTO;
	private String location;
	private boolean isActive;
	private String deactivatedOn;
	private Long orgId;
	
	private boolean loginStatus;
	@Enumerated(EnumType.STRING)
	private Date accountRemovedDate;
	private String token;
	private String tokenId;
	private String lastLogin;
	
	
}


