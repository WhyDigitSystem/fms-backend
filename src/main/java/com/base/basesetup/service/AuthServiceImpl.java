package com.base.basesetup.service;

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
		userVO.setOrganizationVO(organizationRepo.findById(createUserFormDTO.getOrgId())
				.orElseThrow(() -> new ApplicationException("No orginaization found.")));
		userRepo.save(userVO);
		userService.createUserAction(userVO.getEmail(), userVO.getUserId(), UserConstants.USER_ACTION_ADD_ACCOUNT);
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
	}

	private UserVO getUserVOFromCreateUserFormDTO(CreateUserFormDTO createUserFormDTO) {
		UserVO userVO = new UserVO();
		userVO.setFirstName(createUserFormDTO.getFirstName());
		userVO.setLastName(createUserFormDTO.getLastName());
		userVO.setUserName(createUserFormDTO.getUserName());
		userVO.setEmail(createUserFormDTO.getEmail());
		try {
			userVO.setPassword(encoder.encode(CryptoUtils.getDecrypt(createUserFormDTO.getPassword())));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new ApplicationContextException(UserConstants.ERRROR_MSG_UNABLE_TO_ENCODE_USER_PASSWORD);
		}
		userVO.setRole(createUserFormDTO.getRole());
		userVO.setActive(true);
		return userVO;
	}
 
}
