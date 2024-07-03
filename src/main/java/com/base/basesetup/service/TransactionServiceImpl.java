package com.base.basesetup.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CostEstimateDTO;
import com.base.basesetup.dto.PackingListDTO;
import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.entity.CostEstimateVO;
import com.base.basesetup.entity.EventsVO;
import com.base.basesetup.entity.PackingListVO;
import com.base.basesetup.entity.ShipmentAOVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.CostEstimateRepo;
import com.base.basesetup.repo.PackingListRepo;
import com.base.basesetup.repo.ShipmentAORepo;

@Service
public class TransactionServiceImpl implements TransactionService{

	public static final Logger LOGGER = LoggerFactory.getLogger(BasicMasterServiceImpl.class);

	@Autowired
	ShipmentAORepo shipmentAORepo;
	
	@Autowired
	PackingListRepo packingListRepo;
	
	@Autowired
	CostEstimateRepo costEstimateRepo;
	
	//ShipmentAO
	
	@Override
	public List<ShipmentAOVO> getShipmentAOById(Long id) {
			List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received  ShipmentAO BY Id : {}", id);
				shipmentAOVO = shipmentAORepo.findShipmentAOById(id);
			} else {
				LOGGER.info("Successfully Received  Country For All Id.");
				shipmentAOVO = shipmentAORepo.findAll();
			}
			return shipmentAOVO;
		}

	@Override
	public List<ShipmentAOVO> getShipmentAOByOrgId(Long orgid) {
			List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(orgid)) {
				LOGGER.info("Successfully Received  ShipmentAO BY Id : {}", orgid);
				shipmentAOVO = shipmentAORepo.getShipmentAOByOrgId(orgid);
			} else {
				LOGGER.info("Successfully Received  Country For All OrgId.");
				shipmentAOVO = shipmentAORepo.findAll();
			}
			return shipmentAOVO;
		}
	
	@Override
	public ShipmentAOVO updateCreateShipmentAO(@Valid ShipmentAODTO shipmentAODTO) throws ApplicationException {
		ShipmentAOVO shipmentAOVO = new ShipmentAOVO();
		if (ObjectUtils.isNotEmpty(shipmentAODTO.getId())) {
			shipmentAOVO = shipmentAORepo.findById(shipmentAODTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid ShipmentAO details"));
		}
		else {
			// Create a new EventsVO instance if the event ID is not present
			shipmentAOVO = new ShipmentAOVO();

			// Generate a new unique event ID
			int docid = shipmentAORepo.finddocid(); // Ensure this method is correctly implemented to fetch the next
													// sequence value
			String docsid = "SH" + docid;
			shipmentAORepo.getbydocsid();
			shipmentAOVO.setDocId(docsid); // Assuming this sets the unique event ID to the eventsVO
		}
		
		getShipmentAOVOFromShipmentAODTO(shipmentAODTO, shipmentAOVO);
		shipmentAOVO = shipmentAORepo.save(shipmentAOVO);

		List<PackingListVO> packingListVO = packingListRepo.findByShipmentAOVO(shipmentAOVO);
		packingListRepo.deleteAll(packingListVO);

		List<PackingListVO> packingListVOs = new ArrayList<>();
		if (shipmentAODTO.getPackingListDTO() != null) {
			for (PackingListDTO packingListDTO : shipmentAODTO.getPackingListDTO()) {
				PackingListVO packingListVO1 = new PackingListVO();
				packingListVO1.setSIdNO(packingListDTO.getSIdNO());
				packingListVO1.setCustPoNo(packingListDTO.getCustPoNo());
				packingListVO1.setCustPoDt(packingListDTO.getCustPoDt());
				packingListVO1.setIndustry(packingListDTO.getIndustry());
				packingListVO1.setItemDescription(packingListDTO.getItemDescription());
				packingListVO1.setQty(packingListDTO.getQty());
				packingListVO1.setUom(packingListDTO.getUom());
				packingListVO1.setGrWt(packingListDTO.getGrWt());
				packingListVO1.setChWt(packingListDTO.getChWt());
				packingListVO1.setDimL(packingListDTO.getDimL());
				packingListVO1.setDimW(packingListDTO.getDimW());
				packingListVO1.setDimH(packingListDTO.getDimH());
				packingListVO1.setUnit(packingListDTO.getUnit());
				packingListVO1.setVolume(packingListDTO.getVolume());
				packingListVO1.setShipmentAOVO(shipmentAOVO);
				packingListVOs.add(packingListVO1);
			}
		}

		List<CostEstimateVO> costEstimateVOt = costEstimateRepo.findByShipmentAOVO(shipmentAOVO);
		costEstimateRepo.deleteAll(costEstimateVOt);
		
		List<CostEstimateVO> costEstimateVOs = new ArrayList<>();
		if (shipmentAODTO.getCostEstimateDTO() != null) {
			for (CostEstimateDTO costEstimateDTO : shipmentAODTO.getCostEstimateDTO()) {
				CostEstimateVO costEstimateVO1 = new CostEstimateVO();
				costEstimateVO1.setPartyVendor(costEstimateDTO.getPartyVendor());
				costEstimateVO1.setLinearCarrier(costEstimateDTO.getLinearCarrier());
				costEstimateVO1.setBillToCustomer(costEstimateDTO.getBillToCustomer());
				costEstimateVO1.setChargeCode(costEstimateDTO.getChargeCode());
				costEstimateVO1.setDescription(costEstimateDTO.getDescription());
				costEstimateVO1.setAmountInInr(costEstimateDTO.getAmountInInr());
				costEstimateVO1.setEstimatePayDate(costEstimateDTO.getEstimatePayDate());
				costEstimateVO1.setFunReqDate(costEstimateDTO.getFunReqDate());
				
				costEstimateVO1.setShipmentAOVO(shipmentAOVO);
				costEstimateVOs.add(costEstimateVO1);
			}
		}
		shipmentAOVO.setPackingListVO(packingListVOs);
		shipmentAOVO.setCostEstimateVO(costEstimateVOs);
		return shipmentAORepo.save(shipmentAOVO);

	}

	private void getShipmentAOVOFromShipmentAODTO(@Valid ShipmentAODTO shipmentAODTO, ShipmentAOVO shipmentAOVO) {
		shipmentAOVO.setDocDate(shipmentAODTO.getDocDate());
		shipmentAOVO.setGlobalShipNo(shipmentAODTO.getGlobalShipNo());
		shipmentAOVO.setPol(shipmentAODTO.getPol());
		shipmentAOVO.setPod(shipmentAODTO.getPod());
		shipmentAOVO.setJobNO(shipmentAODTO.getJobNO());
		shipmentAOVO.setJobDate(shipmentAODTO.getJobDate());
		shipmentAOVO.setFpod(shipmentAODTO.getFpod());
		shipmentAOVO.setNominatedBy(shipmentAODTO.getNominatedBy());
		shipmentAOVO.setHawbNO(shipmentAODTO.getHawbNO());
		shipmentAOVO.setHawbDate(shipmentAODTO.getHawbDate());
		shipmentAOVO.setDeliveryTerms(shipmentAODTO.getDeliveryTerms());
		shipmentAOVO.setFreight(shipmentAODTO.getFreight());
		shipmentAOVO.setMawbNo(shipmentAODTO.getMawbNo());
		shipmentAOVO.setMawbDate(shipmentAODTO.getMawbDate());
		shipmentAOVO.setProjectCargo(shipmentAODTO.isProjectCargo());
		shipmentAOVO.setDirectMaster(shipmentAODTO.isDirectMaster());
		shipmentAOVO.setJobAssigned(shipmentAODTO.isJobAssigned());
		shipmentAOVO.setMasterFinalize(shipmentAODTO.isMasterFinalize());
		shipmentAOVO.setShipperInvoiceNo(shipmentAODTO.getShipperInvoiceNo());
		shipmentAOVO.setBillOfEntry(shipmentAODTO.getBillOfEntry());
		shipmentAOVO.setShipper(shipmentAODTO.getShipper());
		shipmentAOVO.setSAddType(shipmentAODTO.getSAddType());
		shipmentAOVO.setSAddress(shipmentAODTO.getSAddress());
		shipmentAOVO.setNotify(shipmentAODTO.getNotify());
		shipmentAOVO.setNAddType(shipmentAODTO.getNAddType());
		shipmentAOVO.setNAddress(shipmentAODTO.getNAddress());
		shipmentAOVO.setConsignee(shipmentAODTO.getConsignee());
		shipmentAOVO.setCaddType(shipmentAODTO.getCaddType());
		shipmentAOVO.setCAddress(shipmentAODTO.getCAddress());
		shipmentAOVO.setSalesCategory(shipmentAODTO.getSalesCategory());
		shipmentAOVO.setSalesPerson(shipmentAODTO.getSalesPerson());
		shipmentAOVO.setTotalNoOfPkgs(shipmentAODTO.getTotalNoOfPkgs());
		shipmentAOVO.setTotalGrtWt(shipmentAODTO.getTotalGrtWt());
		shipmentAOVO.setTotalChWt(shipmentAODTO.getTotalChWt());
		shipmentAOVO.setTotalVolWt(shipmentAODTO.getTotalVolWt());
		shipmentAOVO.setTotEstimationCost(shipmentAODTO.getTotEstimationCost());
		shipmentAOVO.setActive(shipmentAODTO.isActive());
		shipmentAOVO.setOrgId(shipmentAODTO.getOrgId());
		shipmentAOVO.setUpdatedBy(shipmentAODTO.getUpdatedBy());
		shipmentAOVO.setCreatedBy(shipmentAODTO.getCreatedBy());

	}


}
