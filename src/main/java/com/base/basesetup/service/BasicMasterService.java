package com.base.basesetup.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CityDTO;
import com.base.basesetup.dto.CompanyDTO;
import com.base.basesetup.dto.CountryDTO;
import com.base.basesetup.dto.StateDTO;
import com.base.basesetup.entity.CityVO;
import com.base.basesetup.entity.CompanyVO;
import com.base.basesetup.entity.CountryVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.exception.ApplicationException;

@Service
public interface BasicMasterService {

	//Country-------------------------------------------------------------------------------------
	List<CountryVO> getCountryById(Long id);

	List<CountryVO> getCountryByOrgId(Long id);

	CountryVO updateCreateCountry(@Valid CountryDTO countryDTO) throws ApplicationException;
   //City-----------------------------------------------------------------------------------------

	List<CityVO> getCityById(Long id);

	List<CityVO> getCityByOrgId(Long orgId);

	CityVO updateCreateCity(@Valid CityDTO cityDTO) throws ApplicationException;
	
	List<CityVO> getAllCityByState(Long orgId, String state);

  //State-----------------------------------------------------------------------------------------
	List<StateVO> getStateById(Long id);

	List<StateVO> getStateByOrgId(Long orgId);

	StateVO updateCreateState(@Valid StateDTO stateDTO) throws ApplicationException;
	
	List<StateVO> getAllStateByCountry(Long orgId, String country);

	
//	Company--------------------------------------------------------------------------------------

	List<CompanyVO> getCompanyById(Long id);

	List<CompanyVO> getCompanyByOrgId(Long orgId);

	CompanyVO updateCreateCompany(@Valid CompanyDTO companyDTO) throws ApplicationException;

	

	

	

}
