package com.base.basesetup.service;

import java.util.Arrays;
import java.util.stream.Collectors;

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
import com.base.basesetup.dto.CreateUserFormDTO;
import com.base.basesetup.dto.UserAddressDTO;
import com.base.basesetup.entity.CustomersVO;
import com.base.basesetup.entity.UserAddressVO;
import com.base.basesetup.entity.UserVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.CustomersRepo;
import com.base.basesetup.repo.OrganizationRepo;
import com.base.basesetup.repo.UserAddressRepo;
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
	
	@Autowired
	UserAddressRepo userAddressRepo;

	@Autowired
	CustomersRepo customersRepo;
	
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
		userVO.setOrganizationVO(organizationRepo.findById(createUserFormDTO.getOrgId())
				.orElseThrow(() -> new ApplicationException("No orginaization found.")));
		userVO.setUserAddressVO(userAddressRepo.save(getAddressVOFromCreateUserFormDTO(createUserFormDTO)));
		if (ObjectUtils.isNotEmpty(createUserFormDTO.getEmitterId())) {
			CustomersVO customersVO = customersRepo.findById(createUserFormDTO.getEmitterId()).orElse(null);
			userVO.setCustomersVO(customersVO);
		}
		userRepo.save(userVO);
		userService.createUserAction(userVO.getEmail(), userVO.getUserId(), UserConstants.USER_ACTION_ADD_ACCOUNT);
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
	}

	private UserAddressVO getAddressVOFromCreateUserFormDTO(CreateUserFormDTO createUserFormDTO) {
		UserAddressVO userAddressVO = new UserAddressVO();
		UserAddressDTO userAddressDTO = createUserFormDTO.getUserAddressDTO();
		userAddressVO.setAddress1(userAddressDTO.getAddress1());
		userAddressVO.setAddress2(userAddressDTO.getAddress2());
		userAddressVO.setCountry(userAddressDTO.getCountry());
		userAddressVO.setLocation(userAddressDTO.getLocation());
		userAddressVO.setPin(userAddressDTO.getPin());
		userAddressVO.setCity(userAddressDTO.getCity());
		userAddressVO.setState(userAddressDTO.getState());
		return userAddressVO;
	}


	private UserVO getUserVOFromCreateUserFormDTO(CreateUserFormDTO createUserFormDTO) {
		UserVO userVO = new UserVO();
		userVO.setFirstName(createUserFormDTO.getFirstName());
		userVO.setLastName(createUserFormDTO.getLastName());
		userVO.setUserName(createUserFormDTO.getUserName());
		userVO.setEmail(createUserFormDTO.getEmail());
		userVO.setAccessRightsRoleId(createUserFormDTO.getAccessRightsRoleId());
		userVO.setPNo(createUserFormDTO.getPNo());
		try {
			userVO.setPassword(encoder.encode(CryptoUtils.getDecrypt(createUserFormDTO.getPassword())));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new ApplicationContextException(UserConstants.ERRROR_MSG_UNABLE_TO_ENCODE_USER_PASSWORD);
		}
		String addIds = ObjectUtils.isNotEmpty(createUserFormDTO.getAccessaddId()) ? Arrays
				.stream(createUserFormDTO.getAccessaddId()).map(String::valueOf).collect(Collectors.joining(","))
				: StringUtils.EMPTY;
		String warehouseIds = ObjectUtils.isNotEmpty(createUserFormDTO.getAccessWarehouse()) ? Arrays
				.stream(createUserFormDTO.getAccessWarehouse()).map(String::valueOf).collect(Collectors.joining(","))
				: StringUtils.EMPTY;
		String flowIds = ObjectUtils.isNotEmpty(createUserFormDTO.getAccessFlowId()) ? Arrays
				.stream(createUserFormDTO.getAccessFlowId()).map(String::valueOf).collect(Collectors.joining(","))
				: StringUtils.EMPTY;
		userVO.setAccessFlowId(flowIds);
		userVO.setAccessaddId(addIds);
		userVO.setAccessWarehouse(warehouseIds);
		userVO.setRole(createUserFormDTO.getRole());
		userVO.setActive(true);
		return userVO;
	}
 
}
