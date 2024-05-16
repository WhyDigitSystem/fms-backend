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
import com.base.basesetup.dto.CompanyDTO;
import com.base.basesetup.dto.ContainerDTO;
import com.base.basesetup.dto.CountryDTO;
import com.base.basesetup.dto.DepartmentDTO;
import com.base.basesetup.dto.DesignationDTO;
import com.base.basesetup.dto.DocumentTypeDTO;
import com.base.basesetup.dto.DocumentTypeMappingDTO;
import com.base.basesetup.dto.EmployeeDTO;
import com.base.basesetup.dto.EventsDTO;
import com.base.basesetup.dto.ListOfValues1DTO;
import com.base.basesetup.dto.ListOfValuesDTO;
import com.base.basesetup.dto.MappingDTO;
import com.base.basesetup.dto.PortDTO;
import com.base.basesetup.dto.RegionDTO;
import com.base.basesetup.dto.SegmentsDTO;
import com.base.basesetup.dto.StateDTO;
import com.base.basesetup.dto.SubTypesDTO;
import com.base.basesetup.dto.TermsAndConditionDTO;
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
import com.base.basesetup.entity.ListOfValues1VO;
import com.base.basesetup.entity.ListOfValuesVO;
import com.base.basesetup.entity.MappingVO;
import com.base.basesetup.entity.PortVO;
import com.base.basesetup.entity.RegionVO;
import com.base.basesetup.entity.SegmentsVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.entity.SubTypesVO;
import com.base.basesetup.entity.TermsAndConditionVO;
import com.base.basesetup.exception.ApplicationException;
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
import com.base.basesetup.repo.ListOfValues1Repo;
import com.base.basesetup.repo.ListOfValuesRepo;
import com.base.basesetup.repo.MappingRepo;
import com.base.basesetup.repo.PortRepo;
import com.base.basesetup.repo.RegionRepo;
import com.base.basesetup.repo.SegmentsRepo;
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
	
	//COUNTRY

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

	}

    //CITY

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
		}
		getStateVOFromStateDTO(stateDTO, stateVO);
		return stateRepo.save(stateVO);
	}

	private void getStateVOFromStateDTO(@Valid StateDTO stateDTO, StateVO stateVO) {
		stateVO.setOrgId(stateDTO.getOrgId());
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

		getDepartmentVOFromDepartmentDTO(departmentDTO, departmentVO);
		return departmentRepo.save(departmentVO);

	}

	private void getDepartmentVOFromDepartmentDTO(@Valid DepartmentDTO departmentDTO, DepartmentVO departmentVO) {
		departmentVO.setDepartment(departmentDTO.getDepartment());
		departmentVO.setDepartmentCode(departmentDTO.getDepartmentCode());
		departmentVO.setOrgId(departmentDTO.getOrgId());
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


	//Designation
	
	@Override
	public DesignationVO updateCreateDesignation(@Valid DesignationDTO designationDTO) throws ApplicationException {
		DesignationVO designationVO = new DesignationVO();
		if (ObjectUtils.isNotEmpty(designationDTO.getId())) {
			designationVO = designationRepo.findById(designationDTO.getId())
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

	//Employee 
	
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
	}

	//Port
	
	@Override
	public PortVO updateCreatePort(@Valid PortDTO portDTO) throws ApplicationException {
		PortVO portVO = new PortVO();
		if (ObjectUtils.isNotEmpty(portDTO.getId())) {
			portVO = portRepo.findById(portDTO.getId())
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
	
     //COMPANY
	
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
	}

		//Container
		
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

		}
		
		//Events

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

		@Override
		public EventsVO updateCreateEvents(@Valid EventsDTO eventsDTO) throws ApplicationException {
		     EventsVO eventsVO = new EventsVO();
			if (ObjectUtils.isNotEmpty(eventsDTO.getId())) {
				eventsVO = eventsRepo.findById(eventsDTO.getId())
						.orElseThrow(() -> new ApplicationException("Invalid Events Details"));
			}
			getEventsVOFromEventsDTO(eventsDTO, eventsVO);
			return eventsRepo.save(eventsVO);
		}

		private void getEventsVOFromEventsDTO(@Valid EventsDTO eventsDTO, EventsVO eventsVO) {
			eventsVO.setEventDescription(eventsDTO.getEventDescription());
			eventsVO.setEventType(eventsDTO.getEventType());
			eventsVO.setOrgId(eventsDTO.getOrgId());		
		}
		
		//Segments

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
		}

			//Region
			
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
			}

			//DocumentType
			
			@Override
			public List<DocumentTypeVO> getDocumentTypeById(Long id) {
				List<DocumentTypeVO> documentTypeVO = new ArrayList<>();
				if (ObjectUtils.isNotEmpty(id)) {
					LOGGER.info("Successfully Received  DocumentType BY Id : {}", id);
					documentTypeVO = documentTypeRepo.getDocumentTypeById(id);
				} else {
					LOGGER.info("Successfully Received  DocumentType For All Id.");
					documentTypeVO = documentTypeRepo.findAll();
				}
				return documentTypeVO;
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

				List<SubTypesVO> subTypesVOs = new ArrayList<>();
				if (documentTypeDTO.getSubTypesDTO() != null) {
					for (SubTypesDTO subTypesDTO : documentTypeDTO.getSubTypesDTO()) {
						if (subTypesDTO.getId() != null & ObjectUtils.isNotEmpty(subTypesDTO.getId())) {
							SubTypesVO subTypesVO = subTypesRepo.findById(subTypesDTO.getId()).get();
							subTypesVO.setSubType(subTypesDTO.getSubType());
							subTypesVO.setSubTypeCode(subTypesDTO.getSubTypeCode());
							subTypesVO.setMonth(subTypesDTO.getMonth());
							subTypesVO.setSubTypeName(subTypesDTO.getSubTypeName());
							subTypesVO.setDocumentTypeVO(documentTypeVO);
							subTypesVOs.add(subTypesVO);

						} else {
							SubTypesVO subTypesVO = new SubTypesVO();
							subTypesVO.setSubType(subTypesDTO.getSubType());
							subTypesVO.setSubTypeCode(subTypesDTO.getSubTypeCode());
							subTypesVO.setMonth(subTypesDTO.getMonth());
							subTypesVO.setSubTypeName(subTypesDTO.getSubTypeName());
							subTypesVO.setDocumentTypeVO(documentTypeVO);
							subTypesVOs.add(subTypesVO);

						}
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
				documentTypeVO.setOrgId(documentTypeDTO.getOrgId());
			}

			//DocumentTypeMapping
			
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
			public DocumentTypeMappingVO updateCreateDocumentTypeMapping(@Valid DocumentTypeMappingDTO documentTypeMappingDTO) throws ApplicationException {
				DocumentTypeMappingVO documentTypeMappingVO = new DocumentTypeMappingVO();
				if (ObjectUtils.isNotEmpty(documentTypeMappingDTO.getId())) {
					documentTypeMappingVO = documentTypeMappingRepo.findById(documentTypeMappingDTO.getId())
							.orElseThrow(() -> new ApplicationException("Invalid DocumentTypeMapping details"));
				}

				List<MappingVO> mappingVOs = new ArrayList<>();
				if (documentTypeMappingDTO.getMappingDTO() != null) {
					for (MappingDTO mappingDTO : documentTypeMappingDTO.getMappingDTO()) {
						if (mappingDTO.getId() != null & ObjectUtils.isNotEmpty(mappingDTO.getId())) {
							MappingVO mappingVO = mappingRepo.findById(mappingDTO.getId()).get();
							mappingVO.setDocType(mappingDTO.getDocType());
							mappingVO.setSubType(mappingDTO.getSubType());
							mappingVO.setSubTypeId(mappingDTO.getSubTypeId());
							mappingVO.setSubTypeCode(mappingDTO.getSubTypeCode());
							mappingVO.setDocname(mappingDTO.getDocname());
							mappingVO.setPrefix(mappingDTO.getPrefix());
							mappingVO.setPostFinance(mappingDTO.isPostFinance());
							mappingVO.setLastNo(mappingDTO.getLastNo());
							mappingVO.setResetOnFinYear(mappingDTO.isResetOnFinYear());
							mappingVO.setDocumentTypeMappingVO(documentTypeMappingVO);
							mappingVOs.add(mappingVO);

						} else {
							MappingVO mappingVO = new MappingVO();
							mappingVO.setDocType(mappingDTO.getDocType());
							mappingVO.setSubType(mappingDTO.getSubType());
							mappingVO.setSubTypeId(mappingDTO.getSubTypeId());
							mappingVO.setSubTypeCode(mappingDTO.getSubTypeCode());
							mappingVO.setDocname(mappingDTO.getDocname());
							mappingVO.setPrefix(mappingDTO.getPrefix());
							mappingVO.setPostFinance(mappingDTO.isPostFinance());
							mappingVO.setLastNo(mappingDTO.getLastNo());
							mappingVO.setResetOnFinYear(mappingDTO.isResetOnFinYear());
							mappingVO.setDocumentTypeMappingVO(documentTypeMappingVO);
							mappingVOs.add(mappingVO);

						}
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

			}

			//ListOfValues
			
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

				List<ListOfValues1VO> listOfValues1VOs = new ArrayList<>();
				if (listOfValuesDTO.getListOfValues1DTO() != null) {
					for (ListOfValues1DTO listOfValues1DTO : listOfValuesDTO.getListOfValues1DTO()) {
						if (listOfValues1DTO.getId() != null & ObjectUtils.isNotEmpty(listOfValues1DTO.getId())) {
							ListOfValues1VO listOfValues1VO = listOfValues1Repo.findById(listOfValues1DTO.getId()).get();
							listOfValues1VO.setCode(listOfValues1DTO.getCode());
							listOfValues1VO.setSNo(listOfValues1DTO.getSNo());
							listOfValues1VO.setDescription(listOfValues1DTO.getDescription());
							listOfValues1VO.setActive(listOfValues1DTO.isActive());
							listOfValues1VO.setListOfValuesVO(listOfValuesVO);
							listOfValues1VOs.add(listOfValues1VO);

						} else {
							ListOfValues1VO listOfValues1VO = new ListOfValues1VO();
							listOfValues1VO.setCode(listOfValues1DTO.getCode());
							listOfValues1VO.setSNo(listOfValues1DTO.getSNo());
							listOfValues1VO.setDescription(listOfValues1DTO.getDescription());
							listOfValues1VO.setActive(listOfValues1DTO.isActive());
							listOfValues1VO.setListOfValuesVO(listOfValuesVO);
							listOfValues1VOs.add(listOfValues1VO);


						}
					}
				}

				getListOfValuesVOFromTypesOfValuesDTO(listOfValuesDTO, listOfValuesVO);

				listOfValuesVO.setListOfValues1VO(listOfValues1VOs);
				return listOfValuesRepo.save(listOfValuesVO);

			}
			
			private void getListOfValuesVOFromTypesOfValuesDTO(@Valid ListOfValuesDTO listOfValuesDTO,
					ListOfValuesVO listOfValuesVO) {
                   listOfValuesVO.setCode(listOfValuesDTO.getCode());		
                   listOfValuesVO.setOrgId(listOfValuesDTO.getOrgId());	
                   listOfValuesVO.setDescription(listOfValuesDTO.getDescription());				
			}

			//TermsAndCondition
			
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
			public TermsAndConditionVO updateCreateCountry(@Valid TermsAndConditionDTO termsAndConditionDTO) throws ApplicationException {
				TermsAndConditionVO termsAndConditionVO = new TermsAndConditionVO();
				if (ObjectUtils.isNotEmpty(termsAndConditionDTO.getId())) {
					termsAndConditionVO = termsAndConditionRepo.findById(termsAndConditionDTO.getId())
							.orElseThrow(() -> new ApplicationException("Invalid TermsAndCondition Details"));
				}
				getTermsAndConditionVOFromTermsAndConditionDTO(termsAndConditionDTO, termsAndConditionVO);
				return termsAndConditionRepo.save(termsAndConditionVO);
			}

			private void getTermsAndConditionVOFromTermsAndConditionDTO(
					@Valid TermsAndConditionDTO termsAndConditionDTO, TermsAndConditionVO termsAndConditionVO) {
				termsAndConditionVO.setBranch(termsAndConditionDTO.getBranch());	
				termsAndConditionVO.setTerms(termsAndConditionDTO.getTerms());		
				termsAndConditionVO.setDocumentType(termsAndConditionDTO.getDocumentType());		
				termsAndConditionVO.setPartyType(termsAndConditionDTO.getPartyType());	
				termsAndConditionVO.setOrgId(termsAndConditionDTO.getOrgId());		
			}
		
}


