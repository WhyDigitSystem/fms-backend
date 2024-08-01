
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
import com.base.basesetup.dto.AdvanceCanAIDTO;
import com.base.basesetup.dto.AdvanceCanSIDTO;
import com.base.basesetup.dto.ContainerAllocationSIDTO;
import com.base.basesetup.dto.ContainerAllocationSODTO;
import com.base.basesetup.dto.DeliveryOrderSIDTO;
import com.base.basesetup.dto.MasterAirWayBillDTO;
import com.base.basesetup.dto.PreAlertAIDTO;
import com.base.basesetup.dto.PreAlertSIDTO;
import com.base.basesetup.dto.ResponseDTO;
import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.dto.ShipmentAOFollowUpDTO;
import com.base.basesetup.dto.ShipmentSODTO;
import com.base.basesetup.dto.ShipmentSOFollowUpDTO;
import com.base.basesetup.entity.AdvanceCanAIVO;
import com.base.basesetup.entity.AdvanceCanSIVO;
import com.base.basesetup.entity.ContainerAllocationSIVO;
import com.base.basesetup.entity.ContainerAllocationSOVO;
import com.base.basesetup.entity.DeliveryOrderSIVO;
import com.base.basesetup.entity.MasterAirWayBillVO;
import com.base.basesetup.entity.PortVO;
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
	
	@PutMapping("/updateCreateShipmentAO")
	public ResponseEntity<ResponseDTO> updateCreateShipmentAO(@Valid @RequestBody ShipmentAODTO shipmentAODTO) {
		String methodName = "updateCreateShipmentAO()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ShipmentAOVO shipmentAOVO = transactionService.updateCreateShipmentAO(shipmentAODTO);
			if (shipmentAOVO != null) {
				boolean isUpdate = shipmentAODTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "shipmentAO updated successfully" : "shipmentAO created Successfully");
				responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = shipmentAODTO.getId() != null;
				errorMsg = isUpdate? "shipmentAO not found for ID: " + shipmentAODTO.getId(): "shipmentAO created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "shipmentAO update failed" : "shipmentAO created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = shipmentAODTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "shipmentAO update failed" : "shipmentAO created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getPolForShipmentAO")
	public ResponseEntity<ResponseDTO> getPolForShipmentAO() {
		String methodName = "getPolForShipmentAO()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PortVO> portVO = new ArrayList<>();
		try {
			portVO = transactionService.getPolForShipmentAO();
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PortVO information get successfully By Pol");
			responseObjectsMap.put("portVO", portVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PortVO information receive failed By Pol",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getPodForShipmentAO")
	public ResponseEntity<ResponseDTO> getPodForShipmentAO() {
		String methodName = "getPodForShipmentAO()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<PortVO> portVO = new ArrayList<>();
		try {
			portVO = transactionService.getPodForShipmentAO();
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "PortVO information get successfully By Pod");
			responseObjectsMap.put("portVO", portVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "PortVO information receive failed By Pod",
					errorMsg);
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
	
	@PutMapping("/updateCreateShipmentAOFollowUp")
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
				errorMsg = "shipmentAO not found for ID: " + shipmentFollowUpDTO.getDocId();
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
	
//	@GetMapping("/getShipmentAOFollowUpByDocId")
//	public ResponseEntity<ResponseDTO> getShipmentAOFollowUpByDocId(@RequestParam(required = false) String docId) {
//		String methodName = "getShipmentAOFollowUpByDocId()";
//		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
//		String errorMsg = null;
//		Map<String, Object> responseObjectsMap = new HashMap<>();
//		ResponseDTO responseDTO = null;
//		ShipmentAOVO shipmentAOVO = new ShipmentAOVO();
//		try {
//			shipmentAOVO = transactionService.getShipmentAOFollowUpByDocId(docId);
//		} catch (Exception e) {
//			errorMsg = e.getMessage();
//			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
//		}
//		if (StringUtils.isBlank(errorMsg)) {
//			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentAOFollowup information get successfully By DocId");
//			responseObjectsMap.put("shipmentAOVO", shipmentAOVO);
//			responseDTO = createServiceResponse(responseObjectsMap);
//		} else {
//			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentAOFollowup information receive failed By DocId",
//					errorMsg);
//		}
//		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
//		return ResponseEntity.ok().body(responseDTO);
//	}
	
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
	
	@PutMapping("/updateCreateMasterAirWayBill")
	public ResponseEntity<ResponseDTO> updateCreateMasterAirWayBill(@Valid @RequestBody MasterAirWayBillDTO masterAirWayBillDTO) {
		String methodName = "updateCreateMasterAirWayBill()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			MasterAirWayBillVO masterAirWayBillVO = transactionService.updateCreateMasterAirWayBill(masterAirWayBillDTO);
			if (masterAirWayBillVO != null) {
				boolean isUpdate = masterAirWayBillDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "MasterAirWayBill updated successfully" :"MasterAirWayBill created successfully");
				responseObjectsMap.put("masterAirWayBillVO", masterAirWayBillVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = masterAirWayBillDTO.getId() != null;
				errorMsg = isUpdate? "MasterAirWayBill not found for ID: " + masterAirWayBillDTO.getId():"MasterAirWayBill created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "MasterAirWayBill update failed" :"MasterAirWayBill created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = masterAirWayBillDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "MasterAirWayBill update failed" :"MasterAirWayBill created failed", errorMsg);
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
	
	
	@PutMapping("/updateCreatePreAlertAI")
	public ResponseEntity<ResponseDTO> updateCreatePreAlertAI(@Valid @RequestBody PreAlertAIDTO preAlertAIDTO) {
		String methodName = "updateCreatePreAlertAI()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			PreAlertAIVO preAlertAIVO = transactionService.updateCreatePreAlertAI(preAlertAIDTO);
			if (preAlertAIVO != null) {
				boolean isUpdate = preAlertAIDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "PreAlertAI updated successfully" : "PreAlertAI created successfully");
				responseObjectsMap.put("preAlertAIVO", preAlertAIVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = preAlertAIDTO.getId() != null;
				errorMsg = isUpdate? "PreAlertAI not found for ID: " + preAlertAIDTO.getId() :"PreAlertAI created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "PreAlertAI update failed" : "PreAlert Created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = preAlertAIDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "PreAlertAI update failed" : "PreAlertAI created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//AdvanceCanAi
	
	@GetMapping("/getAdvanceCanAIById")
	public ResponseEntity<ResponseDTO> getAdvanceCanAIById(@RequestParam(required = false) Long id) {
		String methodName = "getAdvanceCanAIById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<AdvanceCanAIVO> advanceCanAIVO = new ArrayList<>();
		try {
			advanceCanAIVO = transactionService.getAdvanceCanAIById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "AdvanceCanAI information get successfully By Id");
			responseObjectsMap.put("advanceCanAIVO", advanceCanAIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "AdvanceCanAI information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getAdvanceCanAIByOrgId")
	public ResponseEntity<ResponseDTO> getAdvanceCanAIByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getAdvanceCanAIByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<AdvanceCanAIVO> advanceCanAIVO = new ArrayList<>();
		try {
			advanceCanAIVO = transactionService.getAdvanceCanAIByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "AdvanceCanAI information get successfully By OrgId");
			responseObjectsMap.put("advanceCanAIVO", advanceCanAIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "AdvanceCanAI information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateAdvanceCanAI")
	public ResponseEntity<ResponseDTO> updateCreateAdvanceCanAI(@Valid @RequestBody AdvanceCanAIDTO advanceCanAIDTO) {
		String methodName = "updateCreateAdvanceCanAI()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			AdvanceCanAIVO advanceCanAIVO = transactionService.updateCreateAdvanceCanAI(advanceCanAIDTO);
			if (advanceCanAIVO != null) {
				boolean isUpdate = advanceCanAIDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, isUpdate? "AdvanceCanAI updated successfully" : "AdvanceCanAI created Successfully");
				responseObjectsMap.put("advanceCanAIVO", advanceCanAIVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = advanceCanAIDTO.getId() != null;
				errorMsg = isUpdate? "AdvanceCanAI not found for ID" + advanceCanAIDTO.getId() : "AdvanceCanAI created failed";
				responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "AdvanceCanAI updated failed" : "AdvanceCanAI created failed",errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = advanceCanAIDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "AdvanceCanAI updated failed" : "AdvanceCanAI created failed",errorMsg);
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
	
	@PutMapping("/updateCreateShipmentSO")
	public ResponseEntity<ResponseDTO> updateCreateShipmentSO(@Valid @RequestBody ShipmentSODTO shipmentSODTO) {
		String methodName = "updateCreateShipmentSO()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ShipmentSOVO shipmentSOVO = transactionService.updateCreateShipmentSO(shipmentSODTO);
			if (shipmentSOVO != null) {
				boolean isUpdate = shipmentSODTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE, isUpdate ? "shipmentSO updated successfully" : "shipmentSO created succesfully");
				responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = shipmentSODTO.getId() != null;
				errorMsg =isUpdate? "shipmentSO not found for ID: " + shipmentSODTO.getId(): "shipmentSO create failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "shipmentSO update failed" :"shipmentSO created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = shipmentSODTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "shipmentSO update failed" :"shipmentSO created failed", errorMsg);
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
	
	@PutMapping("/updateCreateShipmentSOFollowUp")
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
				errorMsg = "shipmentSO not found for ID: " + shipmentSOFollowUpDTO.getDocId();
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
	

//	@GetMapping("/getShipmentSOFollowUpByDocId")
//	public ResponseEntity<ResponseDTO> getShipmentSOFollowUpByDocId(@RequestParam(required = false) String docId) {
//		String methodName = "getShipmentSOFollowUpByDocId()";
//		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
//		String errorMsg = null;
//		Map<String, Object> responseObjectsMap = new HashMap<>();
//		ResponseDTO responseDTO = null;
//		ShipmentSOVO shipmentSOVO = new ShipmentSOVO();
//		try {
//			shipmentSOVO = transactionService.getShipmentSOFollowUpByDocId(docId);
//		} catch (Exception e) {
//			errorMsg = e.getMessage();
//			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
//		}
//		if (StringUtils.isBlank(errorMsg)) {
//			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "shipmentSOFollowup information get successfully By DocId");
//			responseObjectsMap.put("shipmentSOVO", shipmentSOVO);
//			responseDTO = createServiceResponse(responseObjectsMap);
//		} else {
//			responseDTO = createServiceResponseError(responseObjectsMap, "shipmentSOFollowup information receive failed By DocId",
//					errorMsg);
//		}
//		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
//		return ResponseEntity.ok().body(responseDTO);
//	}
	
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
	
	@PutMapping("/updateCreateContainerAllocationSO")
	public ResponseEntity<ResponseDTO> updateCreateContainerAllocationSO(@Valid @RequestBody ContainerAllocationSODTO containerAllocationSODTO) {
		String methodName = "updateCreateContainerAllocationSO()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ContainerAllocationSOVO containerAllocationSOVO = transactionService.updateCreateContainerAllocationSO(containerAllocationSODTO);
			if (containerAllocationSOVO != null) {
				boolean isUpdate = containerAllocationSODTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "ContainerAllocationSO updated successfully" : "ContainerAllocationSOVO created successfully");
				responseObjectsMap.put("containerAllocationSOVO", containerAllocationSOVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = containerAllocationSODTO.getId() != null;
				errorMsg = isUpdate? "containerAllocationSO not found for ID: " + containerAllocationSODTO.getId() :"ContainerAllocation created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "ContainerAllocationSO updated failed" : "ContainerAllocationSOVO created failed",errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = containerAllocationSODTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "ContainerAllocationSO update failed" : "ContainerAllocationSO created failed", errorMsg);
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
	
	@PutMapping("/updateCreatePreAlertSI")
	public ResponseEntity<ResponseDTO> updateCreatePreAlertSI(@Valid @RequestBody PreAlertSIDTO preAlertSIDTO) {
		String methodName = "updateCreatePreAlertSI()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			PreAlertSIVO preAlertSIVO = transactionService.updateCreatePreAlertSI(preAlertSIDTO);
			if (preAlertSIVO != null) {
				boolean isUpdate = preAlertSIDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "PreAlertSI updated successfully" :"PreAlertSI created successfully");
				responseObjectsMap.put("preAlertSIVO", preAlertSIVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = preAlertSIDTO.getId() != null;
				errorMsg =isUpdate? "PreAlertSI not found for ID: " + preAlertSIDTO.getId() :"PreAlertSI created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "PreAlertSI update failed" : "PreAlertSI created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = preAlertSIDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "PreAlertSI update failed" :"PreAlertSI created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}

	//ContainerAllocationSI
	
	@GetMapping("/getContainerAllocationSIById")
	public ResponseEntity<ResponseDTO> getContainerAllocationSIById(@RequestParam(required = false) Long id) {
		String methodName = "getContainerAllocationSIById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ContainerAllocationSIVO> containerAllocationSIVO = new ArrayList<>();
		try {
			containerAllocationSIVO = transactionService.getContainerAllocationSIById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "containerAllocationSI information get successfully By Id");
			responseObjectsMap.put("containerAllocationSIVO", containerAllocationSIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "containerAllocationSI information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getContainerAllocationSIByOrgId")
	public ResponseEntity<ResponseDTO> getContainerAllocationSIByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getContainerAllocationSIByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<ContainerAllocationSIVO> containerAllocationSIVO = new ArrayList<>();
		try {
			containerAllocationSIVO = transactionService.getContainerAllocationSIByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "containerAllocationSI information get successfully By OrgId");
			responseObjectsMap.put("containerAllocationSIVO", containerAllocationSIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "containerAllocationSI information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	

	
	@PutMapping("/updateCreateContainerAllocationSI")
	public ResponseEntity<ResponseDTO> updateCreateContainerAllocationSI(@Valid @RequestBody ContainerAllocationSIDTO containerAllocationSIDTO) {
		String methodName = "updateCreateContainerAllocationSI()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			ContainerAllocationSIVO containerAllocationSIVO = transactionService.updateCreateContainerAllocationSI(containerAllocationSIDTO);
			if (containerAllocationSIVO != null) {
				boolean isUpdate = containerAllocationSIDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "PreAlertSI updated successfully" :"PreAlert created Successfully");
				responseObjectsMap.put("containerAllocationSIVO", containerAllocationSIVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = containerAllocationSIDTO.getId() != null;
				errorMsg =isUpdate? "containerAllocationSIVO not found for ID: " + containerAllocationSIDTO.getId() : "containerAllocation created failed";
				responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "containerAllocationSIVO update failed" :"containerAllocationSIVO created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = containerAllocationSIDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "containerAllocationSIVO update failed" :"containerAllocation created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//AdvanceCanSI
	

	@GetMapping("/getAdvanceCanSIById")
	public ResponseEntity<ResponseDTO> getAdvanceCanSIById(@RequestParam(required = false) Long id) {
		String methodName = "getAdvanceCanSIById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<AdvanceCanSIVO> advanceCanSIVO = new ArrayList<>();
		try {
			advanceCanSIVO = transactionService.getAdvanceCanSIById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "AdvanceCanSI information get successfully By Id");
			responseObjectsMap.put("advanceCanSIVO", advanceCanSIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "AdvanceCanSI information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getAdvanceCanSIByOrgId")
	public ResponseEntity<ResponseDTO> getAdvanceCanSIByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getAdvanceCanSIByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<AdvanceCanSIVO> advanceCanSIVO = new ArrayList<>();
		try {
			advanceCanSIVO = transactionService.getAdvanceCanSIByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "AdvanceCanSI information get successfully By OrgId");
			responseObjectsMap.put("advanceCanSIVO", advanceCanSIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "AdvanceCanSI information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateAdvanceCanSI")
	public ResponseEntity<ResponseDTO> updateCreateAdvanceCanSI(@Valid @RequestBody AdvanceCanSIDTO advanceCanSIDTO) {
		String methodName = "updateCreateAdvanceCanSI()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			AdvanceCanSIVO advanceCanSIVO = transactionService.updateCreateAdvanceCanSI(advanceCanSIDTO);
			if (advanceCanSIVO != null) {
				boolean isUpdate = advanceCanSIDTO.getId() != null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "AdvanceCanSI updated successfully" :"AdvanceCanSI created successfully");
				responseObjectsMap.put("advanceCanSIVO", advanceCanSIVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate = advanceCanSIDTO.getId() != null;
				errorMsg = isUpdate? "AdvanceCanSI not found for ID: " + advanceCanSIDTO.getId() :"AdvanceCanSI created failed";
				responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "AdvanceCanSI update failed" : "AdvanceCanSI created failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			boolean isUpdate = advanceCanSIDTO.getId() != null;
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, isUpdate? "AdvanceCanSI update failed" : "AdvanceCanSI created failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	//DeliveryOrderSI

	@GetMapping("/getDeliveryOrderSIById")
	public ResponseEntity<ResponseDTO> getDeliveryOrderSIById(@RequestParam(required = false) Long id) {
		String methodName = "getDeliveryOrderSIById()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DeliveryOrderSIVO> deliveryOrderSIVO = new ArrayList<>();
		try {
			deliveryOrderSIVO = transactionService.getDeliveryOrderSIById(id);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "DeliveryOrderSI information get successfully By Id");
			responseObjectsMap.put("deliveryOrderSIVO", deliveryOrderSIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "DeliveryOrderSI information receive failed By Id",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@GetMapping("/getDeliveryOrderSIByOrgId")
	public ResponseEntity<ResponseDTO> getDeliveryOrderSIByOrgId(@RequestParam(required = false) Long orgid) {
		String methodName = "getDeliveryOrderSIByOrgId()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		List<DeliveryOrderSIVO> deliveryOrderSIVO = new ArrayList<>();
		try {
			deliveryOrderSIVO = transactionService.getDeliveryOrderSIByOrgId(orgid);
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
		}
		if (StringUtils.isBlank(errorMsg)) {
			responseObjectsMap.put(CommonConstant.STRING_MESSAGE, "DeliveryOrderSI information get successfully By OrgId");
			responseObjectsMap.put("deliveryOrderSIVO", deliveryOrderSIVO);
			responseDTO = createServiceResponse(responseObjectsMap);
		} else {
			responseDTO = createServiceResponseError(responseObjectsMap, "DeliveryOrderSI information receive failed By OrgId",
					errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	@PutMapping("/updateCreateDeliveryOrderSI")
	public ResponseEntity<ResponseDTO> updateCreateDeliveryOrderSI(@Valid @RequestBody DeliveryOrderSIDTO deliveryOrderSIDTO) {
		String methodName = "updateCreateDeliveryOrderSI()";
		LOGGER.debug(CommonConstant.STARTING_METHOD, methodName);
		String errorMsg = null;
		Map<String, Object> responseObjectsMap = new HashMap<>();
		ResponseDTO responseDTO = null;
		try {
			DeliveryOrderSIVO deliveryOrderSIVO = transactionService.updateCreateDeliveryOrderSI(deliveryOrderSIDTO);
			if (deliveryOrderSIVO != null) {
				boolean isUpdate =deliveryOrderSIDTO.getId()!= null;
				responseObjectsMap.put(CommonConstant.STRING_MESSAGE,isUpdate? "DeliveryOrderSI"
						+ " updated successfully" :"DeliveryOrderSI created successfully");
				responseObjectsMap.put("deliveryOrderSIVO", deliveryOrderSIVO);
				responseDTO = createServiceResponse(responseObjectsMap);
			} else {
				boolean isUpdate =deliveryOrderSIDTO.getId()!= null;
				errorMsg =isUpdate? "DeliveryOrderSI not found for ID: " + deliveryOrderSIDTO.getId() : "DeliveryOrderSI created failed";
				responseDTO = createServiceResponseError(responseObjectsMap,isUpdate? "DeliveryOrderSI update failed" : "DeliveryOrderSI create failed", errorMsg);
			}
		} catch (Exception e) {
			errorMsg = e.getMessage();
			LOGGER.error(UserConstants.ERROR_MSG_METHOD_NAME, methodName, errorMsg);
			responseDTO = createServiceResponseError(responseObjectsMap, "DeliveryOrderSIVO update failed", errorMsg);
		}
		LOGGER.debug(CommonConstant.ENDING_METHOD, methodName);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	
}
