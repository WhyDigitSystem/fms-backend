package com.base.basesetup.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CountryDTO;
import com.base.basesetup.entity.CountryVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.CountryRepo;

@Service
public class BasicMasterServiceImpl implements BasicMasterService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(BasicMasterServiceImpl.class);

	@Autowired
	CountryRepo countryRepo;

	//Country------------------------------------------------------------------------------------
	
	@Override
	public List<CountryVO> getCountryById(Long id) {
		List<CountryVO> countryVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  Country BY Id : {}", id);
			countryVO = countryRepo.findCountryById(id);
		} else {
			LOGGER.info("Successfully Received  Country For All Id.");
			countryVO = countryRepo.findAll();
		}
		return countryVO;
	}

	@Override
	public List<CountryVO> getCountryByOrgId(Long Orgid) {
		List<CountryVO> countryVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(Orgid)) {
			LOGGER.info("Successfully Received  Country BY Id : {}", Orgid);
			countryVO = countryRepo.findCountryByOrgId(Orgid);
		} else {
			LOGGER.info("Successfully Received  Country For All OrgId.");
			countryVO = countryRepo.findAll();
		}
		return countryVO;
	}

	@Override
	public CountryVO updateCreateCountry(@Valid CountryDTO countryDTO) throws ApplicationException {
		CountryVO countryVO = new CountryVO();
		if (ObjectUtils.isNotEmpty(countryDTO.getId())) {
			countryVO = countryRepo.findById(countryDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid Country Details"));
		}
		getCountryVOFromCountryDTO(countryDTO, countryVO);
		return countryRepo.save(countryVO);
	}

	private void getCountryVOFromCountryDTO(@Valid CountryDTO countryDTO, CountryVO countryVO) {
		countryVO.setCountry(countryDTO.getCountry());
		countryVO.setCountryCode(countryDTO.getCountryCode());
		countryVO.setOrgId(countryDTO.getOrgId());
		countryVO.setUserId(countryDTO.getUserId());
		
	}
//----------------------------------------------------------------------------------------------------

	

}
