package com.base.basesetup.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.base.basesetup.dto.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private Date accountRemovedDate;
	private String lastLogin;
	@Enumerated(EnumType.STRING)
	
	@OneToMany
	@JoinColumn(name = "orgId")
	private OrganizationVO organizationVO;
	
	@OneToMany(mappedBy = "userVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RolesVO> RolesVO;
	
	@OneToMany(mappedBy = "userVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ProductsAccessibleVO> productsAccessibleVO;
	
	@OneToMany(mappedBy = "userVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<BranchesAccessibleVO> branchesAccessibleVO;
	
	
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	
	
}
