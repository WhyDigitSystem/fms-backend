package com.base.basesetup.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CountryDTO;
import com.base.basesetup.entity.CountryVO;
import com.base.basesetup.exception.ApplicationException;

@Service
public interface BasicMasterService {

	//Country-------------------------------------------------------------------------------------
	List<CountryVO> getCountryById(Long id);

	List<CountryVO> getCountryByOrgId(Long id);

	CountryVO updateCreateCountry(@Valid CountryDTO countryDTO) throws ApplicationException;
   //----------------------------------------------------------------------------------------
	

	

}
