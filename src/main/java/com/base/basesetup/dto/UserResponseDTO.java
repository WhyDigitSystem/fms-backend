package com.base.basesetup.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
	private LocalDate deactivatedOn;
	private Long orgId;
	
	private boolean loginStatus;
	@Enumerated(EnumType.STRING)
	private Date accountRemovedDate;
	private String token;
	private String tokenId;
	private String lastLogin;
	
	private List<UserRolesDTO> rolesDTO;
	private List<ProductsAccessibleDTO> productsAccessibleDTO;
	private List<BranchesAccessibleDTO> branchesAccessibleDTO;
}


