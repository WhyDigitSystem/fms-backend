package com.base.basesetup.entity;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.base.basesetup.dto.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private boolean loginStatus;
	private boolean isActive;
	private String lastLogin;
	@Enumerated(EnumType.STRING)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "orgId")
	private OrganizationVO organizationVO;
	
	
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();
	private Date accountRemovedDate;

	
	
}
