package com.base.basesetup.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CityDTO;
import com.base.basesetup.dto.CountryDTO;
import com.base.basesetup.dto.StateDTO;
import com.base.basesetup.entity.CityVO;
import com.base.basesetup.entity.CountryVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.CityRepo;
import com.base.basesetup.repo.CountryRepo;
import com.base.basesetup.repo.StateRepo;

@Service
public class BasicMasterServiceImpl implements BasicMasterService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(BasicMasterServiceImpl.class);

	@Autowired
	CountryRepo countryRepo;
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	StateRepo stateRepo;

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
	
//City----------------------------------------------------------------------------------------------
	
	@Override
	public List<CityVO> getCityById(Long id) {
		List<CityVO> cityVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received City BY Id : {}", id);
			cityVO = cityRepo.findCityById(id);
		} else {
			LOGGER.info("Successfully Received City For All Id.");
			cityVO = cityRepo.findAll();
		}
		return cityVO;
	}

	@Override
	public List<CityVO> getCityByOrgId(Long orgId) {
		List<CityVO> cityVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgId)) {
			LOGGER.info("Successfully Received City BY OrgId : {}", orgId);
			cityVO = cityRepo.findCityByOrgId(orgId);
		} else {
			LOGGER.info("Successfully Received City For All OrgId.");
			cityVO = cityRepo.findAll();
		}
		return cityVO;
	}

	@Override
	public CityVO updateCreateCity(@Valid CityDTO cityDTO) throws ApplicationException {
		CityVO cityVO = new CityVO();
		if (ObjectUtils.isNotEmpty(cityDTO.getId())) {
			cityVO = cityRepo.findById(cityDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid City Details"));
		}
		getCityVOFromCityDTO(cityDTO, cityVO);
		return cityRepo.save(cityVO);
	}

	private void getCityVOFromCityDTO(@Valid CityDTO cityDTO, CityVO cityVO) {
		cityVO.setOrgId(cityDTO.getOrgId());
		cityVO.setCityCode(cityDTO.getCityCode());
		cityVO.setCityName(cityDTO.getCityName());
		cityVO.setCountry(cityDTO.getCountry());
		cityVO.setUserId(cityDTO.getUserId());
		cityVO.setState(cityDTO.getState());

	}
	//State -----------------------------------------------------------------------------------
		@Override
		public List<StateVO> getStateById(Long id) {
			List<StateVO> stateVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received State BY Id : {}", id);
				stateVO = stateRepo.findStateById(id);
			} else {
				LOGGER.info("Successfully Received State For All Id.");
				stateVO = stateRepo.findAll();
			}
			return stateVO;
		}

		@Override
		public List<StateVO> getStateByOrgId(Long orgId) {
			List<StateVO> stateVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(orgId)) {
				LOGGER.info("Successfully Received State BY OrgId : {}", orgId);
				stateVO = stateRepo.findStateByOrgId(orgId);
			} else {
				LOGGER.info("Successfully Received State For All OrgId.");
				stateVO = stateRepo.findAll();
			}
			return stateVO;
		}

		@Override
		public StateVO updateCreateState(@Valid StateDTO stateDTO) throws ApplicationException {
			StateVO stateVO = new StateVO();
			if (ObjectUtils.isNotEmpty(stateDTO.getId())) {
				stateVO = stateRepo.findById(stateDTO.getId())
						.orElseThrow(() -> new ApplicationException("Invalid State Details"));
			}
			getStateVOFromStateDTO(stateDTO, stateVO);
			return stateRepo.save(stateVO);
		}

		private void getStateVOFromStateDTO(@Valid StateDTO stateDTO, StateVO stateVO) {
			stateVO.setOrgId(stateDTO.getOrgId());
			stateVO.setStateCode(stateDTO.getStateCode());
			stateVO.setStateName(stateDTO.getStateName());
			stateVO.setUserId(stateDTO.getUserId());

		}


}
