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
import com.base.basesetup.dto.AdvanceCanAiDTO;
import com.base.basesetup.dto.ContainerAllocationSODTO;
import com.base.basesetup.dto.MasterAirWayBillDTO;
import com.base.basesetup.dto.PreAlertAIDTO;
import com.base.basesetup.dto.PreAlertSIDTO;
import com.base.basesetup.dto.ResponseDTO;
import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.dto.ShipmentAOFollowUpDTO;
import com.base.basesetup.dto.ShipmentSODTO;
import com.base.basesetup.dto.ShipmentSOFollowUpDTO;
import com.base.basesetup.entity.AdvanceCanAiVO;
import com.base.basesetup.entity.ContainerAllocationSOVO;
import com.base.basesetup.entity.MasterAirWayBillVO;
import com.base.basesetup.entity.PreAlertAIVO;
import com.base.basesetup.entity.PreAlertSIVO;
import com.base.basesetup.entity.ShipmentAOVO;
import com.base.basesetup.entity.ShipmentSOVO;
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
	
	@GetMapping("/getShipmentAOFollowUpById")
	public ResponseEntity<ResponseDTO> getShipmentAOFollowUpById(@RequestParam(required = false) Long id) {
		String methodName = "getShipmentAOFollowUpById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
		try {
			shipmentAOVO = transactionService.getShipmentAOFollowUpById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "ShipmentAOFollowup information get successfully By Id");
			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "ShipmentAOFollowup information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getShipmentAOFollowUpByOrgId")
	public ResponseEntity<ResponseDTO> getShipmentAOFollowUpByOrgId(@RequestParam(required = false) Long orgId) {
		String methodName = "getShipmentAOFollowUpByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
		try {
			shipmentAOVO = transactionService.getShipmentAOFollowUpByOrgId(orgId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentAOFollowup information get successfully By OrgId");
			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentAOFollowup information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreateShipmentAOFollowUp")
	public ResponseEntity<ResponseDTO> updateCreateAOShipmentFollowUp(@Valid @RequestBody ShipmentAOFollowUpDTO shipmentFollowUpDTO) {
		String methodName = "updateCreateShipmentAOFollowUp()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ShipmentAOVO shipmentAOVO = transactionService.updateCreateShipmentAOFollowUp(shipmentFollowUpDTO);
			if (shipmentAOVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentAOFollowup updated successfully");
				responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "shipmentAO not found for ID: " + shipmentFollowUpDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "shipmentAOFollowup update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentAOFollowup update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getShipmentAOFollowUpByDocId")
	public ResponseEntity<ResponseDTO> getShipmentAOFollowUpByDocId(@RequestParam(required = false) String docId) {
		String methodName = "getShipmentAOFollowUpByDocId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		ShipmentAOVO shipmentAOVO = new ShipmentAOVO();
		try {
			shipmentAOVO = transactionService.getShipmentAOFollowUpByDocId(docId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentAOFollowup information get successfully By DocId");
			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentAOFollowup information receive failed By DocId",
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

	
	
	//PreAlert
	
	@GetMapping("/getPreAlertAIById")
	public ResponseEntity<ResponseDTO> getPreAlertAIById(@RequestParam(required = false) Long id) {
		String methodName = "getPreAlertAIById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PreAlertAIVO> preAlertAIVO = new ArrayList<>();
		try {
			preAlertAIVO = transactionService.getPreAlertAIById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PreAlertAI information get successfully By Id");
			responseObjectsMap.put("preAlertAIVO", preAlertAIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PreAlertAI information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getPreAlertAIByOrgId")
	public ResponseEntity<ResponseDTO> getPreAlertAIByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getPreAlertAIByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PreAlertAIVO> preAlertAIVO = new ArrayList<>();
		try {
			preAlertAIVO = transactionService.getPreAlertAIByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PreAlertAI information get successfully By OrgId");
			responseObjectsMap.put("preAlertAIVO", preAlertAIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PreAlertAI information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	
	@PostMapping("/updateCreatePreAlertAI")
	public ResponseEntity<ResponseDTO> updateCreatePreAlertAI(@Valid @RequestBody PreAlertAIDTO preAlertAIDTO) {
		String methodName = "updateCreatePreAlertAI()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			PreAlertAIVO preAlertAIVO = transactionService.updateCreatePreAlertAI(preAlertAIDTO);
			if (preAlertAIVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PreAlertAI updated successfully");
				responseObjectsMap.put("preAlertAIVO", preAlertAIVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "PreAlertAI not found for ID: " + preAlertAIDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "PreAlertAI update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "PreAlertAI update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//AdvanceCanAi
	
	@GetMapping("/getAdvanceCanAiById")
	public ResponseEntity<ResponseDTO> getAdvanceCanAiById(@RequestParam(required = false) Long id) {
		String methodName = "getAdvanceCanAiById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<AdvanceCanAiVO> advanceCanAiVO = new ArrayList<>();
		try {
			advanceCanAiVO = transactionService.getAdvanceCanAiById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "AdvanceCanAi information get successfully By Id");
			responseObjectsMap.put("advanceCanAiVO", advanceCanAiVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "AdvanceCanAi information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getAdvanceCanAiByOrgId")
	public ResponseEntity<ResponseDTO> getAdvanceCanAiByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getAdvanceCanAiByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<AdvanceCanAiVO> advanceCanAiVO = new ArrayList<>();
		try {
			advanceCanAiVO = transactionService.getAdvanceCanAiByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "AdvanceCanAi information get successfully By OrgId");
			responseObjectsMap.put("advanceCanAiVO", advanceCanAiVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "AdvanceCanAi information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreateAdvanceCanAi")
	public ResponseEntity<ResponseDTO> updateCreateAdvanceCanAi(@Valid @RequestBody AdvanceCanAiDTO advanceCanAiDTO) {
		String methodName = "updateCreateAdvanceCanAi()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			AdvanceCanAiVO advanceCanAiVO = transactionService.updateCreateAdvanceCanAi(advanceCanAiDTO);
			if (advanceCanAiVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "AdvanceCanAi updated successfully");
				responseObjectsMap.put("advanceCanAiVO", advanceCanAiVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "AdvanceCanAi not found for ID: " + advanceCanAiDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "AdvanceCanAi update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "AdvanceCanAi update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//ShipperSO
	
	@GetMapping("/getShipmentSOById")
	public ResponseEntity<ResponseDTO> getShipmentSOById(@RequestParam(required = false) Long id) {
		String methodName = "getShipmentSOById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentSOVO> shipmentSOVO = new ArrayList<>();
		try {
			shipmentSOVO = transactionService.getShipmentSOById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "ShipmentSO information get successfully By Id");
			responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "ShipmentSO information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getShipmentSOByOrgId")
	public ResponseEntity<ResponseDTO> getShipmentSOByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getShipmentSOByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentSOVO> shipmentSOVO = new ArrayList<>();
		try {
			shipmentSOVO = transactionService.getShipmentSOByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentSO information get successfully By OrgId");
			responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentSO information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreateShipmentSO")
	public ResponseEntity<ResponseDTO> updateCreateShipmentSO(@Valid @RequestBody ShipmentSODTO shipmentSODTO) {
		String methodName = "updateCreateShipmentSO()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ShipmentSOVO shipmentSOVO = transactionService.updateCreateShipmentSO(shipmentSODTO);
			if (shipmentSOVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentSO updated successfully");
				responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "shipmentSO not found for ID: " + shipmentSODTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "shipmentSO update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentSO update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//ShipperSOFollowup
	
	@GetMapping("/getShipmentSOFollowUpById")
	public ResponseEntity<ResponseDTO> getShipmentSOFollowUpById(@RequestParam(required = false) Long id) {
		String methodName = "getShipmentSOById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentSOVO> shipmentSOVO = new ArrayList<>();
		try {
			shipmentSOVO = transactionService.getShipmentSOFollowUpById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "ShipmentSOFollowUp information get successfully By Id");
			responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "ShipmentSOFollowup information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getShipmentSOFollowUpByOrgId")
	public ResponseEntity<ResponseDTO> getShipmentSOFollowUpByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getShipmentSOFollowUpByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ShipmentSOVO> shipmentSOVO = new ArrayList<>();
		try {
			shipmentSOVO = transactionService.getShipmentSOFollowUpByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentSOFollowUp information get successfully By OrgId");
			responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentSOFollowUp information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreateShipmentSOFollowUp")
	public ResponseEntity<ResponseDTO> updateCreateShipmentSOFollowUp(@Valid @RequestBody ShipmentSOFollowUpDTO shipmentSOFollowUpDTO) {
		String methodName = "updateCreateShipmentSOFollowUp()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ShipmentSOVO shipmentSOVO = transactionService.updateCreateShipmentSOFollowUp(shipmentSOFollowUpDTO);
			if (shipmentSOVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentSOFollowup updated successfully");
				responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "shipmentSO not found for ID: " + shipmentSOFollowUpDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "shipmentSOFollowup update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentSOFollowup update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	

	@GetMapping("/getShipmentSOFollowUpByDocId")
	public ResponseEntity<ResponseDTO> getShipmentSOFollowUpByDocId(@RequestParam(required = false) String docId) {
		String methodName = "getShipmentSOFollowUpByDocId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		ShipmentSOVO shipmentSOVO = new ShipmentSOVO();
		try {
			shipmentSOVO = transactionService.getShipmentSOFollowUpByDocId(docId);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentSOFollowup information get successfully By DocId");
			responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentSOFollowup information receive failed By DocId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//ContainerAllocation
	
	@GetMapping("/getContainerAllocationSOById")
	public ResponseEntity<ResponseDTO> getContainerAllocationSOById(@RequestParam(required = false) Long id) {
		String methodName = "getContainerAllocationSOById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ContainerAllocationSOVO> containerAllocationSOVO = new ArrayList<>();
		try {
			containerAllocationSOVO = transactionService.getContainerAllocationSOById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "ContainerAllocationSO information get successfully By Id");
			responseObjectsMap.put("containerAllocationSOVO", containerAllocationSOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "ContainerAllocationSO information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getContainerAllocationSOByOrgId")
	public ResponseEntity<ResponseDTO> getContainerAllocationSOByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getContainerAllocationSOByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ContainerAllocationSOVO> containerAllocationSOVO = new ArrayList<>();
		try {
			containerAllocationSOVO = transactionService.getContainerAllocationSOByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "ContainerAllocationSO information get successfully By OrgId");
			responseObjectsMap.put("containerAllocationSOVO", containerAllocationSOVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "ContainerAllocationSO information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreateContainerAllocationSO")
	public ResponseEntity<ResponseDTO> updateCreateContainerAllocationSO(@Valid @RequestBody ContainerAllocationSODTO containerAllocationSODTO) {
		String methodName = "updateCreateContainerAllocationSO()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ContainerAllocationSOVO containerAllocationSOVO = transactionService.updateCreateContainerAllocationSO(containerAllocationSODTO);
			if (containerAllocationSOVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "ContainerAllocationSO updated successfully");
				responseObjectsMap.put("containerAllocationSOVO", containerAllocationSOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "containerAllocationSO not found for ID: " + containerAllocationSODTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "ContainerAllocationSO update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "ContainerAllocationSO update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
   //PreAlretSI
	
	@GetMapping("/getPreAlertSIById")
	public ResponseEntity<ResponseDTO> getPreAlertSIById(@RequestParam(required = false) Long id) {
		String methodName = "getPreAlertSIById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PreAlertSIVO> preAlertSIVO = new ArrayList<>();
		try {
			preAlertSIVO = transactionService.getPreAlertSIById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PreAlertSI information get successfully By Id");
			responseObjectsMap.put("preAlertSIVO", preAlertSIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PreAlertSI information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getPreAlertSIByOrgId")
	public ResponseEntity<ResponseDTO> getPreAlertSIByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getPreAlertSIByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PreAlertSIVO> preAlertSIVO = new ArrayList<>();
		try {
			preAlertSIVO = transactionService.getPreAlertSIByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PreAlertSI information get successfully By OrgId");
			responseObjectsMap.put("preAlertSIVO", preAlertSIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PreAlertSI information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PostMapping("/updateCreatePreAlertSI")
	public ResponseEntity<ResponseDTO> updateCreatePreAlertSI(@Valid @RequestBody PreAlertSIDTO preAlertSIDTO) {
		String methodName = "updateCreatePreAlertSI()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			PreAlertSIVO preAlertSIVO = transactionService.updateCreatePreAlertSI(preAlertSIDTO);
			if (preAlertSIVO != null) {
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PreAlertSI updated successfully");
				responseObjectsMap.put("preAlertSIVO", preAlertSIVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				errorMsg = "PreAlertSI not found for ID: " + preAlertSIDTO.getId();
				responseDTO = createServiceResponseError(responseObjectsMap, "PreAlertSI update failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "PreAlertSI update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	
}
