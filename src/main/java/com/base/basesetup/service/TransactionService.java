package com.base.basesetup.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.base.basesetup.dto.AdvanceCanAiDTO;
import com.base.basesetup.dto.MasterAirWayBillDTO;
import com.base.basesetup.dto.PreAlertDTO;
import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.dto.ShipmentAOFollowUpDTO;
import com.base.basesetup.dto.ShipmentSODTO;
import com.base.basesetup.dto.ShipmentSOFollowUpDTO;
import com.base.basesetup.entity.AdvanceCanAiVO;
import com.base.basesetup.entity.MasterAirWayBillVO;
import com.base.basesetup.entity.PreAlertVO;
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
	
	List<PreAlertVO> getPreAlertById(Long id);

	List<PreAlertVO> getPreAlertByOrgId(Long orgid);

	PreAlertVO updateCreatePreAlert(@Valid PreAlertDTO preAlertDTO) throws ApplicationException;
	
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

}
