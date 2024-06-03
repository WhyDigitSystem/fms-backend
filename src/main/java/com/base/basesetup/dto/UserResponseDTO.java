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
	private long userId;
	private long orgId;
	private String employeeName;
	private String email;
	private String userName;
	private boolean loginStatus;
	private boolean isActive;
	@Enumerated(EnumType.STRING)
	private Role role;
	private Date accountRemovedDate;
	private String token;
	private String tokenId;
	private String lastLogin;
}


