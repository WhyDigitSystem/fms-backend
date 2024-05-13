package com.base.basesetup.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.basesetup.common.CommonConstant;
import com.base.basesetup.common.UserConstants;
import com.base.basesetup.dto.CityDTO;
import com.base.basesetup.dto.CompanyDTO;
import com.base.basesetup.dto.CountryDTO;
import com.base.basesetup.dto.DepartmentDTO;
import com.base.basesetup.dto.DesignationDTO;
import com.base.basesetup.dto.EmployeeDTO;
import com.base.basesetup.dto.PortDTO;
import com.base.basesetup.dto.ResponseDTO;
import com.base.basesetup.dto.StateDTO;
import com.base.basesetup.entity.CityVO;
import com.base.basesetup.entity.CompanyVO;
import com.base.basesetup.entity.CountryVO;
import com.base.basesetup.entity.DepartmentVO;
import com.base.basesetup.entity.DesignationVO;
import com.base.basesetup.entity.EmployeeVO;
import com.base.basesetup.entity.PortVO;
import com.base.basesetup.entity.StateVO;
import com.base.basesetup.service.BasicMasterService;


@RestController
@CrossOrigin
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
	public ResponseEntity<ResponseDTO> getCountryByOrgId(@RequestParam(required = false) Long id) {
		String methodName = "getCountryByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<CountryVO> countryVO = new ArrayList<>();
		try {
			countryVO = basicMasterService.getCountryByOrgId(id);
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

	@PutMapping("updateCreateCountry")
	public ResponseEntity<ResponseDTO> updateCreateCurrency(@Valid @RequestBody CountryDTO countryDTO) {
		String methodName = "updateCreateCountry()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			CountryVO countryVO = basicMasterService.updateCreateCountry(countryDTO);
			if (countryVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Country updated successfully");
				responseObjectsMap.put("countryVO", countryVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "Country not found for ID: " + countryDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "Country update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "Country update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
//-------------------------------------------------------------------------------------------------
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

	@GetMapping("getCityByOrgId")
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

	@PutMapping("updateCreateCity")
	public ResponseEntity<ResponseDTO> updateCreateCity(@Valid @RequestBody CityDTO cityDTO) {
		String methodName = "updateCreateCity()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			CityVO cityVO = basicMasterService.updateCreateCity(cityDTO);
			if (cityVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "City updated successfully");
				responseObjectsMap.put("cityVO", cityVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "City not found for ID: " + cityDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "City update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "City update failed", errorMsg);
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

	@GetMapping("getStateByOrgId")
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

	@PutMapping("updateCreateState")
	public ResponseEntity<ResponseDTO> updateCreateState(@Valid @RequestBody StateDTO stateDTO) {
		String methodName = "updateCreateState()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			StateVO stateVO = basicMasterService.updateCreateState(stateDTO);
			if (stateVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "State updated successfully");
				responseObjectsMap.put("stateVO", stateVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "State not found for ID: " + stateDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "State update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "State update failed", errorMsg);
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
	
	@PutMapping("updateCreateDepartment")
	public ResponseEntity<ResponseDTO> updateCreateDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
		String methodName = "updateCreateDepartment()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			DepartmentVO departmentVO = basicMasterService.updateCreateDepartment(departmentDTO);
			if (departmentVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Department updated successfully");
				responseObjectsMap.put("departmentVO", departmentVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "Department not found for ID: " + departmentDTO.getDepartmentId();
				responseDTO = createServiceResponseError(responseObjectsMap, "Department update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "Department update failed", errorMsg);
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
	
	
	// DESIGNATION
	
	@PutMapping("updateCreateDesignation")
	public ResponseEntity<ResponseDTO> updateCreateDesignation(@Valid @RequestBody DesignationDTO designationDTO) {
		String methodName = "updateCreateDesignation()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			DesignationVO designationVO = basicMasterService.updateCreateDesignation(designationDTO);
			if (designationVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Designation updated successfully");
				responseObjectsMap.put("designationVO", designationVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "Designation not found for ID: " + designationDTO.getDesignationId();
				responseDTO = createServiceResponseError(responseObjectsMap, "Designation update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "Designation update failed", errorMsg);
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
	public ResponseEntity<ResponseDTO> getDesignationByOrgId(@RequestParam(required = false) Long Orgid) {
		String methodName = "getDesignationByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DesignationVO> designationVO = new ArrayList<>();
		try {
			designationVO = basicMasterService.getDesignationByOrgId(Orgid);
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
	
	// EMPLOYEE_________________________________________________________________________
	
	@PutMapping("updateCreateEmployee")
	public ResponseEntity<ResponseDTO> updateCreateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		String methodName = "updateCreateDesignation()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			EmployeeVO employeeVO = basicMasterService.updateCreateEmployee(employeeDTO);
			if (employeeVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Designation updated successfully");
				responseObjectsMap.put("employeeVO", employeeVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "Employee not found for ID: " + employeeDTO.getEmployeeId();
				responseDTO = createServiceResponseError(responseObjectsMap, "Employee update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "Designation update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	// PORT
	
	@PutMapping("updateCreatePort")
	public ResponseEntity<ResponseDTO> updateCreatePort(@Valid @RequestBody PortDTO portDTO) {
		String methodName = "updateCreatePort()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			PortVO portVO = basicMasterService.updateCreatePort(portDTO);
			if (portVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "Port updated successfully");
				responseObjectsMap.put("portVO", portVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "Port not found for ID: " + portDTO.getPortId();
				responseDTO = createServiceResponseError(responseObjectsMap, "Port update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "Port update failed", errorMsg);
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
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "City updated successfully");
				responseObjectsMap.put("companyVO", companyVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "Company not found for ID: " + companyDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "Company update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "Company update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
}
