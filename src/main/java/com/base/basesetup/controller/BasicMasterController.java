package com.base.basesetup.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.basesetup.common.CommonConstant;
import com.base.basesetup.common.UserConstants;
import com.base.basesetup.dto.BranchDTO;
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
import com.base.basesetup.dto.ListOfValuesDTO;
import com.base.basesetup.dto.PartyMasterDTO;
import com.base.basesetup.dto.PartyScreeningDTO;
import com.base.basesetup.dto.PortDTO;
import com.base.basesetup.dto.RegionDTO;
import com.base.basesetup.dto.ResponseDTO;
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
import com.base.basesetup.entity.EmployeeVO;
import com.base.basesetup.entity.EventsVO;
import com.base.basesetup.entity.GstInVO;
import com.base.basesetup.entity.ListOfValuesVO;
import com.base.basesetup.entity.PartyMasterVO;
import com.base.basesetup.entity.PartyScreeningVO;
import com.base.basesetup.entity.PortVO;
import com.base.basesetup.entity.RegionVO;
import com.base.basesetup.entity.SegmentsVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.entity.TermsAndConditionVO;
import com.base.basesetup.service.BasicMasterService;

@CrossOrigin
@RestController
@RequestMapping("/api/basicMaster")
public class BasicMasterController extends BaseController {

	public static final Logger LOGGER = LoggerFactory.getLogger(BasicMasterController.class);
	
	@Autowired
	BasicMasterService basicMasterService;
	
	//Country
	
	@GetMapping("/getCountryById")
	public ResponseEntity<ResponseDTO> getCountryById(@RequestParam(required = false) Long id) {
		String methodName = "getCountryById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<CountryVO> countryVO = new ArrayList<>();
		try {
			countryVO = basicMasterService.getCountryById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Country information get successfully By Id");
			responseObjectsMap.put("countryVO", countryVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Country information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	@GetMapping("/getCountryByOrgId")
	public ResponseEntity<ResponseDTO> getCountryByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getCountryByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<CountryVO> countryVO = new ArrayList<>();
		try {
			countryVO = basicMasterService.getCountryByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Country information get successfully By OrgId");
			responseObjectsMap.put("countryVO", countryVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Country information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

//	@PutMapping("/updateCreateCountry")
//	public ResponseEntity<ResponseDTO> updateCreateCurrency(@Valid @RequestBody CountryDTO countryDTO) {
//		String methodName = "updateCreateCountry()";
//		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
//		String errorMsg = null;
//		Map<String, Object> responseObjectsMap = new HashMap<>();
//		ResponseDTO responseDTO = null;
//		try {
//			CountryVO countryVO = basicMasterService.updateCreateCountry(countryDTO);
//			if (countryVO != null) {
//				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Country updated successfully");
//				responseObjectsMap.put("countryVO", countryVO);
//				responseDTO = createServiceResponse(responseObjectsMap);
//			} else {
//				errorMsg = "Country not found for ID: " + countryDTO.getId();
//				responseDTO = createServiceResponseError(responseObjectsMap, "Country update failed", errorMsg);
//			}
//		} catch (Exception e) {
//			errorMsg = e.getMessage();
//			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
//			responseDTO = createServiceResponseError(responseObjectsMap, "Country update failed", errorMsg);
//		}
//		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
//		return ResponseEntity.ok().body(responseDTO);
//	}
	
	@PutMapping("/updateCreateCountry")
	public ResponseEntity<ResponseDTO> updateCreateCurrency(@Valid @RequestBody CountryDTO countryDTO) {
	    String methodName = "updateCreateCountry()";
	    LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
	    String errorMsg = null;
	    Map<String, Object> responseObjectsMap = new HashMap<>();
	    ResponseDTO responseDTO = null;
	    try {
	        CountryVO countryVO = basicMasterService.updateCreateCountry(countryDTO);
	        if (countryVO != null) {
	            boolean isUpdate = countryDTO.getId() != null;
	            responseObjectsMap.put(CommonConstant.STRING_MESSAGE, isUpdate ? "Country updated successfully" : "Country created successfully");
	            responseObjectsMap.put("countryVO", countryVO);
	            responseDTO = createServiceResponse(responseObjectsMap);
	        } else {
	            boolean isUpdate = countryDTO.getId() != null;
	            errorMsg = isUpdate ? "Country not found for ID: " + countryDTO.getId() : "Country creation failed";
	            responseDTO = createServiceResponseError(responseObjectsMap, isUpdate ? "Country update failed" : "Country creation failed", errorMsg);
	        }
	    } catch (Exception e) {
	        errorMsg = e.getMessage();
	        boolean isUpdate = countryDTO.getId() != null;
	        LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
	        responseDTO = createServiceResponseError(responseObjectsMap, isUpdate ? "Country update failed" : "Country creation failed", errorMsg);
	    }
	    LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
	    return ResponseEntity.ok().body(responseDTO);
	}

	
      //CITY 
	
	@GetMapping("/getCityById")
	public ResponseEntity<ResponseDTO> getCityById(@RequestParam(required = false) Long id) {
		String methodName = "getCityById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<CityVO> cityVO = new ArrayList<>();
		try {
			cityVO = basicMasterService.getCityById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "City information get successfully By Id");
			responseObjectsMap.put("cityVO", cityVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "City information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	@GetMapping("/getCityByOrgId")
	public ResponseEntity<ResponseDTO> getCityByOrgId(@RequestParam(required = false) Long orgId) {
		String methodName = "getCityByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<CityVO> cityVO = new ArrayList<>();
		try {
			cityVO = basicMasterService.getCityByOrgId(orgId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "City information get successfully By OrgId");
			responseObjectsMap.put("cityVO", cityVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "City information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);

	}

	@PutMapping("/updateCreateCity")
	public ResponseEntity<ResponseDTO> updateCreateCity(@Valid @RequestBody CityDTO cityDTO) {
		String methodName = "updateCreateCity()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			CityVO cityVO = basicMasterService.updateCreateCity(cityDTO);
			if (cityVO != null) {
	            boolean isUpdate = cityDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, isUpdate ? "City updated successfully" : "City created successfully");
				responseObjectsMap.put("cityVO", cityVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
	            boolean isUpdate = cityDTO.getId() != null;
				errorMsg = isUpdate ? "City not found for ID: " + cityDTO.getId() : "City creation failed";
				responseDTO = createServiceResponseError(responseObjectsMap, isUpdate ? "City update failed" : "City creation failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
	        boolean isUpdate = cityDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,  isUpdate ? "City update failed" : "City creation failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	
	@GetMapping("/getAllCityByState")
	public ResponseEntity<ResponseDTO> getAllCityByState(@RequestParam Long orgId,@RequestParam String state) {
		String methodName = "getAllCityByState()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<CityVO> cityVO = new ArrayList<>();
		try {
			cityVO = basicMasterService.getAllCityByState(orgId,state);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "city found by state");
			responseObjectsMap.put("cityVO", cityVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "city not found",errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}


//	State -----------------------------------------------------------------------------------
	@GetMapping("/getStateById")
	public ResponseEntity<ResponseDTO> getStateById(@RequestParam(required = false) Long id) {
		String methodName = "getStateById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<StateVO> stateVO = new ArrayList<>();
		try {
			stateVO = basicMasterService.getStateById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "State information get successfully By Id");
			responseObjectsMap.put("stateVO", stateVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "State information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	@GetMapping("/getStateByOrgId")
	public ResponseEntity<ResponseDTO> getStateByOrgId(@RequestParam(required = false) Long orgId) {
		String methodName = "getStateByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<StateVO> stateVO = new ArrayList<>();
		try {
			stateVO = basicMasterService.getStateByOrgId(orgId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "State information get successfully By OrgId");
			responseObjectsMap.put("stateVO", stateVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "State information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);

	}

	@PutMapping("/updateCreateState")
	public ResponseEntity<ResponseDTO> updateCreateState(@Valid @RequestBody StateDTO stateDTO) {
		String methodName = "updateCreateState()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			StateVO stateVO = basicMasterService.updateCreateState(stateDTO);
			if (stateVO != null) {
				 boolean isUpdate = stateDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, isUpdate ? "State updated successfully" : "State created successfully");
				responseObjectsMap.put("stateVO", stateVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				 boolean isUpdate = stateDTO.getId() != null;
				errorMsg = isUpdate?"State not found for ID: " + stateDTO.getId() : "State Creation Failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate ? "State updated failed" : "State created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			 boolean isUpdate = stateDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate ? "State updated failed" : "State created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getAllStateByCountry")
	public ResponseEntity<ResponseDTO> getAllStateByCountry(@RequestParam Long orgId,@RequestParam String country) {
		String methodName = "getAllStateByCountry()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<StateVO> stateVO = new ArrayList<>();
		try {
			stateVO = basicMasterService.getAllStateByCountry(orgId,country);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "state found by Country");
			responseObjectsMap.put("stateVO", stateVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "state not found",errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	

	
	//DEPARTMENT ____________________________________________________________________________
	
	@PutMapping("/updateCreateDepartment")
	public ResponseEntity<ResponseDTO> updateCreateDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
		String methodName = "updateCreateDepartment()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			DepartmentVO departmentVO = basicMasterService.updateCreateDepartment(departmentDTO);
			if (departmentVO != null) {
				 boolean isUpdate = departmentDTO.getId()!= null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "Department updated successfully":"Department Creation successfully");
				responseObjectsMap.put("departmentVO", departmentVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				 boolean isUpdate = departmentDTO.getId()!= null;
				errorMsg = isUpdate? "Department not found for ID: " + departmentDTO.getId(): " Department Creation failed " ;
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Department update failed":" Department Creation Failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			 boolean isUpdate = departmentDTO.getId()!= null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Department update failed":" Department Creation Failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getDepartmentById")
	public ResponseEntity<ResponseDTO> getDepartmentById(@RequestParam(required = false) Long id) {
		String methodName = "getDepartmentById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DepartmentVO> departmentVO = new ArrayList<>();
		try {
			departmentVO = basicMasterService.getDepartmentById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Department information get successfully By Id");
			responseObjectsMap.put("departmentVO", departmentVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Department information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getDepartmentByOrgId")
	public ResponseEntity<ResponseDTO> getDepartmentByOrgId(@RequestParam(required = false) Long orgId) {
		String methodName = "getDepartmentByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DepartmentVO> departmentVO = new ArrayList<>();
		try {
			departmentVO = basicMasterService.getDepartmentByOrgId(orgId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Department information get successfully By OrgId");
			responseObjectsMap.put("departmentVO", departmentVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Department information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getAllDepartmentByActive")
	public ResponseEntity<ResponseDTO> getAllDepartmentByActive(@RequestParam(required = false) Long orgid) {
		String methodName = "getAllDepartmentByActive()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DepartmentVO> departmentVO = new ArrayList<>();
		try {
			departmentVO = basicMasterService.getAllDepartmentByActive(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Department information get successfully");
			responseObjectsMap.put("departmentVO", departmentVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Department information receive failed",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	
	// DESIGNATION
	
	@PutMapping("/updateCreateDesignation")
	public ResponseEntity<ResponseDTO> updateCreateDesignation(@Valid @RequestBody DesignationDTO designationDTO) {
		String methodName = "updateCreateDesignation()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			DesignationVO designationVO = basicMasterService.updateCreateDesignation(designationDTO);
			if (designationVO != null) {
				 boolean isUpdate = designationDTO.getId()!= null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "Designation updated successfully":"Designation Created successfully");
				responseObjectsMap.put("designationVO", designationVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				 boolean isUpdate = designationDTO.getId()!= null;
				errorMsg = isUpdate? "Designation not found for ID: " + designationDTO.getId():"Designation creation failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Designation update failed":"Designation Creation Failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			 boolean isUpdate = designationDTO.getId()!= null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Designation update failed":"Designation Creation Failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getDesignationById")
	public ResponseEntity<ResponseDTO> getDesignationById(@RequestParam(required = false) Long id) {
		String methodName = "getDesignationById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DesignationVO> designationVO = new ArrayList<>();
		try {
			designationVO = basicMasterService.getDesignationById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Designation information get successfully By Id");
			responseObjectsMap.put("designationVO", designationVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Designation information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getDesignationByOrgId")
	public ResponseEntity<ResponseDTO> getDesignationByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getDesignationByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DesignationVO> designationVO = new ArrayList<>();
		try {
			designationVO = basicMasterService.getDesignationByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Designation information get successfully By OrgId");
			responseObjectsMap.put("designationVO", designationVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Designation information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getAllDesignationByActive")
	public ResponseEntity<ResponseDTO> getAllDesignationByActive(@RequestParam(required = false) Long orgid) {
		String methodName = "getAllDesignationByActive()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DesignationVO> designationVO = new ArrayList<>();
		try {
			designationVO = basicMasterService.getAllDesignationByActive(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Designation information get successfully");
			responseObjectsMap.put("designationVO", designationVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Designation information receive failed",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	// EMPLOYEE_________________________________________________________________________
	
	@PutMapping("/updateCreateEmployee")
	public ResponseEntity<ResponseDTO> updateCreateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		String methodName = "updateCreateDesignation()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			EmployeeVO employeeVO = basicMasterService.updateCreateEmployee(employeeDTO);
			if (employeeVO != null) {
				boolean isUpdate = employeeDTO.getId()!= null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "Employee updated successfully":"Employee created Successfully");
				responseObjectsMap.put("employeeVO", employeeVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = employeeDTO.getId()!= null;
				errorMsg = isUpdate? "Employee not found for ID: " + employeeDTO.getId():"Employee created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Employee update failed" : "Employee created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = employeeDTO.getId()!= null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Employee update failed" : "Employee created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getEmployeeById")
	public ResponseEntity<ResponseDTO> getEmployeeById(@RequestParam(required = false) Long id) {
		String methodName = "getEmployeeById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<EmployeeVO> employeeVO = new ArrayList<>();
		try {
			employeeVO = basicMasterService.getEmployeeById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Employee information get successfully By Id");
			responseObjectsMap.put("employeeVO", employeeVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Employee information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getEmployeeByOrgId")
	public ResponseEntity<ResponseDTO> getEmployeeByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getEmployeeByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<EmployeeVO> employeeVO = new ArrayList<>();
		try {
			employeeVO = basicMasterService.getEmployeeByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Employee information get successfully By OrgId");
			responseObjectsMap.put("employeeVO", employeeVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Employee information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	
	// PORT
	
	@PutMapping("/updateCreatePort")
	public ResponseEntity<ResponseDTO> updateCreatePort(@Valid @RequestBody PortDTO portDTO) {
		String methodName = "updateCreatePort()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			PortVO portVO = basicMasterService.updateCreatePort(portDTO);
			if (portVO != null) {
				boolean isUpdate = portDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "Port updated successfully": "Port Created Successfully");
				responseObjectsMap.put("portVO", portVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = portDTO.getId() != null;
				errorMsg = isUpdate ? "Port not found for ID: " + portDTO.getId():"Port created failed";
				responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "Port update failed" :"Port created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = portDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Port update failed" :"Port created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	

	@GetMapping("/getPortById")
	public ResponseEntity<ResponseDTO> getPortById(@RequestParam(required = false) Long id) {
		String methodName = "getPortById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PortVO> portVO = new ArrayList<>();
		try {
			portVO = basicMasterService.getPortById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Port information get successfully By Id");
			responseObjectsMap.put("portVO", portVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Port information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getPortByOrgId")
	public ResponseEntity<ResponseDTO> getPortByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getPortByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PortVO> portVO = new ArrayList<>();
		try {
			portVO = basicMasterService.getPortByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Port information get successfully By OrgId");
			responseObjectsMap.put("portVO", portVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Port information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}


//Company-----------------------------------------------------------------------------------
	@GetMapping("/getCompanyById")
	public ResponseEntity<ResponseDTO> getCompanyById(@RequestParam(required = false) Long id) {
		String methodName = "getCompanyById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<CompanyVO> companyVO = new ArrayList<>();
		try {
			companyVO = basicMasterService.getCompanyById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Company information get successfully By Id");
			responseObjectsMap.put("companyVO", companyVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Company information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getCompanyByOrgId")
	public ResponseEntity<ResponseDTO> getCompanyByOrgId(@RequestParam(required = false) Long orgId) {
		String methodName = "getCompanyByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<CompanyVO> companyVO = new ArrayList<>();
		try {
			companyVO = basicMasterService.getCompanyByOrgId(orgId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Company information get successfully By OrgId");
			responseObjectsMap.put("companyVO", companyVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Company information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);

	}
	
	@PutMapping("/updateCreateCompany")
	public ResponseEntity<ResponseDTO> updateCreateCompany(@Valid @RequestBody CompanyDTO companyDTO) {
		String methodName = "updateCreateCompany()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			CompanyVO companyVO = basicMasterService.updateCreateCompany(companyDTO);
			if (companyVO != null) {
				boolean isUpdate= companyDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate ? "Company updated successfully":"Company created successfully");
				responseObjectsMap.put("companyVO", companyVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate= companyDTO.getId() != null;
				errorMsg = isUpdate? "Company not found for ID: " + companyDTO.getId():"Company created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Company update failed":"Company created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate= companyDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Company update failed":"Company created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//Container
	
	@GetMapping("/getContainerById")
	public ResponseEntity<ResponseDTO> getContainerById(@RequestParam(required = false) Long id) {
		String methodName = "getContainerById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ContainerVO> containerVO = new ArrayList<>();
		try {
			containerVO = basicMasterService.getContainerById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Container information get successfully By Id");
			responseObjectsMap.put("containerVO", containerVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Container information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getContainerByOrgId")
	public ResponseEntity<ResponseDTO> getContainerByOrgId(@RequestParam(required = false) Long Orgid) {
		String methodName = "getContainerByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ContainerVO> containerVO = new ArrayList<>();
		try {
			containerVO = basicMasterService.getContainerByOrgId(Orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Container information get successfully By OrgId");
			responseObjectsMap.put("containerVO", containerVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Container information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateContainer")
	public ResponseEntity<ResponseDTO> updateCreateContainer(@Valid @RequestBody ContainerDTO containerDTO) {
		String methodName = "updateCreateContainer()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ContainerVO containerVO = basicMasterService.updateCreateContainer(containerDTO);
			if (containerVO != null) {
				boolean isUpdate= containerDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "Container updated successfully":"Container created successfully");
				responseObjectsMap.put("containerVO", containerVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate= containerDTO.getId() != null;
				errorMsg = isUpdate ? "container not found for ID: " + containerDTO.getId(): "Container created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate ? "Container update failed": "Container Created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate= containerDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate ? "Container update failed": "Container Created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//Events
	
	@GetMapping("/getLatestEventid")
	public ResponseEntity<ResponseDTO> getLatestEventid() {
		String methodName = "getLatestEventid()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		String eventsVO =null;
		try {
			eventsVO = basicMasterService.getLatestEventid();
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Events information get successfully By eventid");
			responseObjectsMap.put("eventDocId", eventsVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Events information receive failed By eventid",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	
	@GetMapping("/getEventsById")
	public ResponseEntity<ResponseDTO> getEventsById(@RequestParam(required = false) Long id) {
		String methodName = "getEventsById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<EventsVO> eventsVO = new ArrayList<>();
		try {
			eventsVO = basicMasterService.getEventsById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Events information get successfully By Id");
			responseObjectsMap.put("eventsVO", eventsVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Events information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getEventsByOrgId")
	public ResponseEntity<ResponseDTO> getEventsByOrgId(@RequestParam(required = false) Long Orgid) {
		String methodName = "getEventsByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<EventsVO> eventsVO = new ArrayList<>();
		try {
			eventsVO = basicMasterService.getEventsByOrgId(Orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Events information get successfully By OrgId");
			responseObjectsMap.put("eventsVO", eventsVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Events information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateEvents")
	public ResponseEntity<ResponseDTO> updateCreateEvents(@Valid @RequestBody EventsDTO eventsDTO) {
		String methodName = "updateCreateEvents()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			EventsVO eventsVO = basicMasterService.updateCreateEvents(eventsDTO);
			if (eventsVO != null) {
				boolean isUpdate = eventsDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "Events updated successfully":"Events created successfully");
				responseObjectsMap.put("eventsVO", eventsVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = eventsDTO.getId() != null;
				errorMsg = isUpdate? "Events not found for ID: " + eventsDTO.getId():"Events created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate ? "Events update failed" : "Events created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = eventsDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, isUpdate ? "Events update failed" : "Events created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
   //Segments
	
	@GetMapping("/getSegmentsById")
	public ResponseEntity<ResponseDTO> getSegmentsById(@RequestParam(required = false) Long id) {
		String methodName = "getSegmentsById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<SegmentsVO> segmentsVO = new ArrayList<>();
		try {
			segmentsVO = basicMasterService.getSegmentsById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Segments information get successfully By Id");
			responseObjectsMap.put("segmentsVO", segmentsVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Segments information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	@GetMapping("/getSegmentsByOrgId")
	public ResponseEntity<ResponseDTO> getSegmentsByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getSegmentsByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<SegmentsVO> segmentsVO = new ArrayList<>();
		try {
			segmentsVO = basicMasterService.getSegmentsByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Segments information get successfully By OrgId");
			responseObjectsMap.put("segmentsVO", segmentsVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Segments information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateSegments")
	public ResponseEntity<ResponseDTO> updateCreateSegments(@Valid @RequestBody SegmentsDTO segmentsDTO) {
		String methodName = "updateCreateSegments()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			SegmentsVO segmentsVO = basicMasterService.updateCreateSegments(segmentsDTO);
			if (segmentsVO != null) {
				boolean isUpdate = segmentsDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate ? "Segments updated successfully" : "Segments created successfully");
				responseObjectsMap.put("segmentsVO", segmentsVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = segmentsDTO.getId() != null;
				errorMsg = isUpdate ? "Segments not found for ID: " + segmentsDTO.getId(): "Segments Created failed";
				responseDTO = createServiceResponseError(responseObjectsMap, isUpdate ? "Segments update failed" : "Segments created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = segmentsDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Segments update failed" : "Segments created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//Region
	
	@GetMapping("/getRegionById")
	public ResponseEntity<ResponseDTO> getRegionById(@RequestParam(required = false) Long id) {
		String methodName = "getRegionById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<RegionVO> regionVO = new ArrayList<>();
		try {
			regionVO = basicMasterService.getRegionById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Region information get successfully By Id");
			responseObjectsMap.put("regionVO", regionVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Region information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	@GetMapping("/getRegionByOrgId")
	public ResponseEntity<ResponseDTO> getRegionByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getRegionByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<RegionVO> regionVO = new ArrayList<>();
		try {
			regionVO = basicMasterService.getRegionByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Region information get successfully By OrgId");
			responseObjectsMap.put("regionVO", regionVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "Region information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateRegion")
	public ResponseEntity<ResponseDTO> updateCreateRegion(@Valid @RequestBody RegionDTO regionDTO) {
		String methodName = "updateCreateRegion()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			RegionVO regionVO = basicMasterService.updateCreateRegion(regionDTO);
			if (regionVO != null) {
				boolean isUpdate = regionDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, isUpdate? "Region updated successfully" : "Region Created successfully");
				responseObjectsMap.put("regionVO", regionVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = regionDTO.getId() != null;
				errorMsg = isUpdate? "Region not found for ID: " + regionDTO.getId():"Region created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Region update failed" :"Region created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = regionDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "Region update failed" :"Region created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//DOCUMENTTYPE
	
//	@GetMapping("/getDocumentTypeById")
//	public ResponseEntity<ResponseDTO> getDocumentTypeById1(@RequestParam(required = false) Long id) {
//		String methodName = "getDocumentTypeById()";
//		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
//		String errorMsg = null;
//		Map<String, Object> responseObjectsMap = new HashMap<>();
//		ResponseDTO responseDTO = null;
//		List<DocumentTypeVO> documentTypeVO = new ArrayList<>();
//		try {
//			documentTypeVO = basicMasterService.getDocumentTypeById(id);
//		} catch (Exception e) {
//			errorMsg = e.getMessage();
//			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
//		}
//		if (StringUtils.isBlank(errorMsg)) {
//			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "DocumentType information get successfully By Id");
//			responseObjectsMap.put("documentTypeVO", documentTypeVO);
//			responseDTO = createServiceResponse(responseObjectsMap);
//		} else {
//			responseDTO = createServiceResponseError(responseObjectsMap, "DocumentType information receive failed By Id",
//					errorMsg);
//		}
//		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
//		return ResponseEntity.ok().body(responseDTO);
//	}
	
	@GetMapping("/getAllDocumentType")
	public ResponseEntity<ResponseDTO> getAllDocumentType() {
		String methodName = "getAllDocumentType()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DocumentTypeVO> documentTypeVO = new ArrayList<>();
		try {
			documentTypeVO = basicMasterService.getAllDocumentType();
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "DocumentType information get successfully");
			responseObjectsMap.put("documentType", documentTypeVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "DocumentType information receive failed",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	@GetMapping("/DocumentType/{id}")
	public ResponseEntity<ResponseDTO> getDocumentTypeById(@PathVariable Long id) {
		String methodName = "getDocumentTypeById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		Optional<DocumentTypeVO> documentTypeVO = null;
		try {
			documentTypeVO = basicMasterService.getDocumentTypeById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isEmpty(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "DocumentType found by ID");
			responseObjectsMap.put("documentType", documentTypeVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			errorMsg = "DocumentType not found for ID: " + id;
			responseDTO = createServiceResponseError(responseObjectsMap, "DocumentType not found", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	@GetMapping("/getDocumentTypeByOrgId")
	public ResponseEntity<ResponseDTO> getDocumentTypeByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getDocumentTypeByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DocumentTypeVO> documentTypeVO = new ArrayList<>();
		try {
			documentTypeVO = basicMasterService.getDocumentTypeByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "DocumentType information get successfully By OrgId");
			responseObjectsMap.put("documentTypeVO", documentTypeVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "DocumentType information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateDocumentType")
	public ResponseEntity<ResponseDTO> updateCreateDocumentType(@Valid @RequestBody DocumentTypeDTO documentTypeDTO) {
		String methodName = "updateCreateDocumentType()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;

		try {
			DocumentTypeVO documentTypeVO = basicMasterService.updateCreateDocumentType(documentTypeDTO);
			if (documentTypeVO != null) {
				boolean isUpdate = documentTypeDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "DocumentType updated successfully":"DocumentType created successfully");
				responseObjectsMap.put("documentTypeVO", documentTypeVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = documentTypeDTO.getId() != null;
				errorMsg = isUpdate? "DocumentType not found for ID: " + documentTypeDTO.getId(): "DocumentType created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "DocumentType update failed" : "DocumentType created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = documentTypeDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "DocumentType update failed" : "DocumentType created fsiled", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//Branch Document-Type Mapping
	
	@GetMapping("/getDocumentTypeMappingById")
	public ResponseEntity<ResponseDTO> getDocumentTypeMappingById(@RequestParam(required = false) Long id) {
		String methodName = "getDocumentTypeMappingById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DocumentTypeMappingVO> documentTypeMappingVO = new ArrayList<>();
		try {
			documentTypeMappingVO = basicMasterService.getDocumentTypeMappingById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "DocumentTypeMapping information get successfully By Id");
			responseObjectsMap.put("documentTypeMappingVO", documentTypeMappingVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "DocumentTypeMapping information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getDocumentTypeMappingByOrgId")
	public ResponseEntity<ResponseDTO> getDocumentTypeMappingByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getDocumentTypeMappingByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DocumentTypeMappingVO> documentTypeMappingVO = new ArrayList<>();
		try {
			documentTypeMappingVO = basicMasterService.getDocumentTypeMappingByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "DocumentTypeMapping information get successfully By OrgId");
			responseObjectsMap.put("documentTypeMappingVO", documentTypeMappingVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "DocumentTypeMapping information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	

	@PutMapping("/updateCreateDocumentTypeMapping")
	public ResponseEntity<ResponseDTO> updateCreateDocumentTypeMapping(@Valid @RequestBody DocumentTypeMappingDTO documentTypeMappingDTO) {
		String methodName = "updateCreateDocumentTypeMapping()";

		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;

		try {
			DocumentTypeMappingVO documentTypeMappingVO = basicMasterService.updateCreateDocumentTypeMapping(documentTypeMappingDTO);
			if (documentTypeMappingVO != null) {
				boolean isUpdate = documentTypeMappingDTO.getId() != null; 
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "DocumentTypeMapping updated successfully" : "DocumentTypeMapping created successfully");
				responseObjectsMap.put("documentTypeMappingVO", documentTypeMappingVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = documentTypeMappingDTO.getId() != null; 
				errorMsg = isUpdate? "DocumentTypeMapping not found for ID: " + documentTypeMappingDTO.getId() : "DocumentTypeMapping created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "DocumentTypeMapping update failed" : "DocumentTypeMapping created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = documentTypeMappingDTO.getId() != null; 
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "DocumentTypeMapping update failed" : "DocumentTypeMapping created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//ListOfValues
	
	@GetMapping("/getListOfValuesById")
	public ResponseEntity<ResponseDTO> getListOfValuesById(@RequestParam(required = false) Long id) {
		String methodName = "getListOfValuesById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ListOfValuesVO> listOfValuesVO = new ArrayList<>();
		try {
			listOfValuesVO = basicMasterService.getListOfValuesById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "listOfValues information get successfully By Id");
			responseObjectsMap.put("listOfValuesVO", listOfValuesVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "listOfValues information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getListOfValuesByOrgId")
	public ResponseEntity<ResponseDTO> getListOfValuesByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getListOfValuesByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ListOfValuesVO> listOfValuesVO = new ArrayList<>();
		try {
			listOfValuesVO = basicMasterService.getListOfValuesByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "listOfValues information get successfully By OrgId");
			responseObjectsMap.put("listOfValuesVO", listOfValuesVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "listOfValues information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateListOfValues")
	public ResponseEntity<ResponseDTO> updateCreateListOfValues(@Valid @RequestBody ListOfValuesDTO listOfValuesDTO) {
		String methodName = "updateCreateListOfValues()";

		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;

		try {
			ListOfValuesVO listOfValuesVO = basicMasterService.updateCreateListOfValues(listOfValuesDTO);
			if (listOfValuesVO != null) {
				boolean isUpdate = listOfValuesDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "ListOfValues updated successfully" : "ListOfValues created successfully");
				responseObjectsMap.put("listOfValuesVO", listOfValuesVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = listOfValuesDTO.getId() != null;
				errorMsg = isUpdate ? "ListOfValues not found for ID: " + listOfValuesDTO.getId(): "ListOfValues created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "ListOfValues update failed" : "ListOfValues created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = listOfValuesDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "ListOfValues update failed" : "ListOfValues created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//TermsAndCondition
	
	@GetMapping("/getTermsAndConditionById")
	public ResponseEntity<ResponseDTO> getTermsAndConditionById(@RequestParam(required = false) Long id) {
		String methodName = "getTermsAndConditionById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<TermsAndConditionVO> termsAndConditionVO = new ArrayList<>();
		try {
			termsAndConditionVO = basicMasterService.getTermsAndConditionById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "TermsAndCondition information get successfully By Id");
			responseObjectsMap.put("termsAndConditionVO", termsAndConditionVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "TermsAndCondition information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getTermsAndConditionByOrgId")
	public ResponseEntity<ResponseDTO> getTermsAndConditionByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getTermsAndConditionByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<TermsAndConditionVO> termsAndConditionVO = new ArrayList<>();
		try {
			termsAndConditionVO = basicMasterService.getTermsAndConditionByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "TermsAndCondition information get successfully By OrgId");
			responseObjectsMap.put("termsAndConditionVO", termsAndConditionVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "TermsAndCondition information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	@PutMapping("/updateCreateTermsAndCondition")
	public ResponseEntity<ResponseDTO> updateCreateTermsAndCondition(@Valid @RequestBody TermsAndConditionDTO termsAndConditionDTO) {
		String methodName = "updateCreateTermsAndCondition()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			TermsAndConditionVO termsAndConditionVO = basicMasterService.updateCreateCountry(termsAndConditionDTO);
			if (termsAndConditionVO != null) {
				boolean isUpdate = termsAndConditionDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "TermsAndCondition updated successfully" : "TermsAndCondition created Successfully");
				responseObjectsMap.put("termsAndConditionVO", termsAndConditionVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = termsAndConditionDTO.getId() != null;
				errorMsg = isUpdate ? "TermsAndCondition not found for ID: " + termsAndConditionDTO.getId() :"TermsAndCondition crested failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "TermsAndCondition updated failed" :"TermsAndCondition created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = termsAndConditionDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "TermsAndCondition updated failed" :"TermsAndCondition created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	
	//GSTIN
	
	@GetMapping("/getGstInById")
	public ResponseEntity<ResponseDTO> getGstInById(@RequestParam(required = false) Long id) {
		String methodName = "getGstInById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<GstInVO> gstInVO = new ArrayList<>();
		try {
			gstInVO = basicMasterService.getGstInById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "GstIn information get successfully By Id");
			responseObjectsMap.put("gstInVO", gstInVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "GstIn information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getGstInByOrgId")
	public ResponseEntity<ResponseDTO> getGstInByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getGstInByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<GstInVO> gstInVO = new ArrayList<>();
		try {
			gstInVO = basicMasterService.getGstInByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "GstIn information get successfully By OrgId");
			responseObjectsMap.put("gstInVO", gstInVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "GstIn information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateGstIn")
	public ResponseEntity<ResponseDTO> updateCreateGstIn(@Valid @RequestBody GstInDTO gstInDTO) {
		String methodName = "updateCreateGstIn()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			GstInVO gstInVO = basicMasterService.updateCreateGstIn(gstInDTO);
			if (gstInVO != null) {
				boolean isUpdate = gstInDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "GstIn updated successfully" : "GstIn created successfully");
				responseObjectsMap.put("gstInVO", gstInVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = gstInDTO.getId() != null;
				errorMsg = isUpdate? "GstIn not found for ID: " + gstInDTO.getId() : "GstIn created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "GstIn update failed" : "GstIn created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = gstInDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "GstIn update failed" : "GstIn created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//PartyScreening
	
	@GetMapping("/getPartyScreeningById")
	public ResponseEntity<ResponseDTO> getPartyScreeningById(@RequestParam(required = false) Long id) {
		String methodName = "getPartyScreeningById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PartyScreeningVO> partyScreeningVO = new ArrayList<>();
		try {
			partyScreeningVO = basicMasterService.getPartyScreeningById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PartyScreening information get successfully By Id");
			responseObjectsMap.put("partyScreeningVO", partyScreeningVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PartyScreening information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getPartyScreeningByOrgId")
	public ResponseEntity<ResponseDTO> getPartyScreeningByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getPartyScreeningByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PartyScreeningVO> partyScreeningVO = new ArrayList<>();
		try {
			partyScreeningVO = basicMasterService.getPartyScreeningByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PartyScreening information get successfully By OrgId");
			responseObjectsMap.put("partyScreeningVO", partyScreeningVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PartyScreening information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreatePartyScreening")
	public ResponseEntity<ResponseDTO> updateCreatePartyScreening(@Valid @RequestBody PartyScreeningDTO partyScreeningDTO) {
		String methodName = "updateCreatePartyScreening()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		     try {
			PartyScreeningVO partyScreeningVO = basicMasterService.updateCreatePartyScreening(partyScreeningDTO);
			if (partyScreeningVO != null) {
				boolean isUpdate = partyScreeningDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "PartyScreening updated successfully" :"PartyScreening created successfully");
				responseObjectsMap.put("partyScreeningVO", partyScreeningVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = partyScreeningDTO.getId() != null;
				errorMsg = isUpdate ? "PartyScreening not found for ID: " + partyScreeningDTO.getId() : "PartyScreening created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "PartyScreening update failed" : "PartyScreening created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = partyScreeningDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "PartyScreening update failed" : "PartyScreening created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//PartyMaster
	
	@GetMapping("/getPartyMasterById")
	public ResponseEntity<ResponseDTO> getPartyMasterById(@RequestParam(required = false) Long id) {
		String methodName = "getPartyMasterById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PartyMasterVO> partyMasterVO = new ArrayList<>();
		try {
			partyMasterVO = basicMasterService.getPartyMasterById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PartyMaster information get successfully By Id");
			responseObjectsMap.put("partyMasterVO", partyMasterVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PartyMaster information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getPartyMasterByOrgId")
	public ResponseEntity<ResponseDTO> getPartyMasterByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getPartyMasterByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PartyMasterVO> partyMasterVO = new ArrayList<>();
		try {
			partyMasterVO = basicMasterService.getPartyMasterByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PartyMaster information get successfully By OrgId");
			responseObjectsMap.put("partyMasterVO", partyMasterVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PartyMaster information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreatePartyMaster")
	public ResponseEntity<ResponseDTO> updateCreatePartyMaster(@Valid @RequestBody PartyMasterDTO partyMasterDTO) {
		String methodName = "updateCreatePartyMaster()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;	
		     try {
		    	 PartyMasterVO partyMasterVO = basicMasterService.updateCreatePartyMaster(partyMasterDTO);
			if (partyMasterVO != null) {
				boolean isUpdate = partyMasterDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "PartyMaster updated successfully" : "PartyMaster created Successfully");
				responseObjectsMap.put("partyMasterVO", partyMasterVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = partyMasterDTO.getId() != null;
				errorMsg = isUpdate? "PartyMaster not found for ID: " + partyMasterDTO.getId(): "PartyMaster created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "PartyMaster update failed" : "PartyMaster Created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = partyMasterDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "PartyMaster update failed" : "PartyMaster Created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//BRANCH
	
	@GetMapping("/getBranchById")
	public ResponseEntity<ResponseDTO> getBranchById(@RequestParam(required = false) Long id) {
		String methodName = "getBranchById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<BranchVO> branchVO = new ArrayList<>();
		try {
			branchVO = basicMasterService.getBranchById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Branch information get successfully By Id");
			responseObjectsMap.put("branchVO", branchVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "BranchVO information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getBranchByOrgId")
	public ResponseEntity<ResponseDTO> getBranchByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getBranchByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<BranchVO> branchVO = new ArrayList<>();
		try {
			branchVO = basicMasterService.getBranchByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Branch information get successfully By OrgId");
			responseObjectsMap.put("branchVO", branchVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "BranchVO information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateBranch")
	public ResponseEntity<ResponseDTO> updateCreateBranch(@Valid @RequestBody BranchDTO branchDTO) {
		String methodName = "updateCreateBranch()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;	
		     try {
		    	 BranchVO branchVO = basicMasterService.updateCreateBranch(branchDTO);
			if (branchVO != null) {
				boolean isUpdate = branchDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "Branch updated successfully" : "Branch created successfully");
				responseObjectsMap.put("branchVO", branchVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = branchDTO.getId() != null;
				errorMsg =isUpdate? "Branch not found for ID: " + branchDTO.getId() : "Branch created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Branch update failed" : "Branch created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = branchDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "Branch update failed" : "Branch created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
}
