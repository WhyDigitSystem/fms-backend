package com.base.basesetup.service;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.basesetup.dto.CompanySetupDTO;
import com.base.basesetup.entity.CompanySetupVO;
import com.base.basesetup.entity.OrganizationVO;
import com.base.basesetup.exception.ApplicationException;
import com.base.basesetup.repo.CompanySetupRepo;
import com.base.basesetup.repo.OrganizationRepo;

@Service
public class CompanySetupServiceImpl implements CompanySetupService {

	public static final Logger LOGGER = LoggerFactory.getLogger(BasicMasterServiceImpl.class);
	
	@Autowired
	CompanySetupRepo companySetupRepo;
	
	@Autowired
	OrganizationRepo organizationRepo;
	
//	@Override
//	public CompanySetupVO updateCreateCompanySetup(@Valid CompanySetupDTO companySetupDTO) throws ApplicationException {
//		CompanySetupVO companySetupVO = new CompanySetupVO();
//		if (ObjectUtils.isNotEmpty(companySetupDTO.getId())) {
//			companySetupVO = companySetupRepo.findById(companySetupDTO.getId())
//					.orElseThrow(() -> new ApplicationException("Invalid CompanySetup Details"));
//		}
//		getCompanySetupVOFromCompanySetupDTO(companySetupDTO, companySetupVO);
//		return companySetupRepo.save(companySetupVO);
//	}
//
//
//	private void getCompanySetupVOFromCompanySetupDTO(@Valid CompanySetupDTO companySetupDTO,
//			CompanySetupVO companySetupVO) {
//		// TODO Auto-generated method stub
//		OrganizationVO organizationVO = new OrganizationVO();
//		companySetupVO.setCompanyName(companySetupDTO.getCompanyName());
//		companySetupVO.setNoOfUser(companySetupDTO.getNoOfUser());
//		companySetupVO.setActive(companySetupDTO.isActive());
//		organizationVO.setId(companySetupVO.getId());
//		organizationRepo.save(organizationVO);
//		
//	}
	@Override
	public CompanySetupVO updateCreateCompanySetup(@Valid CompanySetupDTO companySetupDTO) throws ApplicationException {
	    CompanySetupVO companySetupVO ;

	    // Check if CompanySetupVO exists and retrieve it, otherwise create a new instance
	    if (ObjectUtils.isNotEmpty(companySetupDTO.getId())) {
	        companySetupVO = companySetupRepo.findById(companySetupDTO.getId())
	                .orElseThrow(() -> new ApplicationException("Invalid CompanySetup Details"));
	    } else {
	        companySetupVO = new CompanySetupVO();
	    }

	    // Transfer properties from DTO to VO
	    getCompanySetupVOFromCompanySetupDTO(companySetupDTO, companySetupVO);

	    // Save CompanySetupVO to ensure it has an ID if it's a new entity
	    companySetupVO = companySetupRepo.save(companySetupVO);

	    // Update or create OrganizationVO
	    saveOrUpdateOrganization(companySetupVO);

	    return companySetupVO;
	}

	private void getCompanySetupVOFromCompanySetupDTO(@Valid CompanySetupDTO companySetupDTO, CompanySetupVO companySetupVO) {
	    companySetupVO.setCompanyName(companySetupDTO.getCompanyName());
	    companySetupVO.setNoOfUser(companySetupDTO.getNoOfUser());
	    companySetupVO.setActive(companySetupDTO.isActive());
	}

	private void saveOrUpdateOrganization(CompanySetupVO companySetupVO) {
	    // Fetch existing OrganizationVO or create a new one
	    OrganizationVO organizationVO = organizationRepo.findById(companySetupVO.getId()).orElseGet(() -> new OrganizationVO());

	    // Set the ID and other necessary properties
	    organizationVO.setId(companySetupVO.getId());

	    // Save the OrganizationVO
	    organizationRepo.save(organizationVO);
	}


}
