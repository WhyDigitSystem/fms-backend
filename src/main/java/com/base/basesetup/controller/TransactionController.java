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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.basesetup.common.CommonConstant;
import com.base.basesetup.common.UserConstants;
import com.base.basesetup.dto.ResponseDTO;
import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.entity.ShipmentAOVO;
import com.base.basesetup.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping("/api/Transaction")
public class TransactionController extends BaseController  {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(BasicMasterController.class);

	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/getShipmentAOById")
	public ResponseEntity<ResponseDTO> getShipmentAOById(@RequestParam(required = false) Long id) {
		String methodName = "getShipmentAOById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
		try {
			shipmentAOVO = transactionService.getShipmentAOById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "ShipmentAO information get successfully By Id");
			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "ShipmentAO information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getShipmentAOByOrgId")
	public ResponseEntity<ResponseDTO> getShipmentAOByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getShipmentAOByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
		try {
			shipmentAOVO = transactionService.getShipmentAOByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentAO information get successfully By OrgId");
			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentAO information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreateShipmentAO")
	public ResponseEntity<ResponseDTO> updateCreateShipmentAO(@Valid @RequestBody ShipmentAODTO shipmentAODTO) {
		String methodName = "updateCreateShipmentAO()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ShipmentAOVO shipmentAOVO = transactionService.updateCreateShipmentAO(shipmentAODTO);
			if (shipmentAOVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentAO updated successfully");
				responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "shipmentAO not found for ID: " + shipmentAODTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "shipmentAO update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentAO update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	

}
