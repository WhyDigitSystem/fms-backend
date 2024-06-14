package com.base.basesetup.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.base.basesetup.common.CommonConstant;
import com.base.basesetup.common.UserConstants;
import com.base.basesetup.dto.BranchesAccessibleDTO;
import com.base.basesetup.dto.CreateUserFormDTO;
import com.base.basesetup.dto.ProductsAccessibleDTO;
import com.base.basesetup.dto.UserRolesDTO;
import com.base.basesetup.entity.BranchesAccessibleVO;
import com.base.basesetup.entity.ProductsAccessibleVO;
import com.base.basesetup.entity.UserRolesVO;
import com.base.basesetup.entity.UserVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.OrganizationRepo;
import com.base.basesetup.repo.UserRepo;
import com.base.basesetup.util.CryptoUtils;


@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrganizationRepo organizationRepo;
	
	
	
	public static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Override
	public void createUser(CreateUserFormDTO createUserFormDTO) throws ApplicationException {
		String methodName = "createUser()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		if (ObjectUtils.isEmpty(createUserFormDTO) || StringUtils.isBlank(createUserFormDTO.getEmail())) {
			throw new ApplicationContextException(UserConstants.ERRROR_MSG_INVALID_USER_REGISTER_INFORMATION);
		} else if (userRepo.existsByEmail(createUserFormDTO.getEmail())) {
			throw new ApplicationContextException(UserConstants.ERRROR_MSG_USER_INFORMATION_ALREADY_REGISTERED);
		}
		UserVO userVO = getUserVOFromCreateUserFormDTO(createUserFormDTO);  
		userRepo.save(userVO);
		userService.createUserAction(userVO.getEmail(), userVO.getUserId(), UserConstants.USER_ACTION_ADD_ACCOUNT);
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
	}

	private UserVO getUserVOFromCreateUserFormDTO(CreateUserFormDTO createUserFormDTO) {
		UserVO userVO = new UserVO();
		userVO.setUserName(createUserFormDTO.getUserName());
		userVO.setEmail(createUserFormDTO.getEmail());
		userVO.setUserType(createUserFormDTO.getUserType());
		userVO.setAllIndiaAccess(createUserFormDTO.isAllIndiaAccess());
		userVO.setEmployeeCode(createUserFormDTO.getEmployeeCode());
		userVO.setEmployeeName(createUserFormDTO.getEmployeeName());
		userVO.setReportingTO(createUserFormDTO.getReportingTO());
		userVO.setLocation(createUserFormDTO.getLocation());
		userVO.setDeactivatedOn(createUserFormDTO.getDeactivatedOn());
		userVO.setOrgId(createUserFormDTO.getOrgId());

		try {
			userVO.setPassword(encoder.encode(CryptoUtils.getDecrypt(createUserFormDTO.getPassword())));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new ApplicationContextException(UserConstants.ERRROR_MSG_UNABLE_TO_ENCODE_USER_PASSWORD);
		}
		userVO.setActive(true);
		
		
		List<UserRolesVO> userRolesVO = new ArrayList<>();
		if (createUserFormDTO.getUserRolesDTO()!= null) {

			for (UserRolesDTO userRolesDTO : createUserFormDTO.getUserRolesDTO()) {

				UserRolesVO userRoles = new UserRolesVO();
				userRoles.setRole(userRolesDTO.getRole());
				userRoles.setStartdate(userRolesDTO.getStartdate());
				userRoles.setEnddate(userRolesDTO.getEnddate());
				userRoles.setUserVO(userVO);
				userRolesVO.add(userRoles);
				
			}
		}
		userVO.setUserRolesVO(userRolesVO);
		
		
		List<ProductsAccessibleVO> productsAccessibleVO = new ArrayList<>();
		if (createUserFormDTO.getProductsAccessibleDTO()!= null) {

			for (ProductsAccessibleDTO productsAccessibleDTO : createUserFormDTO.getProductsAccessibleDTO()) {

				ProductsAccessibleVO productsAccessible = new ProductsAccessibleVO();
				productsAccessible.setProductCode(productsAccessibleDTO.getProductCode());
				productsAccessible.setProductName(productsAccessibleDTO.getProductName());
				productsAccessible.setUserVO(userVO);
				productsAccessibleVO.add(productsAccessible);
			}
		}
		userVO.setProductsAccessibleVO(productsAccessibleVO);
		
		List<BranchesAccessibleVO> branchesAccessibleVO = new ArrayList<>();
		if (createUserFormDTO.getBranchesAccessibleDTO()!= null) {

			for (BranchesAccessibleDTO branchesAccessibleDTO : createUserFormDTO.getBranchesAccessibleDTO()) {

				BranchesAccessibleVO branchesAccessible = new BranchesAccessibleVO();
				branchesAccessible.setBranch(branchesAccessibleDTO.getBranch());
				branchesAccessible.setUserVO(userVO);
				branchesAccessibleVO.add(branchesAccessible);
			}
		}
		userVO.setBranchesAccessibleVO(branchesAccessibleVO);
		
		
		return userVO;
	}
 
}
