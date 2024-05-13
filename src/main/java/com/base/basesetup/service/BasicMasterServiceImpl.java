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
import com.base.basesetup.dto.DepartmentDTO;
import com.base.basesetup.dto.DesignationDTO;
import com.base.basesetup.dto.EmployeeDTO;
import com.base.basesetup.dto.PortDTO;
import com.base.basesetup.dto.StateDTO;
import com.base.basesetup.entity.CityVO;
import com.base.basesetup.entity.CountryVO;
import com.base.basesetup.entity.DepartmentVO;
import com.base.basesetup.entity.DesignationVO;
import com.base.basesetup.entity.EmployeeVO;
import com.base.basesetup.entity.PortVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.CityRepo;
import com.base.basesetup.repo.CountryRepo;
import com.base.basesetup.repo.DepartmentRepo;
import com.base.basesetup.repo.DesignationRepo;
import com.base.basesetup.repo.EmployeeRepo;
import com.base.basesetup.repo.PortRepo;
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

	@Autowired
	DepartmentRepo departmentRepo;

	@Autowired
	DesignationRepo designationRepo;

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	PortRepo portRepo;

	// Country------------------------------------------------------------------------------------

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

	// State
	// -----------------------------------------------------------------------------------
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

	// Department_________________________________________________________________________________

	@Override
	public DepartmentVO updateCreateDepartment(@Valid DepartmentDTO departmentDTO) throws ApplicationException {
		DepartmentVO departmentVO = new DepartmentVO();
		if (ObjectUtils.isNotEmpty(departmentDTO.getDepartmentId())) {
			departmentVO = departmentRepo.findById(departmentDTO.getDepartmentId())
					.orElseThrow(() -> new ApplicationException("Invalid Department Details"));

		}

		getDepartmentVOFromDepartmentDTO(departmentDTO, departmentVO);
		return departmentRepo.save(departmentVO);

	}

	private void getDepartmentVOFromDepartmentDTO(@Valid DepartmentDTO departmentDTO, DepartmentVO departmentVO) {
		departmentVO.setDepartment(departmentDTO.getDepartment());
		departmentVO.setDepartmentCode(departmentDTO.getDepartmentCode());
		departmentVO.setOrgId(departmentDTO.getOrgId());
	}

	@Override
	public DesignationVO updateCreateDesignation(@Valid DesignationDTO designationDTO) throws ApplicationException {
		DesignationVO designationVO = new DesignationVO();
		if (ObjectUtils.isNotEmpty(designationDTO.getDesignationId())) {
			designationVO = designationRepo.findById(designationDTO.getDesignationId())
					.orElseThrow(() -> new ApplicationException("Invalid Designation Details"));

		}
		getDesignationVOFromDesignationDTO(designationDTO, designationVO);
		return designationRepo.save(designationVO);

	}

	private void getDesignationVOFromDesignationDTO(@Valid DesignationDTO designationDTO, DesignationVO designationVO) {
		designationVO.setDesignation(designationDTO.getDesignation());
		designationVO.setOrgId(designationDTO.getOrgId());
	}

	@Override
	public EmployeeVO updateCreateEmployee(@Valid EmployeeDTO employeeDTO) throws ApplicationException {
		EmployeeVO employeeVO = new EmployeeVO();
		if (ObjectUtils.isNotEmpty(employeeDTO.getEmployeeId())) {
			employeeVO = employeeRepo.findById(employeeDTO.getEmployeeId())
					.orElseThrow(() -> new ApplicationException("Invalid Employee Details"));
		}

		getEmployeeVOFromEmployeeDTO(employeeDTO, employeeVO);
		return employeeRepo.save(employeeVO);
	}

	private void getEmployeeVOFromEmployeeDTO(@Valid EmployeeDTO employeeDTO, EmployeeVO employeeVO) {

		employeeVO.setEmployeeCode(employeeDTO.getEmployeeCode());
		employeeVO.setEmployeeName(employeeDTO.getEmployeeName());
		employeeVO.setGender(employeeDTO.getGender());
		employeeVO.setBranch(employeeDTO.getBranch());
		employeeVO.setJoiningDate(employeeDTO.getJoiningDate());
		employeeVO.setDepartment(employeeDTO.getDepartment());
		employeeVO.setDesignation(employeeDTO.getDesignation());
		employeeVO.setAppoinmentType(employeeDTO.getAppoinmentType());
		employeeVO.setModeOfEntry(employeeDTO.getModeOfEntry());
		employeeVO.setDateOfBirth(employeeDTO.getDateOfBirth());
		employeeVO.setLeavingDate(employeeDTO.getLeavingDate());
		employeeVO.setStatus(employeeDTO.isStatus());
		employeeVO.setOrgId(employeeDTO.getOrgId());
	}

	@Override
	public PortVO updateCreatePort(@Valid PortDTO portDTO) throws ApplicationException {
		PortVO portVO = new PortVO();
		if (ObjectUtils.isNotEmpty(portDTO.getPortId())) {
			portVO = portRepo.findById(portDTO.getPortId())
					.orElseThrow(() -> new ApplicationException("Invalid Port Details"));
		}
		getPortVOFromPortDTO(portDTO, portVO);
		return portRepo.save(portVO);

	}

	private void getPortVOFromPortDTO(@Valid PortDTO portDTO, PortVO portVO) {
		portVO.setCode(portDTO.getCode());
		portVO.setCountry(portDTO.getCountry());
		portVO.setType(portDTO.getType());
		portVO.setOrgId(portDTO.getOrgId());
		portVO.setPort(portDTO.getPort());
		portVO.setActive(portDTO.isActive());
	}
}
