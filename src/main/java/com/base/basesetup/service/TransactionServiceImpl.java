package com.base.basesetup.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CarrierDetailsDTO;
import com.base.basesetup.dto.CostEstimateDTO;
import com.base.basesetup.dto.DeclaredByDTO;
import com.base.basesetup.dto.HouseDetailsDTO;
import com.base.basesetup.dto.HouseParticularsDTO;
import com.base.basesetup.dto.MasterAirWayBillDTO;
import com.base.basesetup.dto.PackingListDTO;
import com.base.basesetup.dto.PreAlertCarrierDetailsDTO;
import com.base.basesetup.dto.PreAlertDTO;
import com.base.basesetup.dto.PrintDetailsDTO;
import com.base.basesetup.dto.ShipmentAODTO;
import com.base.basesetup.dto.ShipmentFollowUpDTO;
import com.base.basesetup.entity.CarrierDetailsVO;
import com.base.basesetup.entity.CostEstimateVO;
import com.base.basesetup.entity.DeclaredByVO;
import com.base.basesetup.entity.HouseDetailsVO;
import com.base.basesetup.entity.HouseParticularsVO;
import com.base.basesetup.entity.MasterAirWayBillVO;
import com.base.basesetup.entity.PackingListVO;
import com.base.basesetup.entity.PreAlertCarrierDetailsVO;
import com.base.basesetup.entity.PreAlertVO;
import com.base.basesetup.entity.PrintDetailsVO;
import com.base.basesetup.entity.ShipmentAOVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.CarrierDetailsRepo;
import com.base.basesetup.repo.CostEstimateRepo;
import com.base.basesetup.repo.DeclaredByRepo;
import com.base.basesetup.repo.HouseDetailsRepo;
import com.base.basesetup.repo.HouseParticularsRepo;
import com.base.basesetup.repo.MasterAirWayBillRepo;
import com.base.basesetup.repo.PackingListRepo;
import com.base.basesetup.repo.PreAlertCarrierDetailsRepo;
import com.base.basesetup.repo.PreAlertRepo;
import com.base.basesetup.repo.PrintDetailsRepo;
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
	PreAlertRepo preAlertRepo;
	
	@Autowired
	HouseParticularsRepo houseParticularsRepo;
	
	@Autowired
	PreAlertCarrierDetailsRepo preAlertCarrierDetailsRepo;
	
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
	public List<ShipmentAOVO> getShipmentFollowUpById(Long id) {
			List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(id)) {
				LOGGER.info("Successfully Received  ShipmentFollowUp BY Id : {}", id);
				shipmentAOVO = shipmentAORepo.findShipmentFollowUpById(id);
			} else {
				LOGGER.info("Successfully Received  ShipperFollowUp For All Id.");
				shipmentAOVO = shipmentAORepo.findAll();
			}
			return shipmentAOVO;
		}
	
	@Override
	public List<ShipmentAOVO> getShipmentFollowUpByOrgId(Long orgId) {
			List<ShipmentAOVO> shipmentAOVO = new ArrayList<>();
			if (ObjectUtils.isNotEmpty(orgId)) {
				LOGGER.info("Successfully Received  ShipmentFollowUp BY Id : {}", orgId);
				shipmentAOVO = shipmentAORepo.getShipmentFollowUpByOrgId(orgId);
			} else {
				LOGGER.info("Successfully Received  ShipmentFollowUp For All OrgId.");
				shipmentAOVO = shipmentAORepo.findAll();
			}
			return shipmentAOVO;
		}
	@Override
	public ShipmentAOVO updateCreateShipmentFollowUp(@Valid ShipmentFollowUpDTO shipmentFollowUpDTO) throws ApplicationException {
		ShipmentAOVO shipmentAOVO = new ShipmentAOVO();
		if (ObjectUtils.isNotEmpty(shipmentFollowUpDTO.getId())) {
			shipmentAOVO = shipmentAORepo.findById(shipmentFollowUpDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid ShipmentAO details"));
		}
		getShipmentAOVOFromShipmentFollowUpDTO(shipmentFollowUpDTO, shipmentAOVO);
		return shipmentAORepo.save(shipmentAOVO);

	}

	private void getShipmentAOVOFromShipmentFollowUpDTO(@Valid ShipmentFollowUpDTO shipmentFollowUpDTO, ShipmentAOVO shipmentAOVO) {
		shipmentAOVO.setDocDate(shipmentFollowUpDTO.getDocDate());
		shipmentAOVO.setGlobalShipNo(shipmentFollowUpDTO.getGlobalShipNo());
		shipmentAOVO.setPol(shipmentFollowUpDTO.getPol());
		shipmentAOVO.setPod(shipmentFollowUpDTO.getPod());
		shipmentAOVO.setJobNO(shipmentFollowUpDTO.getJobNO());
		shipmentAOVO.setJobDate(shipmentFollowUpDTO.getJobDate());
		shipmentAOVO.setFpod(shipmentFollowUpDTO.getFpod());
		shipmentAOVO.setNominatedBy(shipmentFollowUpDTO.getNominatedBy());
		shipmentAOVO.setHawbNO(shipmentFollowUpDTO.getHawbNO());
		shipmentAOVO.setHawbDate(shipmentFollowUpDTO.getHawbDate());
		shipmentAOVO.setDeliveryTerms(shipmentFollowUpDTO.getDeliveryTerms());
		shipmentAOVO.setFreight(shipmentFollowUpDTO.getFreight());
		shipmentAOVO.setMawbNo(shipmentFollowUpDTO.getMawbNo());
		shipmentAOVO.setMawbDate(shipmentFollowUpDTO.getMawbDate());
		shipmentAOVO.setProjectCargo(shipmentFollowUpDTO.isProjectCargo());
		shipmentAOVO.setDirectMaster(shipmentFollowUpDTO.isDirectMaster());
		shipmentAOVO.setJobAssigned(shipmentFollowUpDTO.isJobAssigned());
		shipmentAOVO.setMasterFinalize(shipmentFollowUpDTO.isMasterFinalize());
		shipmentAOVO.setShipperInvoiceNo(shipmentFollowUpDTO.getShipperInvoiceNo());
		shipmentAOVO.setBillOfEntry(shipmentFollowUpDTO.getBillOfEntry());
		shipmentAOVO.setShipper(shipmentFollowUpDTO.getShipper());
		shipmentAOVO.setSAddType(shipmentFollowUpDTO.getSAddType());
		shipmentAOVO.setSAddress(shipmentFollowUpDTO.getSAddress());
		shipmentAOVO.setNotify(shipmentFollowUpDTO.getNotify());
		shipmentAOVO.setNAddType(shipmentFollowUpDTO.getNAddType());
		shipmentAOVO.setNAddress(shipmentFollowUpDTO.getNAddress());
		shipmentAOVO.setConsignee(shipmentFollowUpDTO.getConsignee());
		shipmentAOVO.setCaddType(shipmentFollowUpDTO.getCaddType());
		shipmentAOVO.setCAddress(shipmentFollowUpDTO.getCAddress());
		shipmentAOVO.setSalesCategory(shipmentFollowUpDTO.getSalesCategory());
		shipmentAOVO.setSalesPerson(shipmentFollowUpDTO.getSalesPerson());
		shipmentAOVO.setTotalNoOfPkgs(shipmentFollowUpDTO.getTotalNoOfPkgs());
		shipmentAOVO.setTotalGrtWt(shipmentFollowUpDTO.getTotalGrtWt());
		shipmentAOVO.setTotalChWt(shipmentFollowUpDTO.getTotalChWt());
		shipmentAOVO.setTotalVolWt(shipmentFollowUpDTO.getTotalVolWt());
		shipmentAOVO.setTotEstimationCost(shipmentFollowUpDTO.getTotEstimationCost());
		shipmentAOVO.setActive(shipmentFollowUpDTO.isActive());
		shipmentAOVO.setOrgId(shipmentFollowUpDTO.getOrgId());
		shipmentAOVO.setUpdatedBy(shipmentFollowUpDTO.getUpdatedBy());
		shipmentAOVO.setCreatedBy(shipmentFollowUpDTO.getCreatedBy());
		shipmentAOVO.setShippingBill(shipmentFollowUpDTO.getShippingBill());
		shipmentAOVO.setDate(shipmentFollowUpDTO.getDate());
		shipmentAOVO.setDocumentReceived(shipmentFollowUpDTO.isDocumentReceived());
		shipmentAOVO.setPickUpDone(shipmentFollowUpDTO.isPickUpDone());
		shipmentAOVO.setCustomsClearanceDone(shipmentFollowUpDTO.isCustomsClearanceDone());
		shipmentAOVO.setDocumentReceiveddate(shipmentFollowUpDTO.getDocumentReceiveddate());
		shipmentAOVO.setPickUpDonedate(shipmentFollowUpDTO.getPickUpDonedate());
		shipmentAOVO.setCustomsClearanceDonedate(shipmentFollowUpDTO.getCustomsClearanceDonedate());




	}

	@Override
	public ShipmentAOVO getShipmentFollowUpByDocId(String docId) {
		return shipmentAORepo.getShipmentFollowUpByDocId(docId);
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

	@Override
	public List<PreAlertVO> getPreAlertById(Long id) {
		List<PreAlertVO> preAlertVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(id)) {
			LOGGER.info("Successfully Received  PreAlert BY Id : {}", id);
			preAlertVO = preAlertRepo.findPreAlertById(id);
		} else {
			LOGGER.info("Successfully Received  PreAlert For All Id.");
			preAlertVO = preAlertRepo.findAll();
		}
		return preAlertVO;
	}

	@Override
	public List<PreAlertVO> getPreAlertByOrgId(Long orgid) {
		List<PreAlertVO> preAlertVO = new ArrayList<>();
		if (ObjectUtils.isNotEmpty(orgid)) {
			LOGGER.info("Successfully Received  PreAlert BY OrgId : {}", orgid);
			preAlertVO = preAlertRepo.findPreAlertByOrgId(orgid);
		} else {
			LOGGER.info("Successfully Received  PreAlert For All OrgId.");
			preAlertVO = preAlertRepo.findAll();
		}
		return preAlertVO;
	}

	@Override
	public PreAlertVO updateCreatePreAlert(@Valid PreAlertDTO preAlertDTO) throws ApplicationException {
		PreAlertVO preAlertVO = new PreAlertVO();
		if (ObjectUtils.isNotEmpty(preAlertDTO.getId())) {
			preAlertVO = preAlertRepo.findById(preAlertDTO.getId())
					.orElseThrow(() -> new ApplicationException("Invalid PreAlert details"));
		}
		getPreAlertVOFromPreAlertDTO(preAlertDTO, preAlertVO);
		preAlertVO = preAlertRepo.save(preAlertVO);
		
		
		List<HouseParticularsVO> houseParticularsVOList = houseParticularsRepo.findByPreAlertVO(preAlertVO);
		houseParticularsRepo.deleteAll(houseParticularsVOList);
		
		List<PreAlertCarrierDetailsVO> preAlertCarrierDetailsVOList = preAlertCarrierDetailsRepo.findByPreAlertVO(preAlertVO);
		preAlertCarrierDetailsRepo.deleteAll(preAlertCarrierDetailsVOList);
		
		List<HouseParticularsVO> houseParticularsVOs = new ArrayList<>();
		if (preAlertDTO.getHouseParticularsDTO() != null) {
			for (HouseParticularsDTO houseParticularsDTO : preAlertDTO.getHouseParticularsDTO()) {

				HouseParticularsVO houseParticularsVO = new HouseParticularsVO();
				houseParticularsVO.setHouseNO(houseParticularsDTO.getHouseNO());
				houseParticularsVO.setDate(houseParticularsDTO.getDate());
				houseParticularsVO.setJobNo(houseParticularsDTO.getJobNo());
				houseParticularsVO.setJobBranch(houseParticularsDTO.getJobBranch());
				houseParticularsVO.setClosed(houseParticularsDTO.getClosed());
				houseParticularsVO.setPkgs(houseParticularsDTO.getPkgs());
				houseParticularsVO.setGrwt(houseParticularsDTO.getGrwt());
				houseParticularsVO.setChwt(houseParticularsDTO.getChwt());
				houseParticularsVO.setShipper(houseParticularsDTO.getShipper());
				houseParticularsVO.setConsignee(houseParticularsDTO.getConsignee());
				houseParticularsVO.setBro(houseParticularsDTO.getBro());
				houseParticularsVO.setNotify(houseParticularsDTO.getNotify());
				houseParticularsVO.setSalesCategory(houseParticularsDTO.getSalesCategory());
				houseParticularsVO.setSalesPerson(houseParticularsDTO.getSalesPerson());
				houseParticularsVO.setPod(houseParticularsDTO.getPod());
				houseParticularsVO.setFpod(houseParticularsDTO.getFpod());
				houseParticularsVO.setIncoterm(houseParticularsDTO.getIncoterm());
				houseParticularsVO.setFreight(houseParticularsDTO.getFreight());
				houseParticularsVO.setIndustry(houseParticularsDTO.getIndustry());
				houseParticularsVO.setBillOfEntry(houseParticularsDTO.getBillOfEntry());
				houseParticularsVO.setItemDescription(houseParticularsDTO.getItemDescription());
				
				houseParticularsVO.setPreAlertVO(preAlertVO);;
				houseParticularsVOs.add(houseParticularsVO);
			}
		}
		

		List<PreAlertCarrierDetailsVO> preAlertCarrierDetailsVOS = new ArrayList<>();
		if (preAlertDTO.getPreAlertCarrierDetailsDTO() != null) {
			for (PreAlertCarrierDetailsDTO preAlertCarrierDetailsDTO : preAlertDTO.getPreAlertCarrierDetailsDTO()) {

				PreAlertCarrierDetailsVO preAlertCarrierDetailsVO = new PreAlertCarrierDetailsVO();
				preAlertCarrierDetailsVO.setAirLineCode(preAlertCarrierDetailsDTO.getAirLineCode());
				preAlertCarrierDetailsVO.setAirLineName(preAlertCarrierDetailsDTO.getAirLineName());
				preAlertCarrierDetailsVO.setFlightNo(preAlertCarrierDetailsDTO.getFlightNo());
				preAlertCarrierDetailsVO.setEta(preAlertCarrierDetailsDTO.getEta());
				preAlertCarrierDetailsVO.setEtaTime(preAlertCarrierDetailsDTO.getEtaTime());
				preAlertCarrierDetailsVO.setEtd(preAlertCarrierDetailsDTO.getEtd());
				preAlertCarrierDetailsVO.setEtdTime(preAlertCarrierDetailsDTO.getEtdTime());
				preAlertCarrierDetailsVO.setPol(preAlertCarrierDetailsDTO.getPol());
				preAlertCarrierDetailsVO.setPod(preAlertCarrierDetailsDTO.getPod());
				
				preAlertCarrierDetailsVO.setPreAlertVO(preAlertVO);;
				preAlertCarrierDetailsVOS.add(preAlertCarrierDetailsVO);
			}
		}
		
		preAlertVO.setHouseParticularsVO(houseParticularsVOs);;
		preAlertVO.setPreAlertCarrierDetailsVO(preAlertCarrierDetailsVOS);
		
		return preAlertRepo.save(preAlertVO);

	}

	private void getPreAlertVOFromPreAlertDTO(@Valid PreAlertDTO preAlertDTO, PreAlertVO preAlertVO) {
		preAlertVO.setDirect(preAlertDTO.isDirect());
		preAlertVO.setDocNo(preAlertDTO.getDocNo());
		preAlertVO.setDocDate(preAlertDTO.getDocDate());
		preAlertVO.setAirCarrier(preAlertDTO.getAirCarrier());
		preAlertVO.setDocNo(preAlertDTO.getDocNo());
		preAlertVO.setDocDate(preAlertDTO.getDocDate());
		preAlertVO.setAirCarrier(preAlertDTO.getAirCarrier());
		preAlertVO.setAirCarrierType(preAlertDTO.getAirCarrierType());
		preAlertVO.setFlightDate(preAlertDTO.getFlightDate());
		preAlertVO.setFlightTime(preAlertDTO.getFlightTime());
		preAlertVO.setMasterDate(preAlertDTO.getMasterDate());
		preAlertVO.setShipType(preAlertDTO.getShipType());
		preAlertVO.setGrWt(preAlertDTO.getGrWt());
		preAlertVO.setPol(preAlertDTO.getPol());
		preAlertVO.setDocDate1(preAlertDTO.getDocDate1());
		preAlertVO.setFlightNo(preAlertDTO.getFlightNo());
		preAlertVO.setMasterNo(preAlertDTO.getMasterNo());
		preAlertVO.setMasterNo1(preAlertDTO.getMasterNo1());
		preAlertVO.setNoOfPkgs(preAlertDTO.getNoOfPkgs());
		preAlertVO.setChWt(preAlertDTO.getChWt());
		preAlertVO.setPod(preAlertDTO.getPod());
		preAlertVO.setManifestDone(preAlertDTO.isManifestDone());
		preAlertVO.setJobAssigned(preAlertDTO.getJobAssigned());
		preAlertVO.setAgent(preAlertDTO.getAgent());
		preAlertVO.setConsignee(preAlertDTO.getConsignee());
		preAlertVO.setItemDescription(preAlertDTO.getItemDescription());
		preAlertVO.setIgmNo(preAlertDTO.getIgmNo());
		preAlertVO.setIgmNoDate(preAlertDTO.getIgmNoDate());
		preAlertVO.setDefFreightCurr(preAlertDTO.getDefFreightCurr());
		preAlertVO.setDefFreightCurr1(preAlertDTO.getDefFreightCurr1());
		preAlertVO.setMasterFreight(preAlertDTO.getMasterFreight());
		preAlertVO.setAirlineDoNo(preAlertDTO.getAirlineDoNo());
		preAlertVO.setSectorAwd(preAlertDTO.getSectorAwd());
		preAlertVO.setTotHousePkgs(preAlertDTO.getTotHousePkgs());
		preAlertVO.setTotHouseChWt(preAlertDTO.getTotHouseChWt());
		preAlertVO.setTotHouseGrwt(preAlertDTO.getTotHouseGrwt());
		preAlertVO.setUpdatedBy(preAlertDTO.getUpdatedBy());
		preAlertVO.setCreatedBy(preAlertDTO.getCreatedBy());
		preAlertVO.setOrgId(preAlertDTO.getOrgId());
		preAlertVO.setActive(preAlertDTO.isActive());
	}

	



}
