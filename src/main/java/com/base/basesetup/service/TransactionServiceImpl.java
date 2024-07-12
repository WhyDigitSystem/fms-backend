package com.base.basesetup.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.basesetup.dto.AdvanceCanAiDTO;
import com.base.basesetup.dto.CarrierDetailsDTO;
import com.base.basesetup.dto.ChargeParticularDTO;
import com.base.basesetup.dto.ContainerAllocationSODTO;
import com.base.basesetup.dto.ContainerDetailsSIDTO;
import com.base.basesetup.dto.ContainerDetailsSODTO;
import com.base.basesetup.dto.CostEstimateDTO;
import com.base.basesetup.dto.DeclaredByDTO;
import com.base.basesetup.dto.HouseDetailsDTO;
import com.base.basesetup.dto.HouseParticularsAIDTO;
import com.base.basesetup.dto.HouseParticularsSIDTO;
import com.base.basesetup.dto.MasterAirWayBillDTO;
import com.base.basesetup.dto.PackingListDTO;
import com.base.basesetup.dto.PreAlertAIDTO;
import com.base.basesetup.dto.PreAlertCarrierDetailsAIDTO;
import com.base.basesetup.dto.PreAlertSIDTO;
import com.base.basesetup.dto.PrintDetailsDTO;
import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.dto.ShipmentAOFollowUpDTO;
import com.base.basesetup.dto.ShipmentSODTO;
import com.base.basesetup.dto.ShipmentSOFollowUpDTO;
import com.base.basesetup.dto.SoCostEstimateDTO;
import com.base.basesetup.dto.SoPackingListDTO;
import com.base.basesetup.dto.VesselDetailsSIDTO;
import com.base.basesetup.entity.AdvanceCanAiVO;
import com.base.basesetup.entity.CarrierDetailsVO;
import com.base.basesetup.entity.ChargeParticularVO;
import com.base.basesetup.entity.ContainerAllocationSOVO;
import com.base.basesetup.entity.ContainerDetailsSIVO;
import com.base.basesetup.entity.ContainerDetailsSOVO;
import com.base.basesetup.entity.CostEstimateVO;
import com.base.basesetup.entity.DeclaredByVO;
import com.base.basesetup.entity.HouseDetailsVO;
import com.base.basesetup.entity.HouseParticularsAIVO;
import com.base.basesetup.entity.HouseParticularsSIVO;
import com.base.basesetup.entity.MasterAirWayBillVO;
import com.base.basesetup.entity.PackingListVO;
import com.base.basesetup.entity.PreAlertAIVO;
import com.base.basesetup.entity.PreAlertCarrierDetailsAIVO;
import com.base.basesetup.entity.PreAlertSIVO;
import com.base.basesetup.entity.PrintDetailsVO;
import com.base.basesetup.entity.ShipmentAOVO;
import com.base.basesetup.entity.ShipmentSOVO;
import com.base.basesetup.entity.SoCostEstimateVO;
import com.base.basesetup.entity.SoPackingListVO;
import com.base.basesetup.entity.VesselDetailsSIVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.AdvanceCanAiRepo;
import com.base.basesetup.repo.CarrierDetailsRepo;
import com.base.basesetup.repo.ChargeParticularRepo;
import com.base.basesetup.repo.ContainerAllocationSORepo;
import com.base.basesetup.repo.ContainerDetailsSIRepo;
import com.base.basesetup.repo.ContainerDetailsSORepo;
import com.base.basesetup.repo.CostEstimateRepo;
import com.base.basesetup.repo.DeclaredByRepo;
import com.base.basesetup.repo.HouseDetailsRepo;
import com.base.basesetup.repo.HouseParticularsAIRepo;
import com.base.basesetup.repo.HouseParticularsSIRepo;
import com.base.basesetup.repo.MasterAirWayBillRepo;
import com.base.basesetup.repo.PackingListRepo;
import com.base.basesetup.repo.PreAlertAIRepo;
import com.base.basesetup.repo.PreAlertCarrierDetailsAIRepo;
import com.base.basesetup.repo.PreAlertSIRepo;
import com.base.basesetup.repo.PrintDetailsRepo;
import com.base.basesetup.repo.ShipmentAORepo;
import com.base.basesetup.repo.ShipmentSORepo;
import com.base.basesetup.repo.SoCostEstimateRepo;
import com.base.basesetup.repo.SoPackingListRepo;
import com.base.basesetup.repo.VesselDetailsSIRepo;

@Service
public class TransactionServiceImpl implements TransactionService{

	public static final Logger LOGGER = LoggerFactory.getLogger(BasicMasterServiceImpl.class);

	@Autowired
	ShipmentAORepo shipmentAORepo;
	
	@Autowired
	PackingListRepo packingListRepo;
	
	@Autowired
	CostEstimateRepo costEstimateRepo;
	
	@Autowired
	MasterAirWayBillRepo masterAirWayBillRepo;
	
	@Autowired
	HouseDetailsRepo houseDetailsRepo;
	
	@Autowired
	CarrierDetailsRepo carrierDetailsRepo;
	
	@Autowired
	DeclaredByRepo declaredByRepo;
	
	@Autowired
	PrintDetailsRepo printDetailsRepo;
	
	@Autowired
	PreAlertAIRepo preAlertAIRepo;
	
	@Autowired
	HouseParticularsAIRepo houseParticularsAIRepo;
	
	@Autowired
	PreAlertCarrierDetailsAIRepo preAlertCarrierDetailsAIRepo;
	
	@Autowired
	AdvanceCanAiRepo advanceCanAiRepo;
	
	@Autowired
	ChargeParticularRepo chargeParticulaRepo;
	
	@Autowired
	ShipmentSORepo shipmentSORepo;
	
	@Autowired
	SoPackingListRepo soPackingListRepo;
	
	@Autowired
	SoCostEstimateRepo soCostEstimateRepo;
	
	@Autowired
	ContainerAllocationSORepo containerAllocationSORepo;
	
	@Autowired
	ContainerDetailsSORepo containerDetailsSORepo;
	
	@Autowired
	PreAlertSIRepo preAlertSIRepo;
	
	@Autowired
	VesselDetailsSIRepo vesselDetailsSIRepo;

	@Autowired
	HouseParticularsSIRepo houseParticularsSIRepo;
	
	@Autowired
	ContainerDetailsSIRepo containerDetailsSIRepo;
	
	//ShipmentAO
	
	@Override
	public List<ShipmentAOVO> getShipmentAOById(Long id) {
			List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received  ShipmentAO BY Id : {}", id);
				shipmentAOVO = shipmentAORepo.findShipmentAOById(id);
			} else {
				LOGGER.info("Successfully Received  ShipmentAO For All Id.");
				shipmentAOVO = shipmentAORepo.findAll();
			}
			return shipmentAOVO;
		}

	@Override
	public List<ShipmentAOVO> getShipmentAOByOrgId(Long orgId) {
			List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(orgId)) {
				LOGGER.info("Successfully Received  ShipmentAO BY Id : {}", orgId);
				shipmentAOVO = shipmentAORepo.getShipmentAOByOrgId(orgId);
			} else {
				LOGGER.info("Successfully Received  ShipmentAO For All OrgId.");
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
			// Create a new shipmentAOVO instance if the doc ID is not present
			shipmentAOVO = new ShipmentAOVO();

			// Generate a new unique doc ID
			int docid = shipmentAORepo.finddocid(); // Ensure this method is correctly implemented to fetch the next
													// sequence value
			String docsid = "SH" + docid;
			shipmentAORepo.getbydocsid();
			shipmentAOVO.setDocId(docsid); // Assuming this sets the unique DOC ID to the ShipmentAOVO
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
	
	//ShipmentFollowUp
	
	@Override
	public List<ShipmentAOVO> getShipmentAOFollowUpById(Long id) {
			List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received  ShipmentAOFollowUp BY Id : {}", id);
				shipmentAOVO = shipmentAORepo.findShipmentAOFollowUpById(id);
			} else {
				LOGGER.info("Successfully Received  ShipperAOFollowUp For All Id.");
				shipmentAOVO = shipmentAORepo.findAll();
			}
			return shipmentAOVO;
		}
	
	@Override
	public List<ShipmentAOVO> getShipmentAOFollowUpByOrgId(Long orgId) {
			List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(orgId)) {
				LOGGER.info("Successfully Received  ShipmentAOFollowUp BY Id : {}", orgId);
				shipmentAOVO = shipmentAORepo.getShipmentAOFollowUpByOrgId(orgId);
			} else {
				LOGGER.info("Successfully Received  ShipmentAOFollowUp For All OrgId.");
				shipmentAOVO = shipmentAORepo.findAll();
			}
			return shipmentAOVO;
		}
	@Override
	public ShipmentAOVO updateCreateShipmentAOFollowUp(@Valid ShipmentAOFollowUpDTO shipmentAOFollowUpDTO) throws ApplicationException {
		ShipmentAOVO shipmentAOVO = new ShipmentAOVO();
		if (ObjectUtils.isNotEmpty(shipmentAOFollowUpDTO.getId())) {
			shipmentAOVO = shipmentAORepo.findById(shipmentAOFollowUpDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid ShipmentAO details"));
		}
		getShipmentAOVOFromShipmentFollowUpDTO(shipmentAOFollowUpDTO, shipmentAOVO);
		return shipmentAORepo.save(shipmentAOVO);

	}

	private void getShipmentAOVOFromShipmentFollowUpDTO(@Valid ShipmentAOFollowUpDTO shipmentAOFollowUpDTO, ShipmentAOVO shipmentAOVO) {
		shipmentAOVO.setDocDate(shipmentAOFollowUpDTO.getDocDate());
		shipmentAOVO.setGlobalShipNo(shipmentAOFollowUpDTO.getGlobalShipNo());
		shipmentAOVO.setPol(shipmentAOFollowUpDTO.getPol());
		shipmentAOVO.setPod(shipmentAOFollowUpDTO.getPod());
		shipmentAOVO.setJobNO(shipmentAOFollowUpDTO.getJobNO());
		shipmentAOVO.setJobDate(shipmentAOFollowUpDTO.getJobDate());
		shipmentAOVO.setFpod(shipmentAOFollowUpDTO.getFpod());
		shipmentAOVO.setNominatedBy(shipmentAOFollowUpDTO.getNominatedBy());
		shipmentAOVO.setHawbNO(shipmentAOFollowUpDTO.getHawbNO());
		shipmentAOVO.setHawbDate(shipmentAOFollowUpDTO.getHawbDate());
		shipmentAOVO.setDeliveryTerms(shipmentAOFollowUpDTO.getDeliveryTerms());
		shipmentAOVO.setFreight(shipmentAOFollowUpDTO.getFreight());
		shipmentAOVO.setMawbNo(shipmentAOFollowUpDTO.getMawbNo());
		shipmentAOVO.setMawbDate(shipmentAOFollowUpDTO.getMawbDate());
		shipmentAOVO.setProjectCargo(shipmentAOFollowUpDTO.isProjectCargo());
		shipmentAOVO.setDirectMaster(shipmentAOFollowUpDTO.isDirectMaster());
		shipmentAOVO.setJobAssigned(shipmentAOFollowUpDTO.isJobAssigned());
		shipmentAOVO.setMasterFinalize(shipmentAOFollowUpDTO.isMasterFinalize());
		shipmentAOVO.setShipperInvoiceNo(shipmentAOFollowUpDTO.getShipperInvoiceNo());
		shipmentAOVO.setBillOfEntry(shipmentAOFollowUpDTO.getBillOfEntry());
		shipmentAOVO.setShipper(shipmentAOFollowUpDTO.getShipper());
		shipmentAOVO.setSAddType(shipmentAOFollowUpDTO.getSAddType());
		shipmentAOVO.setSAddress(shipmentAOFollowUpDTO.getSAddress());
		shipmentAOVO.setNotify(shipmentAOFollowUpDTO.getNotify());
		shipmentAOVO.setNAddType(shipmentAOFollowUpDTO.getNAddType());
		shipmentAOVO.setNAddress(shipmentAOFollowUpDTO.getNAddress());
		shipmentAOVO.setConsignee(shipmentAOFollowUpDTO.getConsignee());
		shipmentAOVO.setCaddType(shipmentAOFollowUpDTO.getCaddType());
		shipmentAOVO.setCAddress(shipmentAOFollowUpDTO.getCAddress());
		shipmentAOVO.setSalesCategory(shipmentAOFollowUpDTO.getSalesCategory());
		shipmentAOVO.setSalesPerson(shipmentAOFollowUpDTO.getSalesPerson());
		shipmentAOVO.setTotalNoOfPkgs(shipmentAOFollowUpDTO.getTotalNoOfPkgs());
		shipmentAOVO.setTotalGrtWt(shipmentAOFollowUpDTO.getTotalGrtWt());
		shipmentAOVO.setTotalChWt(shipmentAOFollowUpDTO.getTotalChWt());
		shipmentAOVO.setTotalVolWt(shipmentAOFollowUpDTO.getTotalVolWt());
		shipmentAOVO.setTotEstimationCost(shipmentAOFollowUpDTO.getTotEstimationCost());
		shipmentAOVO.setActive(shipmentAOFollowUpDTO.isActive());
		shipmentAOVO.setOrgId(shipmentAOFollowUpDTO.getOrgId());
		shipmentAOVO.setUpdatedBy(shipmentAOFollowUpDTO.getUpdatedBy());
		shipmentAOVO.setCreatedBy(shipmentAOFollowUpDTO.getCreatedBy());
		shipmentAOVO.setShippingBill(shipmentAOFollowUpDTO.getShippingBill());
		shipmentAOVO.setDate(shipmentAOFollowUpDTO.getDate());
		shipmentAOVO.setDocumentReceived(shipmentAOFollowUpDTO.isDocumentReceived());
		shipmentAOVO.setPickUpDone(shipmentAOFollowUpDTO.isPickUpDone());
		shipmentAOVO.setCustomsClearanceDone(shipmentAOFollowUpDTO.isCustomsClearanceDone());
		shipmentAOVO.setDocumentReceiveddate(shipmentAOFollowUpDTO.getDocumentReceiveddate());
		shipmentAOVO.setPickUpDonedate(shipmentAOFollowUpDTO.getPickUpDonedate());
		shipmentAOVO.setCustomsClearanceDonedate(shipmentAOFollowUpDTO.getCustomsClearanceDonedate());


	}

	@Override
	public ShipmentAOVO getShipmentAOFollowUpByDocId(String docId) {
		return shipmentAORepo.getShipmentAOFollowUpByDocId(docId);
	}
	
	//MasterAirWayBill

	@Override
	public List<MasterAirWayBillVO> getMasterAirWayBillById(Long id) {
		List<MasterAirWayBillVO> masterAirWayBillVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  MasterAirWayBill BY Id : {}", id);
			masterAirWayBillVO = masterAirWayBillRepo.findMasterAirWayBillById(id);
		} else {
			LOGGER.info("Successfully Received  MasterAirWayBill For All Id.");
			masterAirWayBillVO = masterAirWayBillRepo.findAll();
		}
		return masterAirWayBillVO;
	}

	@Override
	public List<MasterAirWayBillVO> getMasterAirWayBillByOrgId(Long orgid) {
		List<MasterAirWayBillVO> masterAirWayBillVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  MasterAirWayBill BY OrgId : {}", orgid);
			masterAirWayBillVO = masterAirWayBillRepo.findMasterAirWayBillByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  MasterAirWayBill For All OrgId.");
			masterAirWayBillVO = masterAirWayBillRepo.findAll();
		}
		return masterAirWayBillVO;
	}

	@Override
	public MasterAirWayBillVO updateCreateMasterAirWayBill(@Valid MasterAirWayBillDTO masterAirWayBillDTO) throws ApplicationException {
		MasterAirWayBillVO masterAirWayBillVO = new MasterAirWayBillVO();
		if (ObjectUtils.isNotEmpty(masterAirWayBillDTO.getId())) {
			masterAirWayBillVO = masterAirWayBillRepo.findById(masterAirWayBillDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid masterAirWayBill details"));
		}
		
		getMasterAirWayBillVOFromMasterAirWayBillDTO(masterAirWayBillDTO, masterAirWayBillVO);
		masterAirWayBillVO = masterAirWayBillRepo.save(masterAirWayBillVO);

		List<HouseDetailsVO> houseDetailsVOList = houseDetailsRepo.findByMasterAirWayBillVO(masterAirWayBillVO);
		houseDetailsRepo.deleteAll(houseDetailsVOList);
		
		
		
		List<HouseDetailsVO> houseDetailsVOs = new ArrayList<>();
		if (masterAirWayBillDTO.getHouseDetailsDTO() != null) {
			for (HouseDetailsDTO houseDetailsDTO : masterAirWayBillDTO.getHouseDetailsDTO()) {

				HouseDetailsVO houseDetailsVO = new HouseDetailsVO();
				houseDetailsVO.setJobNo(houseDetailsDTO.getJobNo());
				houseDetailsVO.setHouseNo(houseDetailsDTO.getHouseNo());
				houseDetailsVO.setSNo(houseDetailsDTO.getSNo());
				houseDetailsVO.setHConsignee(houseDetailsDTO.getHConsignee());
				houseDetailsVO.setHShipper(houseDetailsDTO.getHShipper());
				houseDetailsVO.setPkgs(houseDetailsDTO.getPkgs());
				houseDetailsVO.setGrwt(houseDetailsDTO.getGrwt());
				houseDetailsVO.setChwt(houseDetailsDTO.getChwt());
				houseDetailsVO.setFpod(houseDetailsDTO.getFpod());
				houseDetailsVO.setJobRemarks(houseDetailsDTO.getJobRemarks());
				
				houseDetailsVO.setMasterAirWayBillVO(masterAirWayBillVO);
				houseDetailsVOs.add(houseDetailsVO);
			}
		}

		List<CarrierDetailsVO> carrierDetailsVOList = carrierDetailsRepo.findByMasterAirWayBillVO(masterAirWayBillVO);
		carrierDetailsRepo.deleteAll(carrierDetailsVOList);


		List<CarrierDetailsVO> carrierDetailsVOs = new ArrayList<>();
		if (masterAirWayBillDTO.getCarrierDetailsDTO() != null) {
			for (CarrierDetailsDTO carrierDetailsDTO : masterAirWayBillDTO.getCarrierDetailsDTO()) {

				CarrierDetailsVO carrierDetailsVO = new CarrierDetailsVO();
				carrierDetailsVO.setFrightNo(carrierDetailsDTO.getFrightNo());
				carrierDetailsVO.setEtd(carrierDetailsDTO.getEtd());
				carrierDetailsVO.setEtdTime(carrierDetailsDTO.getEtdTime());
				carrierDetailsVO.setEta(carrierDetailsDTO.getEta());
				carrierDetailsVO.setEtaTime(carrierDetailsDTO.getEtaTime());
				carrierDetailsVO.setPol(carrierDetailsDTO.getPol());
				carrierDetailsVO.setPod(carrierDetailsDTO.getPod());
				carrierDetailsVO.setMasterAirWayBillVO(masterAirWayBillVO);;
				carrierDetailsVOs.add(carrierDetailsVO);
			}
		}
		
		List<DeclaredByVO> declaredByVOList = declaredByRepo.findByMasterAirWayBillVO(masterAirWayBillVO);
		declaredByRepo.deleteAll(declaredByVOList);


		List<DeclaredByVO> declaredByVOs = new ArrayList<>();
		if (masterAirWayBillDTO.getDeclaredByDTO() != null) {
			for (DeclaredByDTO declaredByDTO : masterAirWayBillDTO.getDeclaredByDTO()) {

				DeclaredByVO declaredByVO = new DeclaredByVO();
				declaredByVO.setChargeType(declaredByDTO.getChargeType());
				declaredByVO.setCode(declaredByDTO.getCode());
				declaredByVO.setChargeCode(declaredByDTO.getChargeCode());
				declaredByVO.setChargeDesc(declaredByDTO.getChargeDesc());
				declaredByVO.setCurrency(declaredByDTO.getCurrency());
				declaredByVO.setExRate(declaredByDTO.getExRate());
				declaredByVO.setApplyOn(declaredByDTO.getApplyOn());
				declaredByVO.setQty(declaredByDTO.getQty());
				declaredByVO.setRate(declaredByDTO.getRate());
				declaredByVO.setFcAccount(declaredByDTO.getFcAccount());
				declaredByVO.setLcAccount(declaredByDTO.getLcAccount());
				declaredByVO.setPayTo(declaredByDTO.getPayTo());
				declaredByVO.setTerms(declaredByDTO.getTerms());
				declaredByVO.setMasterAirWayBillVO(masterAirWayBillVO);;
				declaredByVOs.add(declaredByVO);
			}
		}
		
		List<PrintDetailsVO> printDetailsVOList = printDetailsRepo.findByMasterAirWayBillVO(masterAirWayBillVO);
		printDetailsRepo.deleteAll(printDetailsVOList);


		List<PrintDetailsVO> printDetailsVOs = new ArrayList<>();
		if (masterAirWayBillDTO.getPrintDetailsDTO() != null) {
			for (PrintDetailsDTO printDetailsDTO : masterAirWayBillDTO.getPrintDetailsDTO()) {

				PrintDetailsVO printDetailsVO = new PrintDetailsVO();
				printDetailsVO.setCarrierDtl(printDetailsDTO.getCarrierDtl());;
				printDetailsVO.setAgentIata(printDetailsDTO.getAgentIata());
				printDetailsVO.setDeptAirport(printDetailsDTO.getDeptAirport());
				printDetailsVO.setDestAirport(printDetailsDTO.getDestAirport());
				printDetailsVO.setIataCarrier(printDetailsDTO.getIataCarrier());
				printDetailsVO.setSecondCarrier(printDetailsDTO.getSecondCarrier());
				printDetailsVO.setSecondCarrier1(printDetailsDTO.getSecondCarrier1());
				printDetailsVO.setThirdCarrier(printDetailsDTO.getThirdCarrier());
				printDetailsVO.setThirdcarrier1(printDetailsDTO.getThirdcarrier1());
				printDetailsVO.setMasterNo(printDetailsDTO.getMasterNo());
				printDetailsVO.setAccountInfo(printDetailsDTO.getAccountInfo());
				printDetailsVO.setAccountInfo(printDetailsDTO.getAccountInfo());
				printDetailsVO.setCarriage(printDetailsDTO.getCarriage());
				printDetailsVO.setCustomer(printDetailsDTO.getCustomer());
				printDetailsVO.setAccountNo(printDetailsDTO.getAccountNo());
				printDetailsVO.setReqFlight(printDetailsDTO.getReqFlight());
				printDetailsVO.setReqFlightDate(printDetailsDTO.getReqFlightDate());
				printDetailsVO.setHandingInfo(printDetailsDTO.getHandingInfo());
				printDetailsVO.setNoOfPcs(printDetailsDTO.getNoOfPcs());
				printDetailsVO.setTotalNoOfPcs(printDetailsDTO.getTotalNoOfPcs());
				printDetailsVO.setGrossWgt(printDetailsDTO.getGrossWgt());
				printDetailsVO.setTotalCrossWgt(printDetailsDTO.getTotalCrossWgt());
				printDetailsVO.setKgbl(printDetailsDTO.getKgbl());
				printDetailsVO.setRateclass(printDetailsDTO.getRateclass());
				printDetailsVO.setRateCharge(printDetailsDTO.getRateCharge());
				printDetailsVO.setChargeweight(printDetailsDTO.getChargeweight());
				printDetailsVO.setTotal(printDetailsDTO.getTotal());
				printDetailsVO.setSumOfTotal(printDetailsDTO.getSumOfTotal());
				printDetailsVO.setRemarks(printDetailsDTO.getRemarks());
				printDetailsVO.setPrintNotify1(printDetailsDTO.getPrintNotify1());
				printDetailsVO.setPrintNotify2(printDetailsDTO.getPrintNotify2());
				printDetailsVO.setMyc(printDetailsDTO.getMyc());
				printDetailsVO.setXdc(printDetailsDTO.getXdc());
				printDetailsVO.setAms(printDetailsDTO.getAms());
				printDetailsVO.setValch(printDetailsDTO.getValch());
				printDetailsVO.setTax(printDetailsDTO.getTax());
				printDetailsVO.setPpd(printDetailsDTO.getPpd());
				printDetailsVO.setXcr(printDetailsDTO.getXcr());
				printDetailsVO.setMdc(printDetailsDTO.getMdc());
				printDetailsVO.setAws(printDetailsDTO.getAws());
				printDetailsVO.setOthers(printDetailsDTO.getOthers());
				printDetailsVO.setDuoAgentCharge(printDetailsDTO.getDuoAgentCharge());
				printDetailsVO.setPreparedBy(printDetailsDTO.getPreparedBy());
				printDetailsVO.setMasterAirWayBillVO(masterAirWayBillVO);;
				printDetailsVOs.add(printDetailsVO);
			}
		}
	
		
		masterAirWayBillVO.setCarrierDetailsVO(carrierDetailsVOs);
		masterAirWayBillVO.setDeclaredByVO(declaredByVOs);
		masterAirWayBillVO.setHouseDetailsVO(houseDetailsVOs);
		masterAirWayBillVO.setPrintDetailsVO(printDetailsVOs);
		return masterAirWayBillRepo.save(masterAirWayBillVO);
	}

	private void getMasterAirWayBillVOFromMasterAirWayBillDTO(@Valid MasterAirWayBillDTO masterAirWayBillDTO,
			MasterAirWayBillVO masterAirWayBillVO) {
		masterAirWayBillVO.setCarrier(masterAirWayBillDTO.getCarrier());
		masterAirWayBillVO.setMawbNo(masterAirWayBillDTO.getMawbNo());		
		masterAirWayBillVO.setPol(masterAirWayBillDTO.getPol());		
		masterAirWayBillVO.setShipType(masterAirWayBillDTO.getShipType());		
		masterAirWayBillVO.setFrtCurrency(masterAirWayBillDTO.getFrtCurrency());		
		masterAirWayBillVO.setOtherDetails(masterAirWayBillDTO.getOtherDetails());		
		masterAirWayBillVO.setOnBoard(masterAirWayBillDTO.isOnBoard());		
		masterAirWayBillVO.setMawdDate(masterAirWayBillDTO.getMawdDate());		
		masterAirWayBillVO.setPod(masterAirWayBillDTO.getPod());		
		masterAirWayBillVO.setFreight(masterAirWayBillDTO.getFreight());		
		masterAirWayBillVO.setExRate(masterAirWayBillDTO.getExRate());		
		masterAirWayBillVO.setPreAlertSend(masterAirWayBillDTO.isPreAlertSend());		
		masterAirWayBillVO.setFinalized(masterAirWayBillDTO.isFinalized());		
		masterAirWayBillVO.setShipper(masterAirWayBillDTO.getShipper());		
		masterAirWayBillVO.setShipperAddType(masterAirWayBillDTO.getShipperAddType());		
		masterAirWayBillVO.setShipperaddress(masterAirWayBillDTO.getShipperaddress());		
		masterAirWayBillVO.setConsignee(masterAirWayBillDTO.getConsignee());		
		masterAirWayBillVO.setConsigneeAddType(masterAirWayBillDTO.getConsigneeAddType());		
		masterAirWayBillVO.setConsigneeAddress(masterAirWayBillDTO.getConsigneeAddress());		
		masterAirWayBillVO.setExecutingBranch(masterAirWayBillDTO.getExecutingBranch());		
		masterAirWayBillVO.setTotalHouseGrwt(masterAirWayBillDTO.getTotalHouseGrwt());		
		masterAirWayBillVO.setTotalNoOfPkgs(masterAirWayBillDTO.getTotalNoOfPkgs());		
		masterAirWayBillVO.setTotalHouseChWt(masterAirWayBillDTO.getTotalHouseChWt());		
		masterAirWayBillVO.setMasterChwt(masterAirWayBillDTO.getMasterChwt());		
		masterAirWayBillVO.setVolumeShare(masterAirWayBillDTO.getVolumeShare());	
		masterAirWayBillVO.setCreatedBy(masterAirWayBillDTO.getCreatedBy());		
		masterAirWayBillVO.setUpdatedBy(masterAirWayBillDTO.getUpdatedBy());		
		masterAirWayBillVO.setActive(masterAirWayBillDTO.isActive());		
		masterAirWayBillVO.setOrgId(masterAirWayBillDTO.getOrgId());		

		
	}
	
	//PreAlertAI

	@Override
	public List<PreAlertAIVO> getPreAlertAIById(Long id) {
		List<PreAlertAIVO> preAlertAIVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  PreAlertAI BY Id : {}", id);
			preAlertAIVO = preAlertAIRepo.findPreAlertById(id);
		} else {
			LOGGER.info("Successfully Received  PreAlertAI For All Id.");
			preAlertAIVO = preAlertAIRepo.findAll();
		}
		return preAlertAIVO;
	}

	@Override
	public List<PreAlertAIVO> getPreAlertAIByOrgId(Long orgid) {
		List<PreAlertAIVO> preAlertAIVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  PreAlertAI BY OrgId : {}", orgid);
			preAlertAIVO = preAlertAIRepo.findPreAlertByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  PreAlertAI For All OrgId.");
			preAlertAIVO = preAlertAIRepo.findAll();
		}
		return preAlertAIVO;
	}

	@Override
	public PreAlertAIVO updateCreatePreAlertAI(@Valid PreAlertAIDTO preAlertAIDTO) throws ApplicationException {
		PreAlertAIVO preAlertAIVO = new PreAlertAIVO();
		if (ObjectUtils.isNotEmpty(preAlertAIDTO.getId())) {
			preAlertAIVO = preAlertAIRepo.findById(preAlertAIDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid PreAlertAI details"));
		}
		getPreAlertAIVOFromPreAlertAIDTO(preAlertAIDTO, preAlertAIVO);
		preAlertAIVO = preAlertAIRepo.save(preAlertAIVO);
		
		
		List<HouseParticularsAIVO> houseParticularsVOList = houseParticularsAIRepo.findByPreAlertAIVO(preAlertAIVO);
		houseParticularsAIRepo.deleteAll(houseParticularsVOList);
		
		List<PreAlertCarrierDetailsAIVO> preAlertCarrierDetailsVOList = preAlertCarrierDetailsAIRepo.findByPreAlertAIVO(preAlertAIVO);
		preAlertCarrierDetailsAIRepo.deleteAll(preAlertCarrierDetailsVOList);
		
		List<HouseParticularsAIVO> houseParticularsAIVOs = new ArrayList<>();
		if (preAlertAIDTO.getHouseParticularsAIDTO() != null) {
			for (HouseParticularsAIDTO houseParticularsAIDTO : preAlertAIDTO.getHouseParticularsAIDTO()) {

				HouseParticularsAIVO houseParticularsAIVO = new HouseParticularsAIVO();
				houseParticularsAIVO.setHouseNO(houseParticularsAIDTO.getHouseNO());
				houseParticularsAIVO.setDate(houseParticularsAIDTO.getDate());
				houseParticularsAIVO.setJobNo(houseParticularsAIDTO.getJobNo());
				houseParticularsAIVO.setJobBranch(houseParticularsAIDTO.getJobBranch());
				houseParticularsAIVO.setClosed(houseParticularsAIDTO.getClosed());
				houseParticularsAIVO.setPkgs(houseParticularsAIDTO.getPkgs());
				houseParticularsAIVO.setGrwt(houseParticularsAIDTO.getGrwt());
				houseParticularsAIVO.setChwt(houseParticularsAIDTO.getChwt());
				houseParticularsAIVO.setShipper(houseParticularsAIDTO.getShipper());
				houseParticularsAIVO.setConsignee(houseParticularsAIDTO.getConsignee());
				houseParticularsAIVO.setBro(houseParticularsAIDTO.getBro());
				houseParticularsAIVO.setNotify(houseParticularsAIDTO.getNotify());
				houseParticularsAIVO.setSalesCategory(houseParticularsAIDTO.getSalesCategory());
				houseParticularsAIVO.setSalesPerson(houseParticularsAIDTO.getSalesPerson());
				houseParticularsAIVO.setPod(houseParticularsAIDTO.getPod());
				houseParticularsAIVO.setFpod(houseParticularsAIDTO.getFpod());
				houseParticularsAIVO.setIncoterm(houseParticularsAIDTO.getIncoterm());
				houseParticularsAIVO.setFreight(houseParticularsAIDTO.getFreight());
				houseParticularsAIVO.setIndustry(houseParticularsAIDTO.getIndustry());
				houseParticularsAIVO.setBillOfEntry(houseParticularsAIDTO.getBillOfEntry());
				houseParticularsAIVO.setItemDescription(houseParticularsAIDTO.getItemDescription());
				
				houseParticularsAIVO.setPreAlertAIVO(preAlertAIVO);;
				houseParticularsAIVOs.add(houseParticularsAIVO);
			}
		}
		

		List<PreAlertCarrierDetailsAIVO> preAlertCarrierDetailsVOS = new ArrayList<>();
		if (preAlertAIDTO.getPreAlertCarrierDetailsAIDTO() != null) {
			for (PreAlertCarrierDetailsAIDTO preAlertCarrierDetailsAIDTO : preAlertAIDTO.getPreAlertCarrierDetailsAIDTO()) {

				PreAlertCarrierDetailsAIVO preAlertCarrierDetailsAIVO = new PreAlertCarrierDetailsAIVO();
				preAlertCarrierDetailsAIVO.setAirLineCode(preAlertCarrierDetailsAIDTO.getAirLineCode());
				preAlertCarrierDetailsAIVO.setAirLineName(preAlertCarrierDetailsAIDTO.getAirLineName());
				preAlertCarrierDetailsAIVO.setFlightNo(preAlertCarrierDetailsAIDTO.getFlightNo());
				preAlertCarrierDetailsAIVO.setEta(preAlertCarrierDetailsAIDTO.getEta());
				preAlertCarrierDetailsAIVO.setEtaTime(preAlertCarrierDetailsAIDTO.getEtaTime());
				preAlertCarrierDetailsAIVO.setEtd(preAlertCarrierDetailsAIDTO.getEtd());
				preAlertCarrierDetailsAIVO.setEtdTime(preAlertCarrierDetailsAIDTO.getEtdTime());
				preAlertCarrierDetailsAIVO.setPol(preAlertCarrierDetailsAIDTO.getPol());
				preAlertCarrierDetailsAIVO.setPod(preAlertCarrierDetailsAIDTO.getPod());
				
				preAlertCarrierDetailsAIVO.setPreAlertAIVO(preAlertAIVO);;
				preAlertCarrierDetailsVOS.add(preAlertCarrierDetailsAIVO);
			}
		}
		
		preAlertAIVO.setHouseParticularsAIVO(houseParticularsAIVOs);;
		preAlertAIVO.setPreAlertCarrierDetailsAIVO(preAlertCarrierDetailsVOS);
		
		return preAlertAIRepo.save(preAlertAIVO);

	}

	private void getPreAlertAIVOFromPreAlertAIDTO(@Valid PreAlertAIDTO preAlertAIDTO, PreAlertAIVO preAlertAIVO) {
		preAlertAIVO.setDirect(preAlertAIDTO.isDirect());
		preAlertAIVO.setDocNo(preAlertAIDTO.getDocNo());
		preAlertAIVO.setDocDate(preAlertAIDTO.getDocDate());
		preAlertAIVO.setAirCarrier(preAlertAIDTO.getAirCarrier());
		preAlertAIVO.setDocNo(preAlertAIDTO.getDocNo());
		preAlertAIVO.setDocDate(preAlertAIDTO.getDocDate());
		preAlertAIVO.setAirCarrier(preAlertAIDTO.getAirCarrier());
		preAlertAIVO.setAirCarrierType(preAlertAIDTO.getAirCarrierType());
		preAlertAIVO.setFlightDate(preAlertAIDTO.getFlightDate());
		preAlertAIVO.setFlightTime(preAlertAIDTO.getFlightTime());
		preAlertAIVO.setMasterDate(preAlertAIDTO.getMasterDate());
		preAlertAIVO.setShipType(preAlertAIDTO.getShipType());
		preAlertAIVO.setGrWt(preAlertAIDTO.getGrWt());
		preAlertAIVO.setPol(preAlertAIDTO.getPol());
		preAlertAIVO.setDocDate1(preAlertAIDTO.getDocDate1());
		preAlertAIVO.setFlightNo(preAlertAIDTO.getFlightNo());
		preAlertAIVO.setMasterNo(preAlertAIDTO.getMasterNo());
		preAlertAIVO.setMasterNo1(preAlertAIDTO.getMasterNo1());
		preAlertAIVO.setNoOfPkgs(preAlertAIDTO.getNoOfPkgs());
		preAlertAIVO.setChWt(preAlertAIDTO.getChWt());
		preAlertAIVO.setPod(preAlertAIDTO.getPod());
		preAlertAIVO.setManifestDone(preAlertAIDTO.isManifestDone());
		preAlertAIVO.setJobAssigned(preAlertAIDTO.getJobAssigned());
		preAlertAIVO.setAgent(preAlertAIDTO.getAgent());
		preAlertAIVO.setConsignee(preAlertAIDTO.getConsignee());
		preAlertAIVO.setItemDescription(preAlertAIDTO.getItemDescription());
		preAlertAIVO.setIgmNo(preAlertAIDTO.getIgmNo());
		preAlertAIVO.setIgmNoDate(preAlertAIDTO.getIgmNoDate());
		preAlertAIVO.setDefFreightCurr(preAlertAIDTO.getDefFreightCurr());
		preAlertAIVO.setDefFreightCurr1(preAlertAIDTO.getDefFreightCurr1());
		preAlertAIVO.setMasterFreight(preAlertAIDTO.getMasterFreight());
		preAlertAIVO.setAirlineDoNo(preAlertAIDTO.getAirlineDoNo());
		preAlertAIVO.setSectorAwd(preAlertAIDTO.getSectorAwd());
		preAlertAIVO.setTotHousePkgs(preAlertAIDTO.getTotHousePkgs());
		preAlertAIVO.setTotHouseChWt(preAlertAIDTO.getTotHouseChWt());
		preAlertAIVO.setTotHouseGrwt(preAlertAIDTO.getTotHouseGrwt());
		preAlertAIVO.setUpdatedBy(preAlertAIDTO.getUpdatedBy());
		preAlertAIVO.setCreatedBy(preAlertAIDTO.getCreatedBy());
		preAlertAIVO.setOrgId(preAlertAIDTO.getOrgId());
		preAlertAIVO.setActive(preAlertAIDTO.isActive());
	}

	
	//AdvanceCanAiVO
	
	@Override
	public List<AdvanceCanAiVO> getAdvanceCanAiById(Long id) {
		List<AdvanceCanAiVO> advanceCanAiVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  AdvanceCanAi BY Id : {}", id);
			advanceCanAiVO = advanceCanAiRepo.findAdvanceCanAiById(id);
		} else {
			LOGGER.info("Successfully Received  AdvanceCanAi For All Id.");
			advanceCanAiVO = advanceCanAiRepo.findAll();
		}
		return advanceCanAiVO;
	}

	@Override
	public List<AdvanceCanAiVO> getAdvanceCanAiByOrgId(Long orgid) {
		List<AdvanceCanAiVO> advanceCanAiVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  AdvanceCanAi BY OrgId : {}", orgid);
			advanceCanAiVO = advanceCanAiRepo.findAdvanceCanAiByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  AdvanceCanAi For All OrgId.");
			advanceCanAiVO = advanceCanAiRepo.findAll();
		}
		return advanceCanAiVO;
	}

	@Override
	public AdvanceCanAiVO updateCreateAdvanceCanAi(@Valid AdvanceCanAiDTO advanceCanAiDTO) throws ApplicationException {
		AdvanceCanAiVO advanceCanAiVO = new AdvanceCanAiVO();
		if (ObjectUtils.isNotEmpty(advanceCanAiDTO.getId())) {
			advanceCanAiVO = advanceCanAiRepo.findById(advanceCanAiDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid AdvanceCanAi details"));
		}else {
			// Create a new shipmentAOVO instance if the doc ID is not present
			advanceCanAiVO = new AdvanceCanAiVO();

			// Generate a new unique doc ID
			int docid = advanceCanAiRepo.finddocid(); // Ensure this method is correctly implemented to fetch the next
													// sequence value
			String docsid = "AD" + docid;
			advanceCanAiRepo.getbydocsid();
			advanceCanAiVO.setDocId(docsid); // Assuming this sets the unique DOC ID to the ShipmentAOVO
		}
		
		getAdvanceCanAiVOFromAdvanceCanAiDTO(advanceCanAiDTO, advanceCanAiVO);
		advanceCanAiVO = advanceCanAiRepo.save(advanceCanAiVO);
 
		List<ChargeParticularVO> chargeParticularVOList = chargeParticulaRepo.findByAdvanceCanAiVO(advanceCanAiVO);
		chargeParticulaRepo.deleteAll(chargeParticularVOList);
		
		
		
		List<ChargeParticularVO> ChargeParticularVOs = new ArrayList<>();
		if (advanceCanAiDTO.getChargeParticularDTO() != null) {
			for (ChargeParticularDTO chargeParticularDTO : advanceCanAiDTO.getChargeParticularDTO()) {

				ChargeParticularVO ChargeParticularVO = new ChargeParticularVO();
				ChargeParticularVO.setType(chargeParticularDTO.getType());
				ChargeParticularVO.setChargeCode(chargeParticularDTO.getChargeCode());
				ChargeParticularVO.setChargeName(chargeParticularDTO.getChargeName());
				ChargeParticularVO.setTaxable(chargeParticularDTO.getTaxable());
				ChargeParticularVO.setCcf(chargeParticularDTO.getCcf());
				ChargeParticularVO.setApplyOn(chargeParticularDTO.getApplyOn());
				ChargeParticularVO.setRate(chargeParticularDTO.getRate());
				ChargeParticularVO.setCurrency(chargeParticularDTO.getCurrency());
				ChargeParticularVO.setExRate(chargeParticularDTO.getExRate());
				ChargeParticularVO.setFcAmount(chargeParticularDTO.getFcAmount());
				ChargeParticularVO.setLcAmount(chargeParticularDTO.getLcAmount());
				ChargeParticularVO.setBillAmount(chargeParticularDTO.getBillAmount());
				ChargeParticularVO.setAdvanceCanAiVO(advanceCanAiVO);;
				ChargeParticularVOs.add(ChargeParticularVO);
			}
		}
		
		advanceCanAiVO.setChargeParticularVO(ChargeParticularVOs);
		return advanceCanAiRepo.save(advanceCanAiVO);
	}

	private void getAdvanceCanAiVOFromAdvanceCanAiDTO(@Valid AdvanceCanAiDTO advanceCanAiDTO,
			AdvanceCanAiVO advanceCanAiVO) {
		advanceCanAiVO.setBillCurr(advanceCanAiDTO.getBillCurr());
		advanceCanAiVO.setBexRate(advanceCanAiDTO.getBexRate());
		advanceCanAiVO.setMasterNo(advanceCanAiDTO.getMasterNo());
		advanceCanAiVO.setTaxExempt(advanceCanAiDTO.isTaxExempt());
		advanceCanAiVO.setDocDate(advanceCanAiDTO.getDocDate());
		advanceCanAiVO.setHouseNo(advanceCanAiDTO.getHouseNo());
		advanceCanAiVO.setChargeScheme(advanceCanAiDTO.getChargeScheme());
		advanceCanAiVO.setBillOfEntry(advanceCanAiDTO.getBillOfEntry());
		advanceCanAiVO.setDefFrtCurr(advanceCanAiDTO.getDefFrtCurr());
		advanceCanAiVO.setDefFrtCurrType(advanceCanAiDTO.getDefFrtCurrType());
		advanceCanAiVO.setTotChWt(advanceCanAiDTO.getTotChWt());
		advanceCanAiVO.setTotGrWt(advanceCanAiDTO.getTotGrWt());
		advanceCanAiVO.setTotPkgs(advanceCanAiDTO.getTotPkgs());
		advanceCanAiVO.setUsd(advanceCanAiDTO.getUsd());
		advanceCanAiVO.setShipper(advanceCanAiDTO.getShipper());
		advanceCanAiVO.setSAddress(advanceCanAiDTO.getSAddress());
		advanceCanAiVO.setSAddType(advanceCanAiDTO.getSAddType());
		advanceCanAiVO.setConsignee(advanceCanAiDTO.getConsignee());
		advanceCanAiVO.setCAddress(advanceCanAiDTO.getCAddress());
		advanceCanAiVO.setCAddType(advanceCanAiDTO.getCAddType());
		advanceCanAiVO.setNotify(advanceCanAiDTO.getNotify());
		advanceCanAiVO.setNAddress(advanceCanAiDTO.getNAddress());
		advanceCanAiVO.setNAddType(advanceCanAiDTO.getNAddType());
		advanceCanAiVO.setBillToParty(advanceCanAiDTO.getBillToParty());
		advanceCanAiVO.setBAddress(advanceCanAiDTO.getBAddress());
		advanceCanAiVO.setBAddType(advanceCanAiDTO.getBAddType());
		advanceCanAiVO.setUpdatedBy(advanceCanAiDTO.getUpdatedBy());
		advanceCanAiVO.setCreatedBy(advanceCanAiDTO.getCreatedBy());
		advanceCanAiVO.setOrgId(advanceCanAiDTO.getOrgId());
		advanceCanAiVO.setActive(advanceCanAiDTO.isActive());

		
	}
	
	//ShipmentSO
	
	@Override
	public List<ShipmentSOVO> getShipmentSOById(Long id) {
			List<ShipmentSOVO> shipmentSOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received  ShipmentSO BY Id : {}", id);
				shipmentSOVO = shipmentSORepo.findShipmentSOById(id);
			} else {
				LOGGER.info("Successfully Received  ShipmentSO For All Id.");
				shipmentSOVO = shipmentSORepo.findAll();
			}
			return shipmentSOVO;
		}
	
	@Override
	public List<ShipmentSOVO> getShipmentSOByOrgId(Long orgId) {
			List<ShipmentSOVO> shipmentSOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(orgId)) {
				LOGGER.info("Successfully Received  ShipmentSO BY Id : {}", orgId);
				shipmentSOVO = shipmentSORepo.getShipmentSOByOrgId(orgId);
			} else {
				LOGGER.info("Successfully Received  ShipmentSO For All OrgId.");
				shipmentSOVO = shipmentSORepo.findAll();
			}
			return shipmentSOVO;
		}


	@Override
	public ShipmentSOVO updateCreateShipmentSO(@Valid ShipmentSODTO shipmentSODTO) throws ApplicationException {
		ShipmentSOVO shipmentSOVO = new ShipmentSOVO();
		if (ObjectUtils.isNotEmpty(shipmentSODTO.getId())) {
			shipmentSOVO = shipmentSORepo.findById(shipmentSODTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid ShipmentSO details"));
		}
		else {
			// Create a new shipmentAOVO instance if the doc ID is not present
			shipmentSOVO = new ShipmentSOVO();

			// Generate a new unique doc ID
			int docid = shipmentSORepo.finddocid(); // Ensure this method is correctly implemented to fetch the next
													// sequence value
			String docsid = "SO" + docid;
			shipmentSORepo.getbydocsid();
			shipmentSOVO.setDocId(docsid); // Assuming this sets the unique DOC ID to the ShipmentAOVO
		}
		
		getShipmentSOVOFromShipmentSODTO(shipmentSODTO, shipmentSOVO);
		shipmentSOVO = shipmentSORepo.save(shipmentSOVO);

		List<SoPackingListVO> soPackingListVO = soPackingListRepo.findByShipmentSOVO(shipmentSOVO);
		soPackingListRepo.deleteAll(soPackingListVO);

		List<SoPackingListVO> soPackingListVOs = new ArrayList<>();
		if (shipmentSODTO.getSoPackingListDTO() != null) {
			for (SoPackingListDTO soPackingListDTO : shipmentSODTO.getSoPackingListDTO()) {
				SoPackingListVO soPackingListVO1 = new SoPackingListVO();
				soPackingListVO1.setSIdNO(soPackingListDTO.getSIdNO());
				soPackingListVO1.setCustPoNo(soPackingListDTO.getCustPoNo());
				soPackingListVO1.setCustPoDt(soPackingListDTO.getCustPoDt());
				soPackingListVO1.setIndustry(soPackingListDTO.getIndustry());
				soPackingListVO1.setItemDescription(soPackingListDTO.getItemDescription());
				soPackingListVO1.setQty(soPackingListDTO.getQty());
				soPackingListVO1.setUom(soPackingListDTO.getUom());
				soPackingListVO1.setGrWt(soPackingListDTO.getGrWt());
				soPackingListVO1.setChWt(soPackingListDTO.getChWt());
				soPackingListVO1.setDimL(soPackingListDTO.getDimL());
				soPackingListVO1.setDimW(soPackingListDTO.getDimW());
				soPackingListVO1.setDimH(soPackingListDTO.getDimH());
				soPackingListVO1.setUnit(soPackingListDTO.getUnit());
				soPackingListVO1.setVolume(soPackingListDTO.getVolume());
				soPackingListVO1.setShipmentSOVO(shipmentSOVO);
				soPackingListVOs.add(soPackingListVO1);
			}
		}

		List<SoCostEstimateVO> soCostEstimateVOt = soCostEstimateRepo.findByShipmentSOVO(shipmentSOVO);
		soCostEstimateRepo.deleteAll(soCostEstimateVOt);
		
		List<SoCostEstimateVO> soCostEstimateVOs = new ArrayList<>();
		if (shipmentSODTO.getSoCostEstimateDTO() != null) {
			for (SoCostEstimateDTO soCostEstimateDTO : shipmentSODTO.getSoCostEstimateDTO()) {
				SoCostEstimateVO soCostEstimateVO1 = new SoCostEstimateVO();
				soCostEstimateVO1.setPartyVendor(soCostEstimateDTO.getPartyVendor());
				soCostEstimateVO1.setLinearCarrier(soCostEstimateDTO.getLinearCarrier());
				soCostEstimateVO1.setBillToCustomer(soCostEstimateDTO.getBillToCustomer());
				soCostEstimateVO1.setChargeCode(soCostEstimateDTO.getChargeCode());
				soCostEstimateVO1.setDescription(soCostEstimateDTO.getDescription());
				soCostEstimateVO1.setAmountInInr(soCostEstimateDTO.getAmountInInr());
				soCostEstimateVO1.setEstimatePayDate(soCostEstimateDTO.getEstimatePayDate());
				soCostEstimateVO1.setFunReqDate(soCostEstimateDTO.getFunReqDate());
				
				soCostEstimateVO1.setShipmentSOVO(shipmentSOVO);
				soCostEstimateVOs.add(soCostEstimateVO1);
			}
		}
		shipmentSOVO.setSoPackingListVO(soPackingListVOs);
		shipmentSOVO.setSoCostEstimateVO(soCostEstimateVOs);
		return shipmentSORepo.save(shipmentSOVO);

	}

	private void getShipmentSOVOFromShipmentSODTO(@Valid ShipmentSODTO shipmentSODTO, ShipmentSOVO shipmentSOVO) {
		shipmentSOVO.setDocDate(shipmentSODTO.getDocDate());
		shipmentSOVO.setGlobalShipNo(shipmentSODTO.getGlobalShipNo());
		shipmentSOVO.setPol(shipmentSODTO.getPol());
		shipmentSOVO.setPod(shipmentSODTO.getPod());
		shipmentSOVO.setJobNO(shipmentSODTO.getJobNO());
		shipmentSOVO.setJobDate(shipmentSODTO.getJobDate());
		shipmentSOVO.setFpod(shipmentSODTO.getFpod());
		shipmentSOVO.setNominatedBy(shipmentSODTO.getNominatedBy());
		shipmentSOVO.setHawbNO(shipmentSODTO.getHawbNO());
		shipmentSOVO.setHawbDate(shipmentSODTO.getHawbDate());
		shipmentSOVO.setDeliveryTerms(shipmentSODTO.getDeliveryTerms());
		shipmentSOVO.setFreight(shipmentSODTO.getFreight());
		shipmentSOVO.setMawbNo(shipmentSODTO.getMawbNo());
		shipmentSOVO.setMawbDate(shipmentSODTO.getMawbDate());
		shipmentSOVO.setProjectCargo(shipmentSODTO.isProjectCargo());
		shipmentSOVO.setDirectMaster(shipmentSODTO.isDirectMaster());
		shipmentSOVO.setJobAssigned(shipmentSODTO.isJobAssigned());
		shipmentSOVO.setMasterFinalize(shipmentSODTO.isMasterFinalize());
		shipmentSOVO.setShipperInvoiceNo(shipmentSODTO.getShipperInvoiceNo());
		shipmentSOVO.setBillOfEntry(shipmentSODTO.getBillOfEntry());
		shipmentSOVO.setShipper(shipmentSODTO.getShipper());
		shipmentSOVO.setSAddType(shipmentSODTO.getSAddType());
		shipmentSOVO.setSAddress(shipmentSODTO.getSAddress());
		shipmentSOVO.setNotify(shipmentSODTO.getNotify());
		shipmentSOVO.setNAddType(shipmentSODTO.getNAddType());
		shipmentSOVO.setNAddress(shipmentSODTO.getNAddress());
		shipmentSOVO.setConsignee(shipmentSODTO.getConsignee());
		shipmentSOVO.setCaddType(shipmentSODTO.getCaddType());
		shipmentSOVO.setCAddress(shipmentSODTO.getCAddress());
		shipmentSOVO.setSalesCategory(shipmentSODTO.getSalesCategory());
		shipmentSOVO.setSalesPerson(shipmentSODTO.getSalesPerson());
		shipmentSOVO.setTotalNoOfPkgs(shipmentSODTO.getTotalNoOfPkgs());
		shipmentSOVO.setTotalGrtWt(shipmentSODTO.getTotalGrtWt());
		shipmentSOVO.setTotalChWt(shipmentSODTO.getTotalChWt());
		shipmentSOVO.setTotalVolWt(shipmentSODTO.getTotalVolWt());
		shipmentSOVO.setTotEstimationCost(shipmentSODTO.getTotEstimationCost());
		shipmentSOVO.setActive(shipmentSODTO.isActive());
		shipmentSOVO.setOrgId(shipmentSODTO.getOrgId());
		shipmentSOVO.setUpdatedBy(shipmentSODTO.getUpdatedBy());
		shipmentSOVO.setCreatedBy(shipmentSODTO.getCreatedBy());
		

	}
	
 //SHIPMENTSO FOLLOWUP

	@Override
	public List<ShipmentSOVO> getShipmentSOFollowUpById(Long id) {
			List<ShipmentSOVO> shipmentSOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received  ShipmentSOFollowUp BY Id : {}", id);
				shipmentSOVO = shipmentSORepo.getShipmentSOFollowUpById(id);
			} else {
				LOGGER.info("Successfully Received  ShipmentSOFollowUp For All Id.");
				shipmentSOVO = shipmentSORepo.findAll();
			}
			return shipmentSOVO;
		}
	
	@Override
	public List<ShipmentSOVO> getShipmentSOFollowUpByOrgId(Long orgId) {
			List<ShipmentSOVO> shipmentSOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(orgId)) {
				LOGGER.info("Successfully Received  ShipmentSOFollowUp BY Id : {}", orgId);
				shipmentSOVO = shipmentSORepo.getShipmentSOFollowUpByOrgId(orgId);
			} else {
				LOGGER.info("Successfully Received  ShipmentSOFollowUp For All OrgId.");
				shipmentSOVO = shipmentSORepo.findAll();
			}
			return shipmentSOVO;
		}
	
	@Override
	public ShipmentSOVO updateCreateShipmentSOFollowUp(@Valid ShipmentSOFollowUpDTO shipmentSOFollowUpDTO) throws ApplicationException {
		ShipmentSOVO shipmentSOVO = new ShipmentSOVO();
		if (ObjectUtils.isNotEmpty(shipmentSOFollowUpDTO.getId())) {
			shipmentSOVO = shipmentSORepo.findById(shipmentSOFollowUpDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid ShipmentSO details"));
		}
		getShipmentSOVOFromShipmentSOFollowUpDTO(shipmentSOFollowUpDTO, shipmentSOVO);
		return shipmentSORepo.save(shipmentSOVO);

	}

	private void getShipmentSOVOFromShipmentSOFollowUpDTO(@Valid ShipmentSOFollowUpDTO shipmentSOFollowUpDTO, ShipmentSOVO shipmentSOVO) {
		shipmentSOVO.setDocDate(shipmentSOFollowUpDTO.getDocDate());
		shipmentSOVO.setGlobalShipNo(shipmentSOFollowUpDTO.getGlobalShipNo());
		shipmentSOVO.setPol(shipmentSOFollowUpDTO.getPol());
		shipmentSOVO.setPod(shipmentSOFollowUpDTO.getPod());
		shipmentSOVO.setJobNO(shipmentSOFollowUpDTO.getJobNO());
		shipmentSOVO.setJobDate(shipmentSOFollowUpDTO.getJobDate());
		shipmentSOVO.setFpod(shipmentSOFollowUpDTO.getFpod());
		shipmentSOVO.setNominatedBy(shipmentSOFollowUpDTO.getNominatedBy());
		shipmentSOVO.setHawbNO(shipmentSOFollowUpDTO.getHawbNO());
		shipmentSOVO.setHawbDate(shipmentSOFollowUpDTO.getHawbDate());
		shipmentSOVO.setDeliveryTerms(shipmentSOFollowUpDTO.getDeliveryTerms());
		shipmentSOVO.setFreight(shipmentSOFollowUpDTO.getFreight());
		shipmentSOVO.setMawbNo(shipmentSOFollowUpDTO.getMawbNo());
		shipmentSOVO.setMawbDate(shipmentSOFollowUpDTO.getMawbDate());
		shipmentSOVO.setProjectCargo(shipmentSOFollowUpDTO.isProjectCargo());
		shipmentSOVO.setDirectMaster(shipmentSOFollowUpDTO.isDirectMaster());
		shipmentSOVO.setJobAssigned(shipmentSOFollowUpDTO.isJobAssigned());
		shipmentSOVO.setMasterFinalize(shipmentSOFollowUpDTO.isMasterFinalize());
		shipmentSOVO.setShipperInvoiceNo(shipmentSOFollowUpDTO.getShipperInvoiceNo());
		shipmentSOVO.setBillOfEntry(shipmentSOFollowUpDTO.getBillOfEntry());
		shipmentSOVO.setShipper(shipmentSOFollowUpDTO.getShipper());
		shipmentSOVO.setSAddType(shipmentSOFollowUpDTO.getSAddType());
		shipmentSOVO.setSAddress(shipmentSOFollowUpDTO.getSAddress());
		shipmentSOVO.setNotify(shipmentSOFollowUpDTO.getNotify());
		shipmentSOVO.setNAddType(shipmentSOFollowUpDTO.getNAddType());
		shipmentSOVO.setNAddress(shipmentSOFollowUpDTO.getNAddress());
		shipmentSOVO.setConsignee(shipmentSOFollowUpDTO.getConsignee());
		shipmentSOVO.setCaddType(shipmentSOFollowUpDTO.getCaddType());
		shipmentSOVO.setCAddress(shipmentSOFollowUpDTO.getCAddress());
		shipmentSOVO.setSalesCategory(shipmentSOFollowUpDTO.getSalesCategory());
		shipmentSOVO.setSalesPerson(shipmentSOFollowUpDTO.getSalesPerson());
		shipmentSOVO.setTotalNoOfPkgs(shipmentSOFollowUpDTO.getTotalNoOfPkgs());
		shipmentSOVO.setTotalGrtWt(shipmentSOFollowUpDTO.getTotalGrtWt());
		shipmentSOVO.setTotalChWt(shipmentSOFollowUpDTO.getTotalChWt());
		shipmentSOVO.setTotalVolWt(shipmentSOFollowUpDTO.getTotalVolWt());
		shipmentSOVO.setTotEstimationCost(shipmentSOFollowUpDTO.getTotEstimationCost());
		shipmentSOVO.setActive(shipmentSOFollowUpDTO.isActive());
		shipmentSOVO.setOrgId(shipmentSOFollowUpDTO.getOrgId());
		shipmentSOVO.setUpdatedBy(shipmentSOFollowUpDTO.getUpdatedBy());
		shipmentSOVO.setCreatedBy(shipmentSOFollowUpDTO.getCreatedBy());
		shipmentSOVO.setShippingBill(shipmentSOFollowUpDTO.getShippingBill());
		shipmentSOVO.setDate(shipmentSOFollowUpDTO.getDate());
		shipmentSOVO.setDocumentReceived(shipmentSOFollowUpDTO.isDocumentReceived());
		shipmentSOVO.setPickUpDone(shipmentSOFollowUpDTO.isPickUpDone());
		shipmentSOVO.setCustomsClearanceDone(shipmentSOFollowUpDTO.isCustomsClearanceDone());
		shipmentSOVO.setDocumentReceiveddate(shipmentSOFollowUpDTO.getDocumentReceiveddate());
		shipmentSOVO.setPickUpDonedate(shipmentSOFollowUpDTO.getPickUpDonedate());
		shipmentSOVO.setCustomsClearanceDonedate(shipmentSOFollowUpDTO.getCustomsClearanceDonedate());

		
		shipmentSOVO.setContainerCount(shipmentSOFollowUpDTO.getContainerCount());
		shipmentSOVO.setCfcInwardDate(shipmentSOFollowUpDTO.getCfcInwardDate());
		shipmentSOVO.setContBookingDate(shipmentSOFollowUpDTO.getContBookingDate());
		shipmentSOVO.setEmptyContPickupDate(shipmentSOFollowUpDTO.getEmptyContPickupDate());
		shipmentSOVO.setStuffingDate(shipmentSOFollowUpDTO.getStuffingDate());
		shipmentSOVO.setRailmentDate(shipmentSOFollowUpDTO.getRailmentDate());
		shipmentSOVO.setContTerminalHandover(shipmentSOFollowUpDTO.getContTerminalHandover());
		shipmentSOVO.setCargoHandOver(shipmentSOFollowUpDTO.isCargoHandOver());
		shipmentSOVO.setCargoHandOverDate(shipmentSOFollowUpDTO.getCargoHandOverDate());
		shipmentSOVO.setEmptyContReturn(shipmentSOFollowUpDTO.isEmptyContReturn());
		shipmentSOVO.setEmptyContReturnDate(shipmentSOFollowUpDTO.getEmptyContReturnDate());
		shipmentSOVO.setEmptyContSurrender(shipmentSOFollowUpDTO.isEmptyContSurrender());
		shipmentSOVO.setEmptyContSurrenderDate(shipmentSOFollowUpDTO.getEmptyContSurrenderDate());
		shipmentSOVO.setContainerReturnCount(shipmentSOFollowUpDTO.getContainerReturnCount());
		shipmentSOVO.setEmptyReturnRemarks(shipmentSOFollowUpDTO.getEmptyReturnRemarks());



	}

	@Override
	public ShipmentSOVO getShipmentSOFollowUpByDocId(String docId) {
		return shipmentSORepo.getShipmentSOFollowUpByDocId(docId);
	}


	//ContainerAllocation
	
	@Override
	public List<ContainerAllocationSOVO> getContainerAllocationSOById(Long id) {
			List<ContainerAllocationSOVO> containerAllocationSOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received  containerAllocationSO BY Id : {}", id);
				containerAllocationSOVO = containerAllocationSORepo.findContainerAllocationSOById(id);
			} else {
				LOGGER.info("Successfully Received  containerAllocationSO For All Id.");
				containerAllocationSOVO = containerAllocationSORepo.findAll();
			}
			return containerAllocationSOVO;
		}
	
	@Override
	public List<ContainerAllocationSOVO> getContainerAllocationSOByOrgId(Long orgid) {
			List<ContainerAllocationSOVO> containerAllocationSOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(orgid)) {
				LOGGER.info("Successfully Received  containerAllocationSO BY OrgId : {}", orgid);
				containerAllocationSOVO = containerAllocationSORepo.findContainerAllocationSOByOrgId(orgid);
			} else {
				LOGGER.info("Successfully Received  containerAllocationSO For All OrgId.");
				containerAllocationSOVO = containerAllocationSORepo.findAll();
			}
			return containerAllocationSOVO;
		}
	
	@Override
	public ContainerAllocationSOVO updateCreateContainerAllocationSO(@Valid ContainerAllocationSODTO containerAllocationSODTO) throws ApplicationException {
		ContainerAllocationSOVO containerAllocationSOVO = new ContainerAllocationSOVO();
		if (ObjectUtils.isNotEmpty(containerAllocationSODTO.getId())) {
			containerAllocationSOVO = containerAllocationSORepo.findById(containerAllocationSODTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid ContainerAllocationSO details"));
		}
		
		getContainerAllocationSOVOFromContainerAllocationSODTO(containerAllocationSODTO, containerAllocationSOVO);
		containerAllocationSOVO = containerAllocationSORepo.save(containerAllocationSOVO);

		List<ContainerDetailsSOVO> containerDetailsSOVO = containerDetailsSORepo.findByContainerAllocationSOVO(containerAllocationSOVO);
		containerDetailsSORepo.deleteAll(containerDetailsSOVO);

		List<ContainerDetailsSOVO> containerDetailsSOVOs = new ArrayList<>();
		if (containerAllocationSODTO.getContainerDetailsSODTO() != null) {
			for (ContainerDetailsSODTO containerDetailsSODTO : containerAllocationSODTO.getContainerDetailsSODTO()) {
				ContainerDetailsSOVO containerDetailsVO1 = new ContainerDetailsSOVO();
				containerDetailsVO1.setContainerType(containerDetailsSODTO.getContainerType());
				containerDetailsVO1.setContainerNo(containerDetailsSODTO.getContainerNo());
				containerDetailsVO1.setSealNo(containerDetailsSODTO.getSealNo());
				containerDetailsVO1.setLoad(containerDetailsSODTO.getLoad());
				containerDetailsVO1.setQty(containerDetailsSODTO.getQty());
				containerDetailsVO1.setVolume(containerDetailsSODTO.getVolume());
				containerDetailsVO1.setPkgs(containerDetailsSODTO.getPkgs());
				containerDetailsVO1.setGrwt(containerDetailsSODTO.getGrwt());
				
				containerDetailsVO1.setContainerAllocationSOVO(containerAllocationSOVO);;
				containerDetailsSOVOs.add(containerDetailsVO1);
			}
		}

		
		containerAllocationSOVO.setContainerDetailsSOVO(containerDetailsSOVOs);;
		return containerAllocationSORepo.save(containerAllocationSOVO);

	}

	private void getContainerAllocationSOVOFromContainerAllocationSODTO(
			@Valid ContainerAllocationSODTO containerAllocationSODTO, ContainerAllocationSOVO containerAllocationSOVO) {
		containerAllocationSOVO.setDocId(containerAllocationSODTO.getDocId());
		containerAllocationSOVO.setDocDate(containerAllocationSODTO.getDocDate());
		containerAllocationSOVO.setGlobalShipNo(containerAllocationSODTO.getGlobalShipNo());
		containerAllocationSOVO.setPoNo(containerAllocationSODTO.getPoNo());
		containerAllocationSOVO.setJobNo(containerAllocationSODTO.getJobNo());
		containerAllocationSOVO.setPol(containerAllocationSODTO.getPol());
		containerAllocationSOVO.setPod(containerAllocationSODTO.getPod());
		containerAllocationSOVO.setHblNo(containerAllocationSODTO.getHblNo());
		containerAllocationSOVO.setFpod(containerAllocationSODTO.getFpod());
		containerAllocationSOVO.setNominatedBy(containerAllocationSODTO.getNominatedBy());
		containerAllocationSOVO.setMblNo(containerAllocationSODTO.getMblNo());
		containerAllocationSOVO.setDeliveryTerms(containerAllocationSODTO.getDeliveryTerms());
		containerAllocationSOVO.setFreight(containerAllocationSODTO.getFreight());
		containerAllocationSOVO.setDirectMaster(containerAllocationSODTO.isDirectMaster());
		containerAllocationSOVO.setMasterFinalized(containerAllocationSODTO.isMasterFinalized());
		containerAllocationSOVO.setTotGrWt(containerAllocationSODTO.getTotGrWt());
		containerAllocationSOVO.setTotPkgs(containerAllocationSODTO.getTotPkgs());
		containerAllocationSOVO.setTotVolWt(containerAllocationSODTO.getTotVolWt());
		containerAllocationSOVO.setFt20(containerAllocationSODTO.getFt20());
		containerAllocationSOVO.setFt40(containerAllocationSODTO.getFt40());
		containerAllocationSOVO.setFt45(containerAllocationSODTO.getFt45());
		containerAllocationSOVO.setCbm(containerAllocationSODTO.getCbm());
		
		containerAllocationSOVO.setCreatedBy(containerAllocationSODTO.getCreatedBy());
		containerAllocationSOVO.setUpdatedBy(containerAllocationSODTO.getUpdatedBy());
		containerAllocationSOVO.setOrgId(containerAllocationSODTO.getOrgId());
		containerAllocationSOVO.setActive(containerAllocationSODTO.isActive());
		
		
	}

	//PreAlertSI
	

	@Override
	public List<PreAlertSIVO> getPreAlertSIById(Long id) {
		List<PreAlertSIVO> preAlertSIVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  PreAlertSI BY Id : {}", id);
			preAlertSIVO = preAlertSIRepo.findPreAlertById(id);
		} else {
			LOGGER.info("Successfully Received  PreAlertSI For All Id.");
			preAlertSIVO = preAlertSIRepo.findAll();
		}
		return preAlertSIVO;
	}

	@Override
	public List<PreAlertSIVO> getPreAlertSIByOrgId(Long orgid) {
		List<PreAlertSIVO> preAlertSIVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  PreAlertSI BY OrgId : {}", orgid);
			preAlertSIVO = preAlertSIRepo.findPreAlertByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  PreAlertSI For All OrgId.");
			preAlertSIVO = preAlertSIRepo.findAll();
		}
		return preAlertSIVO;
	}

	@Override
	public PreAlertSIVO updateCreatePreAlertSI(@Valid PreAlertSIDTO preAlertSIDTO) throws ApplicationException {
		PreAlertSIVO preAlertSIVO = new PreAlertSIVO();
		if (ObjectUtils.isNotEmpty(preAlertSIDTO.getId())) {
			preAlertSIVO = preAlertSIRepo.findById(preAlertSIDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid PreAlertSI details"));
		}
		getPreAlertSIVOFromPreAlertSIDTO(preAlertSIDTO, preAlertSIVO);
		preAlertSIVO = preAlertSIRepo.save(preAlertSIVO);
		
		List<VesselDetailsSIVO> VesselDetailsSIVOList = vesselDetailsSIRepo.findByPreAlertSIVO(preAlertSIVO);
		vesselDetailsSIRepo.deleteAll(VesselDetailsSIVOList);
		
		List<HouseParticularsSIVO> houseParticularsSIVOList = houseParticularsSIRepo.findByPreAlertSIVO(preAlertSIVO);
		houseParticularsSIRepo.deleteAll(houseParticularsSIVOList);
		
		List<ContainerDetailsSIVO> containerDetailsSIVOList = containerDetailsSIRepo.findByPreAlertSIVO(preAlertSIVO);
		containerDetailsSIRepo.deleteAll(containerDetailsSIVOList);
		

		List<VesselDetailsSIVO> vesselDetailsSIVOs = new ArrayList<>();
		if (preAlertSIDTO.getVesselDetailsSIDTO() != null) {
			for (VesselDetailsSIDTO vesselDetailsSIDTO : preAlertSIDTO.getVesselDetailsSIDTO()) {

				VesselDetailsSIVO vesselDetailsSIVO = new VesselDetailsSIVO();
				vesselDetailsSIVO.setType(vesselDetailsSIDTO.getType());;
				vesselDetailsSIVO.setVesselName(vesselDetailsSIDTO.getVesselName());
				vesselDetailsSIVO.setVoyage(vesselDetailsSIDTO.getVoyage());
				vesselDetailsSIVO.setEta(vesselDetailsSIDTO.getEta());
				vesselDetailsSIVO.setEtaTime(vesselDetailsSIDTO.getEtaTime());
				vesselDetailsSIVO.setEtd(vesselDetailsSIDTO.getEtd());
				vesselDetailsSIVO.setEtdTime(vesselDetailsSIDTO.getEtdTime());
				vesselDetailsSIVO.setPol(vesselDetailsSIDTO.getPol());
				vesselDetailsSIVO.setPod(vesselDetailsSIDTO.getPod());
				
				vesselDetailsSIVO.setPreAlertSIVO(preAlertSIVO);;
				vesselDetailsSIVOs.add(vesselDetailsSIVO);
			}
		}
		

		List<HouseParticularsSIVO> houseParticularsSIVOs = new ArrayList<>();
		if (preAlertSIDTO.getHouseParticularsSIDTO() != null) {
			for (HouseParticularsSIDTO houseParticularsSIDTO : preAlertSIDTO.getHouseParticularsSIDTO()) {

				HouseParticularsSIVO houseParticularsSIVO = new HouseParticularsSIVO();
				houseParticularsSIVO.setHouseNO(houseParticularsSIDTO.getHouseNO());
				houseParticularsSIVO.setDate(houseParticularsSIDTO.getDate());
				houseParticularsSIVO.setJobNo(houseParticularsSIDTO.getJobNo());
				houseParticularsSIVO.setJobBranch(houseParticularsSIDTO.getJobBranch());
				houseParticularsSIVO.setClosed(houseParticularsSIDTO.getClosed());
				houseParticularsSIVO.setPkgs(houseParticularsSIDTO.getPkgs());
				houseParticularsSIVO.setGrwt(houseParticularsSIDTO.getGrwt());
				houseParticularsSIVO.setVolume(houseParticularsSIDTO.getVolume());
				houseParticularsSIVO.setShipper(houseParticularsSIDTO.getShipper());
				houseParticularsSIVO.setConsignee(houseParticularsSIDTO.getConsignee());
				houseParticularsSIVO.setBro(houseParticularsSIDTO.getBro());
				houseParticularsSIVO.setNotify(houseParticularsSIDTO.getNotify());
				houseParticularsSIVO.setSalesCategory(houseParticularsSIDTO.getSalesCategory());
				houseParticularsSIVO.setSalesPerson(houseParticularsSIDTO.getSalesPerson());
				houseParticularsSIVO.setPod(houseParticularsSIDTO.getPod());
				houseParticularsSIVO.setFpod(houseParticularsSIDTO.getFpod());
				houseParticularsSIVO.setIncoterm(houseParticularsSIDTO.getIncoterm());
				houseParticularsSIVO.setFreight(houseParticularsSIDTO.getFreight());
				houseParticularsSIVO.setIndustry(houseParticularsSIDTO.getIndustry());
				houseParticularsSIVO.setBillOfEntry(houseParticularsSIDTO.getBillOfEntry());
				houseParticularsSIVO.setItemDescription(houseParticularsSIDTO.getItemDescription());
				
				houseParticularsSIVO.setPreAlertSIVO(preAlertSIVO);;
				houseParticularsSIVOs.add(houseParticularsSIVO);
			}
		}
		
		List<ContainerDetailsSIVO> containerDetailsSIVOs = new ArrayList<>();
		if (preAlertSIDTO.getContainerDetailsSIDTO() != null) {
			for (ContainerDetailsSIDTO containerDetailsSIDTO : preAlertSIDTO.getContainerDetailsSIDTO()) {

				ContainerDetailsSIVO containerDetailsSIVO = new ContainerDetailsSIVO();
				containerDetailsSIVO.setContainerNo(containerDetailsSIDTO.getContainerNo());;
				containerDetailsSIVO.setContainerType(containerDetailsSIDTO.getContainerType());
				containerDetailsSIVO.setContainerWt(containerDetailsSIDTO.getContainerWt());
				containerDetailsSIVO.setPkgs(containerDetailsSIDTO.getPkgs());
				containerDetailsSIVO.setGrwt(containerDetailsSIDTO.getGrwt());
				containerDetailsSIVO.setMLineNo(containerDetailsSIDTO.getMLineNo());
				containerDetailsSIVO.setSLineNo(containerDetailsSIDTO.getSLineNo());
				containerDetailsSIVO.setSealNo(containerDetailsSIDTO.getSealNo());
				
				containerDetailsSIVO.setPreAlertSIVO(preAlertSIVO);;
				containerDetailsSIVOs.add(containerDetailsSIVO);
			}
		}
		preAlertSIVO.setVesselDetailsSIVO(vesselDetailsSIVOs);
		preAlertSIVO.setHouseParticularsSIVO(houseParticularsSIVOs);;
		preAlertSIVO.setContainerDetailsSIVO(containerDetailsSIVOs);
		
		return preAlertSIRepo.save(preAlertSIVO);
		
	}

	private void getPreAlertSIVOFromPreAlertSIDTO(@Valid PreAlertSIDTO preAlertSIDTO, PreAlertSIVO preAlertSIVO) {
		preAlertSIVO.setDirect(preAlertSIDTO.isDirect());
		preAlertSIVO.setAutoEdi(preAlertSIDTO.isAutoEdi());
		preAlertSIVO.setDocNo(preAlertSIDTO.getDocNo());
		preAlertSIVO.setDocDate(preAlertSIDTO.getDocDate());
		preAlertSIVO.setManifestDone(preAlertSIDTO.isManifestDone());
		preAlertSIVO.setManifestNo(preAlertSIDTO.getManifestNo());
		preAlertSIVO.setJobAssigned(preAlertSIDTO.isJobAssigned());
		preAlertSIVO.setSmptNo(preAlertSIDTO.getSmptNo());
		preAlertSIVO.setSeaCarrier(preAlertSIDTO.getSeaCarrier());
		preAlertSIVO.setItemDescription(preAlertSIDTO.getItemDescription());
		preAlertSIVO.setMasterNo(preAlertSIDTO.getMasterNo());
		preAlertSIVO.setMasterDate(preAlertSIDTO.getMasterDate());
		preAlertSIVO.setIgmNo(preAlertSIDTO.getIgmNo());
		preAlertSIVO.setIgmDate(preAlertSIDTO.getIgmDate());
		preAlertSIVO.setMasterFreight(preAlertSIDTO.getMasterFreight());
		preAlertSIVO.setVesselEta(preAlertSIDTO.getVesselEta());
		preAlertSIVO.setLocalIgmNo(preAlertSIDTO.getLocalIgmNo());
		preAlertSIVO.setLocalIgmDate(preAlertSIDTO.getLocalIgmDate());
		preAlertSIVO.setNoOfPkgs(preAlertSIDTO.getNoOfPkgs());
		preAlertSIVO.setGrwtInKgs(preAlertSIDTO.getGrwtInKgs());
		preAlertSIVO.setDefFreightCurr(preAlertSIDTO.getDefFreightCurr());
		preAlertSIVO.setDefFreightCurr1(preAlertSIDTO.getDefFreightCurr1());
		preAlertSIVO.setPol(preAlertSIDTO.getPol());
		preAlertSIVO.setPod(preAlertSIDTO.getPod());
		preAlertSIVO.setCfs(preAlertSIDTO.getCfs());
		preAlertSIVO.setContainerAllocationDone(preAlertSIDTO.isContainerAllocationDone());
		preAlertSIVO.setAgent(preAlertSIDTO.getAgent());
		preAlertSIVO.setConsignee(preAlertSIDTO.getConsignee());
		preAlertSIVO.setTotPkgs(preAlertSIDTO.getTotPkgs());
		preAlertSIVO.setTotGrwt(preAlertSIDTO.getTotGrwt());
		preAlertSIVO.setTotVolume(preAlertSIDTO.getTotVolume());
		preAlertSIVO.setEta1(preAlertSIDTO.getEta1());
		preAlertSIVO.setContainerReturnCount(preAlertSIDTO.getContainerReturnCount());
		preAlertSIVO.setEmptyReturnCount(preAlertSIDTO.getEmptyReturnCount());
		preAlertSIVO.setEmptyContReturn(preAlertSIDTO.isEmptyContReturn());
		preAlertSIVO.setEmptyContSurrender(preAlertSIDTO.isEmptyContSurrender());
		preAlertSIVO.setCargoHandOver(preAlertSIDTO.isCargoHandOver());
		preAlertSIVO.setContainerCount(preAlertSIDTO.getContainerCount());
		preAlertSIVO.setOrgId(preAlertSIDTO.getOrgId());
		preAlertSIVO.setActive(preAlertSIDTO.isActive());
		preAlertSIVO.setUpdatedBy(preAlertSIDTO.getUpdatedBy());
		preAlertSIVO.setCreatedBy(preAlertSIDTO.getCreatedBy());
		
		
		
	}
	

}
