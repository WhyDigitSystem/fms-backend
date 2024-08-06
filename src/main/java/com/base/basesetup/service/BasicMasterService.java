package com.base.basesetup.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.base.basesetup.dto.BranchDTO;
import com.base.basesetup.dto.CityDTO;
import com.base.basesetup.dto.CompanyDTO;
import com.base.basesetup.dto.ContainerDTO;
import com.base.basesetup.dto.CountryDTO;
import com.base.basesetup.dto.DepartmentDTO;
import com.base.basesetup.dto.DesignationDTO;
import com.base.basesetup.dto.DocumentTypeDTO;
import com.base.basesetup.dto.DocumentTypeMappingDTO;
import com.base.basesetup.dto.DocumentTypesDTO;
import com.base.basesetup.dto.DocumentTypesMappingDTO;
import com.base.basesetup.dto.EmployeeDTO;
import com.base.basesetup.dto.EventsDTO;
import com.base.basesetup.dto.FinancialYearDTO;
import com.base.basesetup.dto.GstInDTO;
import com.base.basesetup.dto.ListOfValuesDTO;
import com.base.basesetup.dto.PartyMasterDTO;
import com.base.basesetup.dto.PartyScreeningDTO;
import com.base.basesetup.dto.PortDTO;
import com.base.basesetup.dto.RegionDTO;
import com.base.basesetup.dto.ScreenDTO;
import com.base.basesetup.dto.ScreenVO;
import com.base.basesetup.dto.SegmentsDTO;
import com.base.basesetup.dto.StateDTO;
import com.base.basesetup.dto.TermsAndConditionDTO;
import com.base.basesetup.entity.BranchVO;
import com.base.basesetup.entity.CityVO;
import com.base.basesetup.entity.CompanyVO;
import com.base.basesetup.entity.ContainerVO;
import com.base.basesetup.entity.CountryVO;
import com.base.basesetup.entity.DepartmentVO;
import com.base.basesetup.entity.DesignationVO;
import com.base.basesetup.entity.DocumentTypeMappingVO;
import com.base.basesetup.entity.DocumentTypeVO;
import com.base.basesetup.entity.DocumentTypesMappingVO;
import com.base.basesetup.entity.DocumentTypesVO;
import com.base.basesetup.entity.EmployeeVO;
import com.base.basesetup.entity.EventsVO;
import com.base.basesetup.entity.FinancialYearVO;
import com.base.basesetup.entity.GstInVO;
import com.base.basesetup.entity.ListOfValuesVO;
import com.base.basesetup.entity.PartyMasterVO;
import com.base.basesetup.entity.PartyScreeningVO;
import com.base.basesetup.entity.PortVO;
import com.base.basesetup.entity.RegionVO;
import com.base.basesetup.entity.SegmentsVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.entity.TermsAndConditionVO;
import com.base.basesetup.exception.ApplicationException;

@Service
public interface BasicMasterService {

	// Country

	List<CountryVO> getCountryById(Long id);

	List<CountryVO> getCountryByOrgId(Long orgid);

	CountryVO updateCreateCountry(@Valid CountryDTO countryDTO) throws ApplicationException;

	// City

	List<CityVO> getCityById(Long id);

	List<CityVO> getCityByOrgId(Long orgId);

	CityVO updateCreateCity(@Valid CityDTO cityDTO) throws ApplicationException;

	List<CityVO> getAllCityByState(Long orgId, String state);

	// State

	List<StateVO> getStateById(Long id);

	List<StateVO> getStateByOrgId(Long orgId);

	StateVO updateCreateState(@Valid StateDTO stateDTO) throws ApplicationException;

	List<StateVO> getAllStateByCountry(Long orgId, String country);

	// Department

	DepartmentVO updateCreateDepartment(@Valid DepartmentDTO departmentDTO) throws ApplicationException;

	List<DepartmentVO> getDepartmentById(Long id);

	List<DepartmentVO> getDepartmentByOrgId(Long orgId);

	List<DepartmentVO> getAllDepartmentByActive(Long orgid);

	// Designation

	DesignationVO updateCreateDesignation(@Valid DesignationDTO designationDTO) throws ApplicationException;

	List<DesignationVO> getDesignationById(Long id);

	List<DesignationVO> getDesignationByOrgId(Long orgid);

	List<DesignationVO> getAllDesignationByActive(Long orgid);

	// Employee

	List<EmployeeVO> getEmployeeById(Long id);

	EmployeeVO updateCreateEmployee(@Valid EmployeeDTO employeeDTO) throws ApplicationException;

	List<EmployeeVO> getEmployeeByOrgId(Long orgid);

	// Port

	PortVO updateCreatePort(@Valid PortDTO portDTO) throws ApplicationException;

	List<PortVO> getPortById(Long id);

	// Company

	List<CompanyVO> getCompanyById(Long id);

	List<CompanyVO> getCompanyByOrgId(Long orgId);

	CompanyVO updateCreateCompany(@Valid CompanyDTO companyDTO) throws ApplicationException;

	// Container

	List<ContainerVO> getContainerById(Long id);

	List<ContainerVO> getContainerByOrgId(Long orgid);

	ContainerVO updateCreateContainer(@Valid ContainerDTO containerDTO) throws ApplicationException;

	// Events

	String getLatestEventid();

	List<EventsVO> getEventsById(Long id);

	List<EventsVO> getEventsByOrgId(Long orgid);

	EventsVO updateCreateEvents(@Valid EventsDTO eventsDTO) throws ApplicationException;

	// Segments

	List<SegmentsVO> getSegmentsById(Long id);

	List<SegmentsVO> getSegmentsByOrgId(Long orgid);

	SegmentsVO updateCreateSegments(@Valid SegmentsDTO segmentsDTO) throws ApplicationException;

	// Region

	List<RegionVO> getRegionById(Long id);

	List<RegionVO> getRegionByOrgId(Long orgid);

	RegionVO updateCreateRegion(@Valid RegionDTO regionDTO) throws ApplicationException;

	List<PortVO> getPortByOrgId(Long orgid);

	// DocumentType

//	List<DocumentTypeVO> getDocumentTypeById(Long id);

	List<DocumentTypeVO> getAllDocumentType();

	Optional<DocumentTypeVO> getDocumentTypeById(Long id);

	List<DocumentTypeVO> getDocumentTypeByOrgId(Long orgid);

	DocumentTypeVO updateCreateDocumentType(@Valid DocumentTypeDTO documentTypeDTO) throws ApplicationException;

	// DocumentTypeMapping

	List<DocumentTypeMappingVO> getDocumentTypeMappingById(Long id);

	List<DocumentTypeMappingVO> getDocumentTypeMappingByOrgId(Long orgid);

	DocumentTypeMappingVO updateCreateDocumentTypeMapping(@Valid DocumentTypeMappingDTO documentTypeMappingDTO)
			throws ApplicationException;

	// ListOfValues

	List<ListOfValuesVO> getListOfValuesById(Long id);

	List<ListOfValuesVO> getListOfValuesByOrgId(Long orgid);

	ListOfValuesVO updateCreateListOfValues(@Valid ListOfValuesDTO listOfValuesDTO) throws ApplicationException;

	// TermsOfCondition

	List<TermsAndConditionVO> getTermsAndConditionById(Long id);

	List<TermsAndConditionVO> getTermsAndConditionByOrgId(Long orgid);

	TermsAndConditionVO updateCreateCountry(@Valid TermsAndConditionDTO termsAndConditionDTO)
			throws ApplicationException;

	// GstIn

	List<GstInVO> getGstInById(Long id);

	List<GstInVO> getGstInByOrgId(Long orgid);

	GstInVO updateCreateGstIn(@Valid GstInDTO gstInDTO) throws ApplicationException;

	// PartyScreening

	List<PartyScreeningVO> getPartyScreeningById(Long id);

	List<PartyScreeningVO> getPartyScreeningByOrgId(Long orgid);

	PartyScreeningVO updateCreatePartyScreening(@Valid PartyScreeningDTO partyScreeningDTO) throws ApplicationException;

	// PartyMaster

	List<PartyMasterVO> getPartyMasterById(Long id);

	List<PartyMasterVO> getPartyMasterByOrgId(Long orgid);

	PartyMasterVO updateCreatePartyMaster(@Valid PartyMasterDTO partyMasterDTO) throws ApplicationException;

	// BRANCH

	List<BranchVO> getBranchById(Long id);

	List<BranchVO> getBranchByOrgId(Long orgid);

	BranchVO updateCreateBranch(@Valid BranchDTO branchDTO) throws ApplicationException;

	// Screen

	List<ScreenVO> getScreenById(Long id);

	List<ScreenVO> getScreenByOrgId(Long orgid);

	ScreenVO updateCreateScreen(@Valid ScreenDTO screenDTO) throws ApplicationException;

	Set<Object[]> getAllScreenCode();


	// DocumentTypes

	List<DocumentTypesVO> getDocumentTypesByOrgId(Long orgid);

	List<DocumentTypesVO> getDocumentTypesById(Long id);

	DocumentTypesVO updateCreateDocumentTypes(@Valid DocumentTypesDTO documentTypesDTO) throws ApplicationException;

	//DocumentTypesMapping
	
	List<DocumentTypesMappingVO> getDocumentTypesMappingById(Long id);

	List<DocumentTypesMappingVO> getDocumentTypesMappingByOrgId(Long orgid);

	DocumentTypesMappingVO updateCreateDocumentTypesMapping(@Valid DocumentTypesMappingDTO documentTypesMappingDTO) throws ApplicationException;

	List<Map<String, Object>> getAllDocumentTypesMappingDetailsByDocumentType(String branch,String branchCode,String finYr,Long orgId,String finyrId);
	
//	Financial Year
	List<FinancialYearVO> getFinancialYearById(Long id);

	List<FinancialYearVO> getFinancialYearByOrgId(Long orgid);

//	FinancialYearVO createFinancial(FinancialYearVO finyr);
//	Optional<FinancialYearVO> updateFinancial(FinancialYearVO finyr);

	FinancialYearVO updateCreateFinancialYear(@Valid FinancialYearDTO financialYearDTO) throws ApplicationException;

	Set<Object[]> getFinyrAndFinyrIdByOrgId(Long orgId);

	
	
	
}
