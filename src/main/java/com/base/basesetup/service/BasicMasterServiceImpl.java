package com.base.basesetup.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.basesetup.dto.BusinessAddressDTO;
import com.base.basesetup.dto.CityDTO;
import com.base.basesetup.dto.CompanyDTO;
import com.base.basesetup.dto.ContainerDTO;
import com.base.basesetup.dto.CountryDTO;
import com.base.basesetup.dto.DepartmentDTO;
import com.base.basesetup.dto.DesignationDTO;
import com.base.basesetup.dto.DocumentTypeDTO;
import com.base.basesetup.dto.DocumentTypeMappingDTO;
import com.base.basesetup.dto.EmployeeDTO;
import com.base.basesetup.dto.EventsDTO;
import com.base.basesetup.dto.GstInDTO;
import com.base.basesetup.dto.ListOfValues1DTO;
import com.base.basesetup.dto.ListOfValuesDTO;
import com.base.basesetup.dto.MappingDTO;
import com.base.basesetup.dto.PartyScreeningDTO;
import com.base.basesetup.dto.PortDTO;
import com.base.basesetup.dto.RegionDTO;
import com.base.basesetup.dto.SegmentsDTO;
import com.base.basesetup.dto.StateDTO;
import com.base.basesetup.dto.StateGstDTO;
import com.base.basesetup.dto.SubTypesDTO;
import com.base.basesetup.dto.TermsAndConditionDTO;
import com.base.basesetup.entity.BusinessAddressVO;
import com.base.basesetup.entity.CityVO;
import com.base.basesetup.entity.CompanyVO;
import com.base.basesetup.entity.ContainerVO;
import com.base.basesetup.entity.CountryVO;
import com.base.basesetup.entity.DepartmentVO;
import com.base.basesetup.entity.DesignationVO;
import com.base.basesetup.entity.DocumentTypeMappingVO;
import com.base.basesetup.entity.DocumentTypeVO;
import com.base.basesetup.entity.EmployeeVO;
import com.base.basesetup.entity.EventsVO;
import com.base.basesetup.entity.GstInVO;
import com.base.basesetup.entity.ListOfValues1VO;
import com.base.basesetup.entity.ListOfValuesVO;
import com.base.basesetup.entity.MappingVO;
import com.base.basesetup.entity.PartyScreeningVO;
import com.base.basesetup.entity.PortVO;
import com.base.basesetup.entity.RegionVO;
import com.base.basesetup.entity.SegmentsVO;
import com.base.basesetup.entity.StateGstVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.entity.SubTypesVO;
import com.base.basesetup.entity.TermsAndConditionVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.BusinessAddressRepo;
import com.base.basesetup.repo.CityRepo;
import com.base.basesetup.repo.CompanyRepo;
import com.base.basesetup.repo.ContainerRepo;
import com.base.basesetup.repo.CountryRepo;
import com.base.basesetup.repo.DepartmentRepo;
import com.base.basesetup.repo.DesignationRepo;
import com.base.basesetup.repo.DocumentTypeMappingRepo;
import com.base.basesetup.repo.DocumentTypeRepo;
import com.base.basesetup.repo.EmployeeRepo;
import com.base.basesetup.repo.EventsRepo;
import com.base.basesetup.repo.GstInRepo;
import com.base.basesetup.repo.ListOfValues1Repo;
import com.base.basesetup.repo.ListOfValuesRepo;
import com.base.basesetup.repo.MappingRepo;
import com.base.basesetup.repo.PartyScreeningRepo;
import com.base.basesetup.repo.PortRepo;
import com.base.basesetup.repo.RegionRepo;
import com.base.basesetup.repo.SegmentsRepo;
import com.base.basesetup.repo.StateGstRepo;
import com.base.basesetup.repo.StateRepo;
import com.base.basesetup.repo.SubTypesRepo;
import com.base.basesetup.repo.TermsAndConditionRepo;

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
	CompanyRepo companyRepo;

	@Autowired
	DepartmentRepo departmentRepo;

	@Autowired
	DesignationRepo designationRepo;

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	PortRepo portRepo;

	@Autowired
	ContainerRepo containerRepo;

	@Autowired
	EventsRepo eventsRepo;

	@Autowired
	SegmentsRepo segmentsRepo;

	@Autowired
	RegionRepo regionRepo;

	@Autowired
	DocumentTypeRepo documentTypeRepo;

	@Autowired
	DocumentTypeMappingRepo documentTypeMappingRepo;

	@Autowired
	SubTypesRepo subTypesRepo;

	@Autowired
	MappingRepo mappingRepo;

	@Autowired
	ListOfValuesRepo listOfValuesRepo;

	@Autowired
	ListOfValues1Repo listOfValues1Repo;

	@Autowired
	TermsAndConditionRepo termsAndConditionRepo;

	@Autowired
	GstInRepo gstInRepo;

	@Autowired
	StateGstRepo stateGstRepo;

	@Autowired
	BusinessAddressRepo businessAddressRepo;

	@Autowired
	PartyScreeningRepo partyScreeningRepo;

	// COUNTRY

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
	public List<CountryVO> getCountryByOrgId(Long orgid) {
		List<CountryVO> countryVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  Country BY Id : {}", orgid);
			countryVO = countryRepo.findCountryByOrgId(orgid);
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
		} else {
			if (countryRepo.existsByCountryNameAndOrgId(countryDTO.getCountryName(), countryDTO.getOrgId())) {
				throw new ApplicationException("The given Country Name already exists.");
			}
			if (countryRepo.existsByCountryCodeAndOrgId(countryDTO.getCountryCode(), countryDTO.getOrgId())) {
				throw new ApplicationException("The given Country Code already exists.");
			}
		}
		// update check
		if (ObjectUtils.isNotEmpty(countryDTO.getId())) {
			CountryVO country = countryRepo.findById(countryDTO.getId()).orElse(null);
			
			if(!country.getCountryName().equals(countryDTO.getCountryName()) ) {

			if (countryRepo.existsByCountryNameAndOrgId(countryDTO.getCountryName(), countryDTO.getOrgId())) {
				throw new ApplicationException("The given Country Name already exists.");
			}
			}
			
			if(!country.getCountryCode().equals(countryDTO.getCountryCode())) {
				
			if (countryRepo.existsByCountryCodeAndOrgId(countryDTO.getCountryCode(), countryDTO.getOrgId())) {
				throw new ApplicationException("The given Country Code already exists");
			}
			
		}
		}

		getCountryVOFromCountryDTO(countryDTO, countryVO);
		return countryRepo.save(countryVO);
	}

	private void getCountryVOFromCountryDTO(@Valid CountryDTO countryDTO, CountryVO countryVO)
			throws ApplicationException {

		countryVO.setOrgId(countryDTO.getOrgId());
		countryVO.setActive(countryDTO.isActive());
		countryVO.setCountryCode(countryDTO.getCountryCode());
		countryVO.setCountryName(countryDTO.getCountryName());
	}

	// CITY

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
		} else {
			if (cityRepo.existsByCityNameAndOrgId(cityDTO.getCityName(), cityDTO.getOrgId())) {
				throw new ApplicationException("The given city name already exists.");
			}
			if (cityRepo.existsByCityCodeAndOrgId(cityDTO.getCityCode(), cityDTO.getOrgId())) {
				throw new ApplicationException("The given city code already exists.");
			}
		}

		// update check
		if (ObjectUtils.isNotEmpty(cityDTO.getId())) {
			if (cityRepo.existsByCityNameAndOrgId(cityDTO.getCityName(), cityDTO.getOrgId())) {
				throw new ApplicationException("The given city name already exists.");
			}
			if (cityRepo.existsByCityCodeAndOrgId(cityDTO.getCityCode(), cityDTO.getOrgId())) {
				throw new ApplicationException("The given city code already exists");
			}
		}

		getCityVOFromCityDTO(cityDTO, cityVO);
		return cityRepo.save(cityVO);
	}

	private void getCityVOFromCityDTO(@Valid CityDTO cityDTO, CityVO cityVO) throws ApplicationException {

		cityVO.setOrgId(cityDTO.getOrgId());
		cityVO.setActive(cityDTO.isActive());
		cityVO.setCityCode(cityDTO.getCityCode());
		cityVO.setCityName(cityDTO.getCityName());
		cityVO.setCountry(cityDTO.getCountry());
		cityVO.setState(cityDTO.getState());

	}

	@Override
	public List<CityVO> getAllCityByState(Long orgId, String country) {
		return cityRepo.findAllCityByState(orgId, country);
	}

	// State

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
		} else {
			if (stateRepo.existsByStateCodeAndOrgId(stateDTO.getStateCode(), stateDTO.getOrgId())) {
				throw new ApplicationException("The given State Code already exists.");
			}
			if (stateRepo.existsByStateNameAndOrgId(stateDTO.getStateName(), stateDTO.getOrgId())) {
				throw new ApplicationException("The given state name already exists.");
			}
		}
		// update check
		if (ObjectUtils.isNotEmpty(stateDTO.getId())) {
			if (stateRepo.existsByStateCodeAndOrgId(stateDTO.getStateCode(), stateDTO.getOrgId())) {
				throw new ApplicationException("The given State Code already exists.");
			}
			if (stateRepo.existsByStateNameAndOrgId(stateDTO.getStateCode(), stateDTO.getOrgId())) {
				throw new ApplicationException("The given State Name already exists");
			}
		}

		getStateVOFromStateDTO(stateDTO, stateVO);
		return stateRepo.save(stateVO);
	}

	private void getStateVOFromStateDTO(@Valid StateDTO stateDTO, StateVO stateVO) throws ApplicationException {

		stateVO.setOrgId(stateDTO.getOrgId());
		stateVO.setActive(stateDTO.isActive());
		stateVO.setStateCode(stateDTO.getStateCode());
		stateVO.setStateName(stateDTO.getStateName());
		stateVO.setCountry(stateDTO.getCountry());
		stateVO.setRegion(stateDTO.getRegion());
		stateVO.setStateNumber(stateDTO.getStateNumber());

	}

	@Override
	public List<StateVO> getAllStateByCountry(Long orgId, String country) {
		return stateRepo.findAllStateByCountry(orgId, country);
	}

	// Department

	@Override
	public DepartmentVO updateCreateDepartment(@Valid DepartmentDTO departmentDTO) throws ApplicationException {
		DepartmentVO departmentVO = new DepartmentVO();
		if (ObjectUtils.isNotEmpty(departmentDTO.getId())) {
			departmentVO = departmentRepo.findById(departmentDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid Department Details"));
        
		}
		else {
			if(departmentRepo.existsByDepartmentAndOrgId(departmentDTO.getDepartment(),departmentDTO.getOrgId())) {
				throw new ApplicationException("Department already exists");
			}
			if(departmentRepo.existsByDepartmentCodeAndOrgId(departmentDTO.getDepartmentCode(),departmentDTO.getOrgId())) {
				throw new ApplicationException("DepartmentCode already exists");
			}
		}
		
		if(ObjectUtils.isNotEmpty(departmentDTO.getId())) {
			DepartmentVO department = departmentRepo.findById(departmentDTO.getId()).orElse(null);
			if(!department.getDepartment().equals(departmentDTO.getDepartment())) {
				if(departmentRepo.existsByDepartmentAndOrgId(departmentDTO.getDepartment(),departmentDTO.getOrgId())) {
					throw new ApplicationException("Department already exists");
				}
			}
			if(!department.getDepartmentCode().equals(departmentDTO.getDepartmentCode())) {
				if(departmentRepo.existsByDepartmentCodeAndOrgId(departmentDTO.getDepartmentCode(),departmentDTO.getOrgId())) {
					throw new ApplicationException("DepartmentCode already exists");
				}

			}
		}

		getDepartmentVOFromDepartmentDTO(departmentDTO, departmentVO);
		return departmentRepo.save(departmentVO);

	}

	private void getDepartmentVOFromDepartmentDTO(@Valid DepartmentDTO departmentDTO, DepartmentVO departmentVO) {
		departmentVO.setDepartment(departmentDTO.getDepartment());
		departmentVO.setDepartmentCode(departmentDTO.getDepartmentCode());
		departmentVO.setOrgId(departmentDTO.getOrgId());
		departmentVO.setActive(departmentDTO.isActive());
		departmentVO.setUpdatedBy(departmentDTO.getUpdatedBy());
		departmentVO.setCreatedBy(departmentDTO.getCreatedBy());

	}

	@Override
	public List<DepartmentVO> getDepartmentById(Long id) {
		List<DepartmentVO> departmentVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  Department BY Id : {}", id);
			departmentVO = departmentRepo.findDepartmentById(id);
		} else {
			LOGGER.info("Successfully Received  Department For All Id.");
			departmentVO = departmentRepo.findAll();
		}
		return departmentVO;
	}

	@Override
	public List<DepartmentVO> getDepartmentByOrgId(Long orgId) {

		return departmentRepo.findDepartmentByOrgId(orgId);
	}

	// Designation

	@Override
	public DesignationVO updateCreateDesignation(@Valid DesignationDTO designationDTO) throws ApplicationException {
		DesignationVO designationVO = new DesignationVO();
		if (ObjectUtils.isNotEmpty(designationDTO.getId())) {
			designationVO = designationRepo.findById(designationDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid Designation Details"));

		}
		
		else {
			if(designationRepo.existsByDesignationAndOrgId(designationDTO.getDesignation(),designationDTO.getOrgId())){
				throw new ApplicationException("Designation already Exists");
			}
			
		}
		
		if(ObjectUtils.isNotEmpty(designationDTO.getId())) {
			DesignationVO designation =  designationRepo.findById(designationDTO.getId()).orElse(null);
			if(!designation.getDesignation().equals(designationDTO.getDesignation())) {
				if(designationRepo.existsByDesignationAndOrgId(designationDTO.getDesignation(),designationDTO.getOrgId())){
					throw new ApplicationException("Designation already Exists");
				}
			}
		}
		
		getDesignationVOFromDesignationDTO(designationDTO, designationVO);
		return designationRepo.save(designationVO);

	}

	private void getDesignationVOFromDesignationDTO(@Valid DesignationDTO designationDTO, DesignationVO designationVO) {
		designationVO.setDesignation(designationDTO.getDesignation());
		designationVO.setOrgId(designationDTO.getOrgId());
		designationVO.setActive(designationDTO.isActive());
		designationVO.setUpdatedBy(designationDTO.getUpdatedBy());
		designationVO.setCreatedBy(designationDTO.getCreatedBy());

	}

	@Override
	public List<DesignationVO> getDesignationById(Long id) {
		List<DesignationVO> designationVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  Designation BY Id : {}", id);
			designationVO = designationRepo.findDesignationById(id);
		} else {
			LOGGER.info("Successfully Received  Designation For All Id.");
			designationVO = designationRepo.findAll();
		}
		return designationVO;
	}

	@Override
	public List<DesignationVO> getDesignationByOrgId(Long orgid) {

		return designationRepo.findDesignationByorgId(orgid);
	}

	// Employee

	@Override
	public List<EmployeeVO> getEmployeeById(Long id) {
		List<EmployeeVO> employeeVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received Employee BY Id : {}", id);
			employeeVO = employeeRepo.getEmployeeById(id);
		} else {
			LOGGER.info("Successfully Received  Employee For All Id.");
			employeeVO = employeeRepo.findAll();
		}
		return employeeVO;
	}

	@Override
	public List<EmployeeVO> getEmployeeByOrgId(Long orgid) {
		List<EmployeeVO> employeeVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received Employee BY OrgId : {}", orgid);
			employeeVO = employeeRepo.getEmployeeByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  Employee For All OrgId.");
			employeeVO = employeeRepo.findAll();
		}
		return employeeVO;
	}

	@Override
	public EmployeeVO updateCreateEmployee(@Valid EmployeeDTO employeeDTO) throws ApplicationException {
		EmployeeVO employeeVO = new EmployeeVO();
		if (ObjectUtils.isNotEmpty(employeeDTO.getId())) {
			employeeVO = employeeRepo.findById(employeeDTO.getId())
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
		employeeVO.setActive(employeeDTO.isActive());
		employeeVO.setUpdatedBy(employeeDTO.getUpdatedBy());
		employeeVO.setCreatedBy(employeeDTO.getCreatedBy());

	}

	// Port

	@Override
	public PortVO updateCreatePort(@Valid PortDTO portDTO) throws ApplicationException {
		PortVO portVO = new PortVO();
		if (ObjectUtils.isNotEmpty(portDTO.getId())) {
			portVO = portRepo.findById(portDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid Port Details"));
		} else {
			// duplicate control while creating
			if (portRepo.existsByPortAndOrgId(portDTO.getPort(), portDTO.getOrgId())) {
				throw new ApplicationException("Port Name already exists ");
			}
			if (portRepo.existsByCodeAndOrgId(portDTO.getCode(), portDTO.getOrgId())) {
				throw new ApplicationException("Port Code already exists");
			}
		}
		if (ObjectUtils.isNotEmpty(portDTO.getId())) {
			PortVO port = portRepo.findById(portDTO.getId()).orElse(null);
			if(!port.getPort().equals(portDTO.getPort())) {
			if (portRepo.existsByPortAndOrgId(portDTO.getPort(), portDTO.getOrgId())) {
				throw new ApplicationException("Port Name already exists");
			}
			}
			if(!port.getCode().equals(portDTO.getCode())) {
			if (portRepo.existsByCodeAndOrgId(portDTO.getCode(), portDTO.getOrgId())) {
				throw new ApplicationException("Port Code already exists");
			}
			}
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
		portVO.setUpdatedBy(portDTO.getUpdatedBy());
		portVO.setCreatedBy(portDTO.getCreatedBy());

	}

	@Override
	public List<PortVO> getPortById(Long id) {
		List<PortVO> portVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received Port BY Id : {}", id);
			portVO = portRepo.getPortById(id);
		} else {
			LOGGER.info("Successfully Received  Port For All Id.");
			portVO = portRepo.findAll();
		}
		return portVO;
	}

	@Override
	public List<PortVO> getPortByOrgId(Long orgid) {
		List<PortVO> portVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received Port BY OrgId : {}", orgid);
			portVO = portRepo.getPortByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  Port For All OrgId.");
			portVO = portRepo.findAll();
		}
		return portVO;
	}

	// Events

	
	@Override
	public EventsVO updateCreateEvents(@Valid EventsDTO eventsDTO) throws ApplicationException {
		EventsVO eventsVO = new EventsVO();
		// Check if the event ID is present in the DTO
		if (ObjectUtils.isNotEmpty(eventsDTO.getId())) {
			// Fetch the existing event or throw an exception if it doesn't exist
			eventsVO = eventsRepo.findById(eventsDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid Events Details"));
		} else {
			// Create a new EventsVO instance if the event ID is not present
			eventsVO = new EventsVO();

			// Generate a new unique event ID
			int eventid = eventsRepo.findeventid(); // Ensure this method is correctly implemented to fetch the next
													// sequence value
			String eventsid = "Ev" + eventid;
			eventsRepo.getbyeventsid();
			eventsVO.setEventid(eventsid); // Assuming this sets the unique event ID to the eventsVO
			
			if(eventsRepo.existsByEventDescriptionAndOrgId(eventsDTO.getEventDescription(),eventsDTO.getOrgId())) {
				throw new ApplicationException("EventsDescription Already exists");
			}
		}
		
		//Duplicate check
		if(ObjectUtils.isNotEmpty(eventsDTO.getId())) {
			EventsVO events=  eventsRepo.findById(eventsDTO.getId()).orElse(null);
			if(!events.getEventDescription().equals(eventsDTO.getEventDescription())) {
			if(eventsRepo.existsByEventDescriptionAndOrgId(eventsDTO.getEventDescription(),eventsDTO.getOrgId())) {
				throw new ApplicationException("EventsDescription Already exists");
			}
		}
		}
	
		// Update eventsVO fields with values from eventsDTO
		updateEventsVOFromEventsDTO(eventsDTO, eventsVO);

		// Save the updated or new event
		return eventsRepo.save(eventsVO);
	}

	private void updateEventsVOFromEventsDTO(@Valid EventsDTO eventsDTO, EventsVO eventsVO) {
		// Copy properties from DTO to VO
		eventsVO.setEventDescription(eventsDTO.getEventDescription());
		eventsVO.setEventType(eventsDTO.getEventType());
		eventsVO.setOrgId(eventsDTO.getOrgId());
		eventsVO.setActive(eventsDTO.isActive());
		eventsVO.setCreatedBy(eventsDTO.getCreatedBy());
		eventsVO.setUpdatedBy(eventsDTO.getUpdatedBy());
	}
	
	
		@Override
		public String getLatestEventid() {

			int eventid = eventsRepo.findeventid(); // Ensure this method is correctly implemented to fetch the next
													// sequence value
			String eventsid = "Ev" + eventid;
			return eventsid;
		}

		@Override
		public List<EventsVO> getEventsById(Long id) {
			List<EventsVO> eventsVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received  Events BY Id : {}", id);
				eventsVO = eventsRepo.findEventsById(id);
			} else {
				LOGGER.info("Successfully Received  Events For All Id.");
				eventsVO = eventsRepo.findAll();
			}
			return eventsVO;
		}

		@Override
		public List<EventsVO> getEventsByOrgId(Long Orgid) {
			List<EventsVO> eventsVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(Orgid)) {
				LOGGER.info("Successfully Received  Events BY OrgId : {}", Orgid);
				eventsVO = eventsRepo.findEventsByOrgId(Orgid);
			} else {
				LOGGER.info("Successfully Received  Events For All OrgId.");
				eventsVO = eventsRepo.findAll();
			}
			return eventsVO;
		}

		

	// COMPANY

	@Override
	public List<CompanyVO> getCompanyById(Long id) {
		List<CompanyVO> companyVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received Company BY Id : {}", id);
			companyVO = companyRepo.findCompanyById(id);
		} else {
			LOGGER.info("Successfully Received Company For All Id.");
			companyVO = companyRepo.findAll();
		}
		return companyVO;
	}

	@Override
	public List<CompanyVO> getCompanyByOrgId(Long orgId) {
		List<CompanyVO> companyVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgId)) {
			LOGGER.info("Successfully Received  Company BY Id : {}", orgId);
			companyVO = companyRepo.findCompanyByOrgId(orgId);
		} else {
			LOGGER.info("Successfully Received  Company For All OrgId.");
			companyVO = companyRepo.findAll();
		}
		return companyVO;
	}

	@Override
	public CompanyVO updateCreateCompany(@Valid CompanyDTO companyDTO) throws ApplicationException {
		CompanyVO companyVO = new CompanyVO();
		if (ObjectUtils.isNotEmpty(companyDTO.getId())) {
			companyVO = companyRepo.findById(companyDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid company Details"));
		}
		getCompanyVOFromCompanyDTO(companyDTO, companyVO);
		return companyRepo.save(companyVO);
	}

	private void getCompanyVOFromCompanyDTO(@Valid CompanyDTO companyDTO, CompanyVO companyVO) {
		companyVO.setCompanyName(companyDTO.getCompanyName());
		companyVO.setCompanyCode(companyDTO.getCompanyCode());
		companyVO.setEmail(companyDTO.getEmail());
		companyVO.setPhoneNo(companyDTO.getPhoneNo());
		companyVO.setAddress(companyDTO.getAddress());
		companyVO.setCountry(companyDTO.getCountry());
		companyVO.setState(companyDTO.getState());
		companyVO.setCity(companyDTO.getCity());
		companyVO.setPinCode(companyDTO.getPinCode());
		companyVO.setAdminEmail(companyDTO.getAdminEmail());
		companyVO.setPassport(companyDTO.getPassport());
		companyVO.setOrgId(companyDTO.getOrgId());
		companyVO.setActive(companyDTO.isActive());
		companyVO.setCreatedBy(companyDTO.getCreatedBy());
		companyVO.setUpdatedBy(companyDTO.getUpdatedBy());

	}

	// Container

	@Override
	public List<ContainerVO> getContainerById(Long id) {
		List<ContainerVO> containerVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  Container BY Id : {}", id);
			containerVO = containerRepo.findContainerById(id);
		} else {
			LOGGER.info("Successfully Received  Container For All Id.");
			containerVO = containerRepo.findAll();
		}
		return containerVO;
	}

	@Override
	public List<ContainerVO> getContainerByOrgId(Long Orgid) {
		List<ContainerVO> containerVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(Orgid)) {
			LOGGER.info("Successfully Received  Container BY OrgId : {}", Orgid);
			containerVO = containerRepo.getContainerByOrgId(Orgid);
		} else {
			LOGGER.info("Successfully Received  Container For All OrgId.");
			containerVO = containerRepo.findAll();
		}
		return containerVO;
	}

	@Override
	public ContainerVO updateCreateContainer(@Valid ContainerDTO containerDTO) throws ApplicationException {
		ContainerVO containerVO = new ContainerVO();
		if (ObjectUtils.isNotEmpty(containerDTO.getId())) {
			containerVO = containerRepo.findById(containerDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid Container Details"));
		}
		
		//Duplicate check
		else {
			if(containerRepo.existsByCategoryAndOrgId(containerDTO.getCategory(),containerDTO.getOrgId())) {
				throw new ApplicationException("Category already Exists");
			}
		}
		
		if(ObjectUtils.isNotEmpty(containerDTO.getId())) {
			ContainerVO container =  containerRepo.findById(containerDTO.getId()).orElse(null);
			if(!container.getCategory().equals(containerDTO.getCategory())) {
			if(containerRepo.existsByCategoryAndOrgId(containerDTO.getCategory(),containerDTO.getOrgId())) {
				throw new ApplicationException("Category already Exists");
			}
			}
		}
		getContainerVOFromContainerDTO(containerDTO, containerVO);
		return containerRepo.save(containerVO);
	}

	private void getContainerVOFromContainerDTO(@Valid ContainerDTO containerDTO, ContainerVO containerVO) {
		containerVO.setContainerType(containerDTO.getContainerType());
		containerVO.setCategory(containerDTO.getCategory());
		containerVO.setLength(containerDTO.getLength());
		containerVO.setWidth(containerDTO.getWidth());
		containerVO.setHeight(containerDTO.getHeight());
		containerVO.setWeight(containerDTO.getWeight());
		containerVO.setVolume(containerDTO.getVolume());
		containerVO.setOrgId(containerDTO.getOrgId());
		containerVO.setActive(containerDTO.isActive());
		containerVO.setCreatedBy(containerDTO.getCreatedBy());
		containerVO.setUpdatedBy(containerDTO.getUpdatedBy());

	}

	
	// Segments

	@Override
	public List<SegmentsVO> getSegmentsById(Long id) {
		List<SegmentsVO> segmentsVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  Segments BY Id : {}", id);
			segmentsVO = segmentsRepo.getSegmentsById(id);
		} else {
			LOGGER.info("Successfully Received  Segments For All Id.");
			segmentsVO = segmentsRepo.findAll();
		}
		return segmentsVO;
	}

	@Override
	public List<SegmentsVO> getSegmentsByOrgId(Long orgid) {
		List<SegmentsVO> segmentsVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  Segments BY OrgId : {}", orgid);
			segmentsVO = segmentsRepo.getSegmentsByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  Segments For All OrgId.");
			segmentsVO = segmentsRepo.findAll();
		}
		return segmentsVO;
	}

	@Override
	public SegmentsVO updateCreateSegments(@Valid SegmentsDTO segmentsDTO) throws ApplicationException {
		SegmentsVO segmentsVO = new SegmentsVO();
		if (ObjectUtils.isNotEmpty(segmentsDTO.getId())) {
			segmentsVO = segmentsRepo.findById(segmentsDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid Segments Details"));
		}
		getSegmentsVOFromSegmentsDTO(segmentsDTO, segmentsVO);
		return segmentsRepo.save(segmentsVO);
	}

	private void getSegmentsVOFromSegmentsDTO(@Valid SegmentsDTO segmentsDTO, SegmentsVO segmentsVO) {
		segmentsVO.setSegmentName(segmentsDTO.getSegmentName());
		segmentsVO.setSegmentDescription(segmentsDTO.getSegmentDescription());
		segmentsVO.setOrgId(segmentsDTO.getOrgId());
		segmentsVO.setActive(segmentsDTO.isActive());
		segmentsVO.setCreatedBy(segmentsDTO.getCreatedBy());
		segmentsVO.setUpdatedBy(segmentsDTO.getUpdatedBy());

	}

	// Region

	@Override
	public List<RegionVO> getRegionById(Long id) {
		List<RegionVO> regionVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  Region BY Id : {}", id);
			regionVO = regionRepo.getRegionById(id);
		} else {
			LOGGER.info("Successfully Received  Region For All Id.");
			regionVO = regionRepo.findAll();
		}
		return regionVO;
	}

	@Override
	public List<RegionVO> getRegionByOrgId(Long orgid) {
		List<RegionVO> regionVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  Region BY OrgId : {}", orgid);
			regionVO = regionRepo.getRegionByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  Region For All OrgId.");
			regionVO = regionRepo.findAll();
		}
		return regionVO;
	}

	@Override
	public RegionVO updateCreateRegion(@Valid RegionDTO regionDTO) throws ApplicationException {
		RegionVO regionVO = new RegionVO();
		if (ObjectUtils.isNotEmpty(regionDTO.getId())) {
			regionVO = regionRepo.findById(regionDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid Region Details"));
		}
		getRegionVOFromRegionDTO(regionDTO, regionVO);
		return regionRepo.save(regionVO);
	}

	private void getRegionVOFromRegionDTO(@Valid RegionDTO regionDTO, RegionVO regionVO) {
		regionVO.setRegionCode(regionDTO.getRegionCode());
		regionVO.setRegionName(regionDTO.getRegionName());
		regionVO.setOrgId(regionDTO.getOrgId());
		regionVO.setActive(regionDTO.isActive());
		regionVO.setCreatedBy(regionDTO.getCreatedBy());
		regionVO.setUpdatedBy(regionDTO.getUpdatedBy());

	}

	// DocumentType

//	@Override
//	public List<DocumentTypeVO> getDocumentTypeById(Long id) {
//		List<DocumentTypeVO> documentTypeVO = new ArrayList<>();
//		if (ObjectUtils.isNotEmpty(id)) {
//			LOGGER.info("Successfully Received  DocumentType BY Id : {}", id);
//			documentTypeVO = documentTypeRepo.getDocumentTypeById(id);
//		} else {
//			LOGGER.info("Successfully Received  DocumentType For All Id.");
//			documentTypeVO = documentTypeRepo.findAll();
//		}
//		return documentTypeVO;
//	}
	
	@Override
	public List<DocumentTypeVO> getAllDocumentType() {
		return documentTypeRepo.findAll();
	}

	@Override
	public Optional<DocumentTypeVO> getDocumentTypeById(Long id) {
		return documentTypeRepo.findById(id);
	}

	@Override
	public List<DocumentTypeVO> getDocumentTypeByOrgId(Long orgid) {
		List<DocumentTypeVO> documentTypeVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  DocumentType BY OrgId : {}", orgid);
			documentTypeVO = documentTypeRepo.getDocumentTypeByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  DocumentType For All OrgId.");
			documentTypeVO = documentTypeRepo.findAll();
		}
		return documentTypeVO;
	}

	@Override
	public DocumentTypeVO updateCreateDocumentType(@Valid DocumentTypeDTO documentTypeDTO) throws ApplicationException {
		DocumentTypeVO documentTypeVO = new DocumentTypeVO();
		if (ObjectUtils.isNotEmpty(documentTypeDTO.getId())) {
			documentTypeVO = documentTypeRepo.findById(documentTypeDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid DocumentType details"));
		}
		//Duplicate check
		else {
			if(documentTypeRepo.existsByDocumentNameAndOrgId(documentTypeDTO.getDocumentName(),documentTypeDTO.getOrgId())) {
				throw new ApplicationException("DocumentName already exists");
			}
			if(documentTypeRepo.existsByDocumentTypeAndOrgId(documentTypeDTO.getDocumentType(),documentTypeDTO.getOrgId())) {
				throw new ApplicationException("DocumentType already exists");
			}
		}
		
		if(ObjectUtils.isNotEmpty(documentTypeDTO.getId())) {
			
			DocumentTypeVO documentType =documentTypeRepo.findById(documentTypeDTO.getId()).orElse(null);
			if(!documentType.getDocumentName().equals(documentTypeDTO.getDocumentName())) {
			if(documentTypeRepo.existsByDocumentNameAndOrgId(documentTypeDTO.getDocumentName(),documentTypeDTO.getOrgId())) {
				throw new ApplicationException("DocumentName already exists");
			}
			}
			if(!documentType.getDocumentType().equals(documentTypeDTO.getDocumentType())) {
			if(documentTypeRepo.existsByDocumentTypeAndOrgId(documentTypeDTO.getDocumentType(),documentTypeDTO.getOrgId())) {
				throw new ApplicationException("DocumentType already exists");
			}
			}
		}
		
		List<SubTypesVO> subTypesVOList = subTypesRepo.findByDocumentTypeVO(documentTypeVO);
		subTypesRepo.deleteAll(subTypesVOList);
		
		List<SubTypesVO> subTypesVOs = new ArrayList<>();
		if (documentTypeDTO.getSubTypesDTO() != null) {
			for (SubTypesDTO subTypesDTO : documentTypeDTO.getSubTypesDTO()) {					
					SubTypesVO subTypesVO = new SubTypesVO();
					subTypesVO.setSubType(subTypesDTO.getSubType());
					subTypesVO.setSubTypeCode(subTypesDTO.getSubTypeCode());
					subTypesVO.setMonth(subTypesDTO.getMonth());
					subTypesVO.setSubTypeName(subTypesDTO.getSubTypeName());
					subTypesVO.setDocumentTypeVO(documentTypeVO);
					subTypesVOs.add(subTypesVO);
				}
			}
		

		getDocumentTypeVOFromDocumentTypeDTO(documentTypeDTO, documentTypeVO);

		documentTypeVO.setSubTypesVO(subTypesVOs);
		return documentTypeRepo.save(documentTypeVO);

	}

	private void getDocumentTypeVOFromDocumentTypeDTO(@Valid DocumentTypeDTO documentTypeDTO,
			DocumentTypeVO documentTypeVO) {
		documentTypeVO.setDocumentName(documentTypeDTO.getDocumentName());
		documentTypeVO.setDocumentCode(documentTypeDTO.getDocumentCode());
		documentTypeVO.setDocumentType(documentTypeDTO.getDocumentType());
		documentTypeVO.setDocumentDescription(documentTypeDTO.getDocumentDescription());
		documentTypeVO.setModule(documentTypeDTO.getModule());
		documentTypeVO.setSubModule(documentTypeDTO.getSubModule());
		documentTypeVO.setPrimaryTable(documentTypeDTO.getPrimaryTable());
		documentTypeVO.setAutoGenField(documentTypeDTO.getAutoGenField());
		documentTypeVO.setPrefixField(documentTypeDTO.getPrefixField());
		documentTypeVO.setCode(documentTypeDTO.getCode());
		documentTypeVO.setFinyr(documentTypeDTO.getFinyr());
		documentTypeVO.setBranch(documentTypeDTO.getBranch());
		documentTypeVO.setPrefix(documentTypeDTO.getPrefix());
		documentTypeVO.setPostFinance(documentTypeDTO.isPostFinance());
		documentTypeVO.setFinanceTransaction(documentTypeDTO.isFinanceTransaction());
		documentTypeVO.setNoGeneration(documentTypeDTO.isNoGeneration());

		documentTypeVO.setOrgId(documentTypeDTO.getOrgId());
		documentTypeVO.setActive(documentTypeDTO.isActive());
		documentTypeVO.setCreatedBy(documentTypeDTO.getCreatedBy());
		documentTypeVO.setUpdatedBy(documentTypeDTO.getUpdatedBy());

	}

	// DocumentTypeMapping

	@Override
	public List<DocumentTypeMappingVO> getDocumentTypeMappingById(Long id) {
		List<DocumentTypeMappingVO> documentTypeMappingVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  DocumentTypeMapping BY Id : {}", id);
			documentTypeMappingVO = documentTypeMappingRepo.getDocumentTypeMappingById(id);
		} else {
			LOGGER.info("Successfully Received  DocumentTypeMapping For All Id.");
			documentTypeMappingVO = documentTypeMappingRepo.findAll();
		}
		return documentTypeMappingVO;
	}

	@Override
	public List<DocumentTypeMappingVO> getDocumentTypeMappingByOrgId(Long orgid) {
		List<DocumentTypeMappingVO> documentTypeMappingVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  DocumentTypeMapping BY OrgId : {}", orgid);
			documentTypeMappingVO = documentTypeMappingRepo.getDocumentTypeMappingByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  DocumentTypeMapping For All OrgId.");
			documentTypeMappingVO = documentTypeMappingRepo.findAll();
		}
		return documentTypeMappingVO;
	}

	@Override
	public DocumentTypeMappingVO updateCreateDocumentTypeMapping(@Valid DocumentTypeMappingDTO documentTypeMappingDTO)
			throws ApplicationException {
		DocumentTypeMappingVO documentTypeMappingVO = new DocumentTypeMappingVO();
		if (ObjectUtils.isNotEmpty(documentTypeMappingDTO.getId())) {
			documentTypeMappingVO = documentTypeMappingRepo.findById(documentTypeMappingDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid DocumentTypeMapping details"));
		}
		
		else {
			if(documentTypeMappingRepo.existsByBranchAndOrgId(documentTypeMappingDTO.getBranch(),documentTypeMappingDTO.getOrgId())) {
				throw new ApplicationException("Branch already exists");
			}
			if(documentTypeMappingRepo.existsByFinancialYearAndOrgId(documentTypeMappingDTO.getFinancialYear(),documentTypeMappingDTO.getOrgId())) {
				throw new ApplicationException("FinancialYear already exists");
			}
		}
		
		if(ObjectUtils.isNotEmpty(documentTypeMappingDTO.getId())) {
			DocumentTypeMappingVO documentTypeMapping = documentTypeMappingRepo.findById(documentTypeMappingDTO.getId()).orElse(null);
			if(!documentTypeMapping.getBranch().equals(documentTypeMappingDTO.getBranch())) {
			if(documentTypeMappingRepo.existsByBranchAndOrgId(documentTypeMappingDTO.getBranch(),documentTypeMappingDTO.getOrgId())) {
				throw new ApplicationException("Branch already exists");
			}
			}
			if(!documentTypeMapping.getFinancialYear().equals(documentTypeMappingDTO.getFinancialYear())) {
			if(documentTypeMappingRepo.existsByFinancialYearAndOrgId(documentTypeMappingDTO.getFinancialYear(),documentTypeMappingDTO.getOrgId())) {
				throw new ApplicationException("FinancialYear already exists");
			}
		}
		}

		List<MappingVO> mappingVOList = mappingRepo.findByDocumentTypeMappingVO(documentTypeMappingVO);
		mappingRepo.deleteAll(mappingVOList);
		
		List<MappingVO> mappingVOs = new ArrayList<>();
		if (documentTypeMappingDTO.getMappingDTO() != null) {
			for (MappingDTO mappingDTO : documentTypeMappingDTO.getMappingDTO()) {
					MappingVO mappingVO = new MappingVO();
					mappingVO.setDocType(mappingDTO.getDocType());
					mappingVO.setSubType(mappingDTO.getSubType());
					mappingVO.setSubTypeId(mappingDTO.getSubTypeId());
					mappingVO.setSubTypeCode(mappingDTO.getSubTypeCode());
					mappingVO.setDocName(mappingDTO.getDocName());
					mappingVO.setPrefix(mappingDTO.getPrefix());
					mappingVO.setPostFinance(mappingDTO.isPostFinance());
					mappingVO.setLastNo(mappingDTO.getLastNo());
					mappingVO.setResetOnFinYear(mappingDTO.isResetOnFinYear());
					mappingVO.setDocumentTypeMappingVO(documentTypeMappingVO);
					mappingVOs.add(mappingVO);

				}
		}

		getDocumentTypeMappingVOFromDocumentTypeMappingDTO(documentTypeMappingDTO, documentTypeMappingVO);

		documentTypeMappingVO.setMappingVO(mappingVOs);
		return documentTypeMappingRepo.save(documentTypeMappingVO);

	}

	private void getDocumentTypeMappingVOFromDocumentTypeMappingDTO(
			@Valid DocumentTypeMappingDTO documentTypeMappingDTO, DocumentTypeMappingVO documentTypeMappingVO) {
		documentTypeMappingVO.setBranch(documentTypeMappingDTO.getBranch());
		documentTypeMappingVO.setOrgId(documentTypeMappingDTO.getOrgId());
		documentTypeMappingVO.setFinancialYear(documentTypeMappingDTO.getFinancialYear());
		documentTypeMappingVO.setCreatedBy(documentTypeMappingDTO.getCreatedBy());
		documentTypeMappingVO.setUpdatedBy(documentTypeMappingDTO.getUpdatedBy());
		documentTypeMappingVO.setActive(documentTypeMappingDTO.isActive());

	}

	// ListOfValues

	@Override
	public List<ListOfValuesVO> getListOfValuesById(Long id) {
		List<ListOfValuesVO> listOfValuesVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  ListOfValues BY Id : {}", id);
			listOfValuesVO = listOfValuesRepo.getListOfValuesById(id);
		} else {
			LOGGER.info("Successfully Received  ListOfValues For All Id.");
			listOfValuesVO = listOfValuesRepo.findAll();
		}
		return listOfValuesVO;
	}

	@Override
	public List<ListOfValuesVO> getListOfValuesByOrgId(Long orgid) {
		List<ListOfValuesVO> listOfValuesVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  ListOfValues BY OrgId : {}", orgid);
			listOfValuesVO = listOfValuesRepo.getListOfValuesByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  ListOfValues For All OrgId.");
			listOfValuesVO = listOfValuesRepo.findAll();
		}
		return listOfValuesVO;
	}

	@Override
	public ListOfValuesVO updateCreateListOfValues(@Valid ListOfValuesDTO listOfValuesDTO) throws ApplicationException {
		ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
		if (ObjectUtils.isNotEmpty(listOfValuesDTO.getId())) {
			listOfValuesVO = listOfValuesRepo.findById(listOfValuesDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid ListOfValues details"));
		}

		List<ListOfValues1VO> listOfValues1VOList = listOfValues1Repo.findBylistOfValuesVO(listOfValuesVO);
		listOfValues1Repo.deleteAll(listOfValues1VOList);
		
		List<ListOfValues1VO> listOfValues1VOs = new ArrayList<>();
		if (listOfValuesDTO.getListOfValues1DTO() != null) {
			for (ListOfValues1DTO listOfValues1DTO : listOfValuesDTO.getListOfValues1DTO()) {
				
					ListOfValues1VO listOfValues1VO = new ListOfValues1VO();
					listOfValues1VO.setValueCode(listOfValues1DTO.getValueCode());
					listOfValues1VO.setSNo(listOfValues1DTO.getSNo());
					listOfValues1VO.setValueDescription(listOfValues1DTO.getValueDescription());
					listOfValues1VO.setActive(listOfValues1DTO.isActive());
					listOfValues1VO.setListOfValuesVO(listOfValuesVO);
					listOfValues1VOs.add(listOfValues1VO);

				}
			
		}

		getListOfValuesVOFromTypesOfValuesDTO(listOfValuesDTO, listOfValuesVO);

		listOfValuesVO.setListOfValues1VO(listOfValues1VOs);
		return listOfValuesRepo.save(listOfValuesVO);

	}

	private void getListOfValuesVOFromTypesOfValuesDTO(@Valid ListOfValuesDTO listOfValuesDTO,
			ListOfValuesVO listOfValuesVO) {
		listOfValuesVO.setListCode(listOfValuesDTO.getListCode());
		listOfValuesVO.setOrgId(listOfValuesDTO.getOrgId());
		listOfValuesVO.setListDescription(listOfValuesDTO.getListDescription());
		listOfValuesVO.setActive(listOfValuesDTO.isActive());
		listOfValuesVO.setUpdatedBy(listOfValuesDTO.getUpdatedBy());
		listOfValuesVO.setCreatedBy(listOfValuesDTO.getCreatedBy());

	}

	// TermsAndCondition

	@Override
	public List<TermsAndConditionVO> getTermsAndConditionById(Long id) {
		List<TermsAndConditionVO> termsAndConditionVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  TermsAndCondition BY Id : {}", id);
			termsAndConditionVO = termsAndConditionRepo.getTermsAndConditionById(id);
		} else {
			LOGGER.info("Successfully Received  TermsAndCondition For All Id.");
			termsAndConditionVO = termsAndConditionRepo.findAll();
		}
		return termsAndConditionVO;
	}

	@Override
	public List<TermsAndConditionVO> getTermsAndConditionByOrgId(Long orgid) {
		List<TermsAndConditionVO> termsAndConditionVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  TermsAndCondition BY OrgId : {}", orgid);
			termsAndConditionVO = termsAndConditionRepo.getTermsAndConditionByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  TermsAndCondition For All OrgId.");
			termsAndConditionVO = termsAndConditionRepo.findAll();
		}
		return termsAndConditionVO;
	}

	@Override
	public TermsAndConditionVO updateCreateCountry(@Valid TermsAndConditionDTO termsAndConditionDTO)
			throws ApplicationException {
		TermsAndConditionVO termsAndConditionVO = new TermsAndConditionVO();
		if (ObjectUtils.isNotEmpty(termsAndConditionDTO.getId())) {
			termsAndConditionVO = termsAndConditionRepo.findById(termsAndConditionDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid TermsAndCondition Details"));
		}
		getTermsAndConditionVOFromTermsAndConditionDTO(termsAndConditionDTO, termsAndConditionVO);
		return termsAndConditionRepo.save(termsAndConditionVO);
	}

	private void getTermsAndConditionVOFromTermsAndConditionDTO(@Valid TermsAndConditionDTO termsAndConditionDTO,
			TermsAndConditionVO termsAndConditionVO) {
		termsAndConditionVO.setBranch(termsAndConditionDTO.getBranch());
		termsAndConditionVO.setTerms(termsAndConditionDTO.getTerms());
		termsAndConditionVO.setDocumentType(termsAndConditionDTO.getDocumentType());
		termsAndConditionVO.setPartyType(termsAndConditionDTO.getPartyType());
		termsAndConditionVO.setOrgId(termsAndConditionDTO.getOrgId());
		termsAndConditionVO.setActive(termsAndConditionDTO.isActive());
		termsAndConditionVO.setCreatedBy(termsAndConditionDTO.getCreatedBy());
		termsAndConditionVO.setUpdatedBy(termsAndConditionDTO.getUpdatedBy());

	}

	// GstIn

	@Override
	public List<GstInVO> getGstInById(Long id) {
		List<GstInVO> gstInVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  GstIn BY Id : {}", id);
			gstInVO = gstInRepo.getGstInById(id);
		} else {
			LOGGER.info("Successfully Received  GstIn For All Id.");
			gstInVO = gstInRepo.findAll();
		}
		return gstInVO;
	}

	@Override
	public List<GstInVO> getGstInByOrgId(Long orgid) {
		List<GstInVO> gstInVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  GstIn BY OrgId : {}", orgid);
			gstInVO = gstInRepo.getGstInByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  GstIn For All OrgId.");
			gstInVO = gstInRepo.findAll();
		}
		return gstInVO;
	}

	@Override
	public GstInVO updateCreateGstIn(@Valid GstInDTO gstInDTO) throws ApplicationException {
		GstInVO gstInVO = new GstInVO();
		if (ObjectUtils.isNotEmpty(gstInDTO.getId())) {
			gstInVO = gstInRepo.findById(gstInDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid gstIn details"));
		}
		//duplicate check
		
		else {
			if(gstInRepo.existsByPanNameAndOrgId(gstInDTO.getPanName(),gstInDTO.getOrgId())) {
				throw new ApplicationException("PanName already exists");
			}
			if(gstInRepo.existsByPartyNameAndOrgId(gstInDTO.getPartyName(),gstInDTO.getOrgId())) {
				throw new ApplicationException("PartyName already Exists");
			}
		}
		
		if(ObjectUtils.isNotEmpty(gstInDTO.getId())) {
			GstInVO gstIn=  gstInRepo.findById(gstInDTO.getId()).orElse(null);
			if(!gstIn.getPanName().equals(gstInDTO.getPanName())) {
			if(gstInRepo.existsByPanNameAndOrgId(gstInDTO.getPanName(),gstInDTO.getOrgId())) {
				throw new ApplicationException("PanName already exists");
			}
			}
			if(!gstIn.getPartyName().equals(gstInDTO.getPartyName())) {
			if(gstInRepo.existsByPartyNameAndOrgId(gstInDTO.getPartyName(),gstInDTO.getOrgId())) {
				throw new ApplicationException("PartyName already Exists");
			}
			}
		}
		
		List<StateGstVO> stateGstVOList = stateGstRepo.findByGstInVO(gstInVO);
		stateGstRepo.deleteAll(stateGstVOList);
		
		List<StateGstVO> stateGstVOs = new ArrayList<>();
		if (gstInDTO.getStateGstDTO() != null) {
			for (StateGstDTO stateGstDTO : gstInDTO.getStateGstDTO()) {
				

					StateGstVO stateGstVO = new StateGstVO();
					stateGstVO.setStateGst(stateGstDTO.getStateGst());
					stateGstVO.setGstIn(stateGstDTO.getGstIn());
					stateGstVO.setStateCode(stateGstDTO.getStateCode());
					stateGstVO.setContactPerson(stateGstDTO.getContactPerson());
					stateGstVO.setContactPhoneNo(stateGstDTO.getContactPhoneNo());
					stateGstVO.setContactEmail(stateGstDTO.getContactEmail());
					stateGstVO.setGstInVO(gstInVO);
					stateGstVOs.add(stateGstVO);
				}
		}
		
		List<BusinessAddressVO> businessAddressVOList = businessAddressRepo.findByGstInVO(gstInVO);
		businessAddressRepo.deleteAll(businessAddressVOList);
		
		List<BusinessAddressVO> businessAddressVOs = new ArrayList<>();
		if (gstInDTO.getBusinessAddressDTO() != null) {
			for (BusinessAddressDTO businessAddressDTO : gstInDTO.getBusinessAddressDTO()) {
				
					BusinessAddressVO businessAddressVO = new BusinessAddressVO();
					businessAddressVO.setState(businessAddressDTO.getState());
					businessAddressVO.setAddress1(businessAddressDTO.getAddress1());
					businessAddressVO.setAddress2(businessAddressDTO.getAddress2());
					businessAddressVO.setBusinessPlace(businessAddressDTO.getBusinessPlace());
					businessAddressVO.setCityName(businessAddressDTO.getCityName());
					businessAddressVO.setContactPerson(businessAddressDTO.getContactPerson());
					businessAddressVO.setContactPhoneNo(businessAddressDTO.getContactPhoneNo());
					businessAddressVO.setContactEmail(businessAddressDTO.getContactEmail());
					businessAddressVO.setGstInVO(gstInVO);
					businessAddressVOs.add(businessAddressVO);
				}
		}
		getGstInVOFromGstInDTO(gstInDTO, gstInVO);
		gstInVO.setStateGstVO(stateGstVOs);
		gstInVO.setBusinessAddressVO(businessAddressVOs);
		return gstInRepo.save(gstInVO);
	}

	private void getGstInVOFromGstInDTO(@Valid GstInDTO gstInDTO, GstInVO gstInVO) {
		gstInVO.setPan(gstInDTO.getPan());
		gstInVO.setPanName(gstInDTO.getPanName());
		gstInVO.setPartyName(gstInDTO.getPartyName());
		gstInVO.setAccountType(gstInDTO.getAccountType());
		gstInVO.setBusinessCategory(gstInDTO.getBusinessCategory());
		gstInVO.setBussinessType(gstInDTO.getBussinessType());
		gstInVO.setOrgId(gstInDTO.getOrgId());
		gstInVO.setActive(gstInDTO.isActive());
		gstInVO.setUpdatedBy(gstInDTO.getUpdatedBy());
		gstInVO.setCreatedBy(gstInDTO.getCreatedBy());

	}

	// PartyScreening

	@Override
	public List<PartyScreeningVO> getPartyScreeningById(Long id) {
		List<PartyScreeningVO> partyScreeningVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  PartyScreening BY Id : {}", id);
			partyScreeningVO = partyScreeningRepo.getPartyScreeningById(id);
		} else {
			LOGGER.info("Successfully Received  PartyScreening For All Id.");
			partyScreeningVO = partyScreeningRepo.findAll();
		}
		return partyScreeningVO;
	}

	@Override
	public List<PartyScreeningVO> getPartyScreeningByOrgId(Long orgid) {
		List<PartyScreeningVO> partyScreeningVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  PartyScreening BY OrgId : {}", orgid);
			partyScreeningVO = partyScreeningRepo.getPartyScreeningByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  PartyScreening For All OrgId.");
			partyScreeningVO = partyScreeningRepo.findAll();
		}
		return partyScreeningVO;
	}

	@Override
	public PartyScreeningVO updateCreatePartyScreening(@Valid PartyScreeningDTO partyScreeningDTO)
			throws ApplicationException {
		PartyScreeningVO partyScreeningVO = new PartyScreeningVO();
		if (ObjectUtils.isNotEmpty(partyScreeningDTO.getId())) {
			partyScreeningVO = partyScreeningRepo.findById(partyScreeningDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid PartyScreening Details"));
		}
		getPartyScreeningVOFromPartyScreeningDTO(partyScreeningDTO, partyScreeningVO);
		return partyScreeningRepo.save(partyScreeningVO);
	}

	private void getPartyScreeningVOFromPartyScreeningDTO(@Valid PartyScreeningDTO partyScreeningDTO,
			PartyScreeningVO partyScreeningVO) {
		partyScreeningVO.setPartyType(partyScreeningDTO.getPartyType());
		partyScreeningVO.setEntityName(partyScreeningDTO.getEntityName());
		partyScreeningVO.setAlternativeEntityNames(partyScreeningDTO.getAlternativeEntityNames());
		partyScreeningVO.setUniqueId(partyScreeningDTO.getUniqueId());
		partyScreeningVO.setIncludeAlias(partyScreeningDTO.getIncludeAlias());
		partyScreeningVO.setScreeningstatus(partyScreeningDTO.getScreeningstatus());
		partyScreeningVO.setOrgId(partyScreeningDTO.getOrgId());
		partyScreeningVO.setActive(partyScreeningDTO.isActive());
		partyScreeningVO.setCreatedBy(partyScreeningDTO.getCreatedBy());
		partyScreeningVO.setUpdatedBy(partyScreeningDTO.getUpdatedBy());

	}

	

}
