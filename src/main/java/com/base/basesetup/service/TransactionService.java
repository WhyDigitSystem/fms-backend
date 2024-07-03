package com.base.basesetup.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.entity.ShipmentAOVO;
import com.base.basesetup.exception.ApplicationException;

@Service
public interface TransactionService {
	
	//ShipmentAO

	List<ShipmentAOVO> getShipmentAOById(Long id);

	List<ShipmentAOVO> getShipmentAOByOrgId(Long orgid);

	ShipmentAOVO updateCreateShipmentAO(@Valid ShipmentAODTO shipmentAODTO) throws ApplicationException;

}
