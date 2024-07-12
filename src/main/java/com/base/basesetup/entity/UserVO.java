package com.base.basesetup.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.fasterxml.jackson.annotation.JsonGetter;
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
	private boolean active;
	private LocalDate deactivatedOn;
	private Long orgId;

	private boolean loginStatus;
	private Date accountRemovedDate;
	private String lastLogin;
	@Enumerated(EnumType.STRING)
	
	
	@OneToMany(mappedBy = "userVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<UserRolesVO> userRolesVO;
	
	@OneToMany(mappedBy = "userVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ProductsAccessibleVO> productsAccessibleVO;
	
	@OneToMany(mappedBy = "userVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<BranchesAccessibleVO> branchesAccessibleVO;
	

	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
	
}
