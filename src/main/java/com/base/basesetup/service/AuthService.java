package com.base.basesetup.service;


import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CreateUserFormDTO;
import com.base.basesetup.exception.ApplicationException;

@Service
public interface AuthService {

	public void createUser(CreateUserFormDTO createUserFormDTO) throws ApplicationException;

	

}
