package com.base.basesetup.service;

import java.util.List;

import javax.validation.Valid;

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
import com.base.basesetup.dto.PortDTO;
import com.base.basesetup.dto.RegionDTO;
import com.base.basesetup.dto.SegmentsDTO;
import com.base.basesetup.dto.StateDTO;
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
import com.base.basesetup.entity.PortVO;
import com.base.basesetup.entity.RegionVO;
import com.base.basesetup.entity.SegmentsVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.exception.ApplicationException;

@Service
public interface BasicMasterService {

	//Country
	
	List<CountryVO> getCountryById(Long id);

	List<CountryVO> getCountryByOrgId(Long id);

	CountryVO updateCreateCountry(@Valid CountryDTO countryDTO) throws ApplicationException;
   
	//City

	List<CityVO> getCityById(Long id);

	List<CityVO> getCityByOrgId(Long orgId);

	CityVO updateCreateCity(@Valid CityDTO cityDTO) throws ApplicationException;
	
	List<CityVO> getAllCityByState(Long orgId, String state);

  //State
	
	List<StateVO> getStateById(Long id);

	List<StateVO> getStateByOrgId(Long orgId);

	StateVO updateCreateState(@Valid StateDTO stateDTO) throws ApplicationException;
	
	List<StateVO> getAllStateByCountry(Long orgId, String country);
	
	//Department

	DepartmentVO updateCreateDepartment(@Valid DepartmentDTO departmentDTO) throws ApplicationException;
	
	List<DepartmentVO> getDepartmentById(Long id);

	List<DepartmentVO> getDepartmentByOrgId(Long orgId);

	// Designation

	DesignationVO updateCreateDesignation(@Valid DesignationDTO designationDTO) throws ApplicationException;

	List<DesignationVO> getDesignationById(Long id);

	List<DesignationVO> getDesignationByOrgId(Long orgid);
	
	// Employee
	
	List<EmployeeVO> getEmployeeById(Long id);
	
	EmployeeVO updateCreateEmployee(@Valid EmployeeDTO employeeDTO) throws ApplicationException;

	List<EmployeeVO> getEmployeeByOrgId(Long orgid);
	
	//Port
	
	PortVO updateCreatePort(@Valid PortDTO portDTO) throws ApplicationException;

	List<PortVO> getPortById(Long id);


    //Company

	List<CompanyVO> getCompanyById(Long id);

	List<CompanyVO> getCompanyByOrgId(Long orgId);

	CompanyVO updateCreateCompany(@Valid CompanyDTO companyDTO) throws ApplicationException;
	
	//Container

	List<ContainerVO> getContainerById(Long id);

	List<ContainerVO> getContainerByOrgId(Long orgid);

	ContainerVO updateCreateContainer(@Valid ContainerDTO containerDTO) throws ApplicationException;
	
	//Events

	List<EventsVO> getEventsById(Long id);

	List<EventsVO> getEventsByOrgId(Long orgid);

	EventsVO updateCreateEvents(@Valid EventsDTO eventsDTO) throws ApplicationException;
	
	//Segments

	List<SegmentsVO> getSegmentsById(Long id);

	List<SegmentsVO> getSegmentsByOrgId(Long orgid);

	SegmentsVO updateCreateSegments(@Valid SegmentsDTO segmentsDTO) throws ApplicationException;

	//Region

	List<RegionVO> getRegionById(Long id);

	List<RegionVO> getRegionByOrgId(Long orgid);

	RegionVO updateCreateRegion(@Valid RegionDTO regionDTO) throws ApplicationException;

	List<PortVO> getPortByOrgId(Long orgid);

	//DocumentType
	
	List<DocumentTypeVO> getDocumentTypeById(Long id);

	List<DocumentTypeVO> getDocumentTypeByOrgId(Long orgid);
	
	DocumentTypeVO updateCreateDocumentType(@Valid DocumentTypeDTO documentTypeDTO) throws ApplicationException;

	//DocumentTypeMapping

	List<DocumentTypeMappingVO> getDocumentTypeMappingById(Long id);

	List<DocumentTypeMappingVO> getDocumentTypeMappingByOrgId(Long orgid);

	DocumentTypeMappingVO updateCreateDocumentTypeMapping(@Valid DocumentTypeMappingDTO documentTypeMappingDTO) throws ApplicationException;
	

}
