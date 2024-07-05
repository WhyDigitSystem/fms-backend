package com.base.basesetup.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.dto.ShipmentFollowUpDTO;
import com.base.basesetup.entity.ShipmentAOVO;
import com.base.basesetup.exception.ApplicationException;

@Service
public interface TransactionService {
	
	//ShipmentAO

	List<ShipmentAOVO> getShipmentAOById(Long id);

	List<ShipmentAOVO> getShipmentAOByOrgId(Long orgId);

	ShipmentAOVO updateCreateShipmentAO(@Valid ShipmentAODTO shipmentAODTO) throws ApplicationException;
	
	//ShipmentFollowUp

	List<ShipmentAOVO> getShipmentFollowUpById(Long id);

	List<ShipmentAOVO> getShipmentFollowUpByOrgId(Long orgId);

	ShipmentAOVO updateCreateShipmentFollowUp(@Valid ShipmentFollowUpDTO shipmentFollowUpDTO) throws ApplicationException;

	ShipmentAOVO getShipmentFollowUpByDocId(String docId);

}
