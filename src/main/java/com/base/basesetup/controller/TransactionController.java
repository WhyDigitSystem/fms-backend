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
import com.base.basesetup.dto.MasterAirWayBillDTO;
import com.base.basesetup.dto.ResponseDTO;
import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.dto.ShipmentFollowUpDTO;
import com.base.basesetup.entity.MasterAirWayBillVO;
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
	
 // ShipmentFollowUp
	
	@GetMapping("/getShipmentFollowUpById")
	public ResponseEntity<ResponseDTO> getShipmentFollowUpById(@RequestParam(required = false) Long id) {
		String methodName = "getShipmentFollowUpById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
		try {
			shipmentAOVO = transactionService.getShipmentFollowUpById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "ShipmentFollowup information get successfully By Id");
			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "ShipmentFollowup information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getShipmentFollowUpByOrgId")
	public ResponseEntity<ResponseDTO> getShipmentFollowUpByOrgId(@RequestParam(required = false) Long orgId) {
		String methodName = "getShipmentFollowUpByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
		try {
			shipmentAOVO = transactionService.getShipmentFollowUpByOrgId(orgId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentFollowup information get successfully By OrgId");
			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentFollowup information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreateShipmentFollowUp")
	public ResponseEntity<ResponseDTO> updateCreateShipmentFollowUp(@Valid @RequestBody ShipmentFollowUpDTO shipmentFollowUpDTO) {
		String methodName = "updateCreateShipmentFollowUp()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ShipmentAOVO shipmentAOVO = transactionService.updateCreateShipmentFollowUp(shipmentFollowUpDTO);
			if (shipmentAOVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentFollowup updated successfully");
				responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "shipmentAO not found for ID: " + shipmentFollowUpDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "shipmentFollowup update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentFollowup update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getShipmentFollowUpByDocId")
	public ResponseEntity<ResponseDTO> getShipmentFollowUpByDocId(@RequestParam(required = false) String docId) {
		String methodName = "getShipmentFollowUpByDocId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		ShipmentAOVO shipmentAOVO = new ShipmentAOVO();
		try {
			shipmentAOVO = transactionService.getShipmentFollowUpByDocId(docId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentFollowup information get successfully By DocId");
			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentFollowup information receive failed By DocId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//MasterAirWayBill
	
	@GetMapping("/getMasterAirWayBillById")
	public ResponseEntity<ResponseDTO> getMasterAirWayBillById(@RequestParam(required = false) Long id) {
		String methodName = "getMasterAirWayBillById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<MasterAirWayBillVO> masterAirWayBillVO = new ArrayList<>();
		try {
			masterAirWayBillVO = transactionService.getMasterAirWayBillById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "MasterAirWayBill information get successfully By Id");
			responseObjectsMap.put("masterAirWayBillVO", masterAirWayBillVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "MasterAirWayBill information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getMasterAirWayBillByOrgId")
	public ResponseEntity<ResponseDTO> getMasterAirWayBillByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getMasterAirWayBillByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<MasterAirWayBillVO> masterAirWayBillVO = new ArrayList<>();
		try {
			masterAirWayBillVO = transactionService.getMasterAirWayBillByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "MasterAirWayBill information get successfully By orgId");
			responseObjectsMap.put("masterAirWayBillVO", masterAirWayBillVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "MasterAirWayBill information receive failed By orgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreateMasterAirWayBill")
	public ResponseEntity<ResponseDTO> updateCreateMasterAirWayBill(@Valid @RequestBody MasterAirWayBillDTO masterAirWayBillDTO) {
		String methodName = "updateCreateMasterAirWayBill()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			MasterAirWayBillVO masterAirWayBillVO = transactionService.updateCreateMasterAirWayBill(masterAirWayBillDTO);
			if (masterAirWayBillVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "MasterAirWayBill updated successfully");
				responseObjectsMap.put("masterAirWayBillVO", masterAirWayBillVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "MasterAirWayBill not found for ID: " + masterAirWayBillDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "MasterAirWayBill update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "MasterAirWayBill update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

}
