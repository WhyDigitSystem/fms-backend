package com.base.basesetup.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CompanySetupDTO;
import com.base.basesetup.entity.CompanySetupVO;
import com.base.basesetup.exception.ApplicationException;

@Service
public interface CompanySetupService {

	CompanySetupVO updateCreateCompanySetup(@Valid CompanySetupDTO companySetupDTO) throws ApplicationException;


}
