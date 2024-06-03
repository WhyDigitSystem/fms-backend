package com.base.basesetup.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.basesetup.common.CommonConstant;
import com.base.basesetup.common.UserConstants;
import com.base.basesetup.dto.CompanySetupDTO;
import com.base.basesetup.dto.ResponseDTO;
import com.base.basesetup.entity.CompanySetupVO;
import com.base.basesetup.service.CompanySetupService;

@CrossOrigin
@RestController
@RequestMapping("api/company")
public class CompanySetup extends BaseController {

	public static final Logger LOGGER = LoggerFactory.getLogger(BasicMasterController.class);

	@Autowired
	private CompanySetupService companySetupService;

	@PutMapping("/updateCreateCompanySetup")
	public ResponseEntity<ResponseDTO> updateCreateCompanySetup(@Valid @RequestBody CompanySetupDTO companySetupDTO) {
		String methodName = "updateCreateCompanySetup()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			CompanySetupVO companySetupVO = companySetupService.updateCreateCompanySetup(companySetupDTO);
			if (companySetupVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "companySetup updated successfully");
				responseObjectsMap.put("companySetupVO", companySetupVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "companySetup not found for ID: " + companySetupDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "companySetup update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "companySetup update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
}