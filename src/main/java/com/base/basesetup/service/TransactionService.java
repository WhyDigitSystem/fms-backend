package com.base.basesetup.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.base.basesetup.dto.AdvanceCanAiDTO;
import com.base.basesetup.dto.ContainerAllocationSODTO;
import com.base.basesetup.dto.MasterAirWayBillDTO;
import com.base.basesetup.dto.PreAlertAIDTO;
import com.base.basesetup.dto.PreAlertSIDTO;
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
import com.base.basesetup.exception.ApplicationException;

@Service
public interface TransactionService {
	
	//ShipmentAO

	List<ShipmentAOVO> getShipmentAOById(Long id);

	List<ShipmentAOVO> getShipmentAOByOrgId(Long orgId);

	ShipmentAOVO updateCreateShipmentAO(@Valid ShipmentAODTO shipmentAODTO) throws ApplicationException;
	
	//ShipmentFollowUp

	List<ShipmentAOVO> getShipmentAOFollowUpById(Long id);

	List<ShipmentAOVO> getShipmentAOFollowUpByOrgId(Long orgId);

	ShipmentAOVO updateCreateShipmentAOFollowUp(@Valid ShipmentAOFollowUpDTO shipmentFollowUpDTO) throws ApplicationException;

	ShipmentAOVO getShipmentAOFollowUpByDocId(String docId);
	
	//MasterAirWayBill

	List<MasterAirWayBillVO> getMasterAirWayBillById(Long id);

	List<MasterAirWayBillVO> getMasterAirWayBillByOrgId(Long orgid);

	MasterAirWayBillVO updateCreateMasterAirWayBill(@Valid MasterAirWayBillDTO masterAirWayBillDTO) throws ApplicationException;

	//PreAlert
	
	List<PreAlertAIVO> getPreAlertAIById(Long id);

	List<PreAlertAIVO> getPreAlertAIByOrgId(Long orgid);

	PreAlertAIVO updateCreatePreAlertAI(@Valid PreAlertAIDTO preAlertAIDTO) throws ApplicationException;
	
	//AdvanceCanAi

	List<AdvanceCanAiVO> getAdvanceCanAiById(Long id);

	List<AdvanceCanAiVO> getAdvanceCanAiByOrgId(Long orgid);

	AdvanceCanAiVO updateCreateAdvanceCanAi(@Valid AdvanceCanAiDTO advanceCanAiDTO) throws ApplicationException;

	//ShipperSO
	
	List<ShipmentSOVO> getShipmentSOById(Long id);

	List<ShipmentSOVO> getShipmentSOByOrgId(Long orgid);

	ShipmentSOVO updateCreateShipmentSO(@Valid ShipmentSODTO shipmentSODTO) throws ApplicationException;

	ShipmentSOVO updateCreateShipmentSOFollowUp(@Valid ShipmentSOFollowUpDTO shipmentSOFollowUpDTO) throws ApplicationException;

	List<ShipmentSOVO> getShipmentSOFollowUpById(Long id);

	List<ShipmentSOVO> getShipmentSOFollowUpByOrgId(Long orgid);

	ShipmentSOVO getShipmentSOFollowUpByDocId(String docId);
	
	//containerAllocation

	List<ContainerAllocationSOVO> getContainerAllocationSOById(Long id);

	List<ContainerAllocationSOVO> getContainerAllocationSOByOrgId(Long orgid);

	ContainerAllocationSOVO updateCreateContainerAllocationSO(@Valid ContainerAllocationSODTO containerAllocationSODTO) throws ApplicationException;

	//PreALertSI
	List<PreAlertSIVO> getPreAlertSIById(Long id);

	List<PreAlertSIVO> getPreAlertSIByOrgId(Long orgid);

	PreAlertSIVO updateCreatePreAlertSI(@Valid PreAlertSIDTO preAlertSIDTO) throws ApplicationException;






}
