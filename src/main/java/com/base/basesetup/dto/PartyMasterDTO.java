package com.base.basesetup.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyMasterDTO {
	private Long id;
	private String partyType;
	private String partyCode;
	private String partyName;
	private String gstPartyName;
	private String company;
	private String customerCategory;
	private String agentName;
	private String accountsType;
	private String bussinessType;
	private String carrierCode;
	private String supplierType;
	private String salesPerson;
	private String salesPerson1;
	private String customerCoordinator;
	private String customerCoordinator1;
	private String accountName;
	private String creditLimit;
	private String creditDays;
	private String controllingOffice;
	private String currency;
	private String airWayBillCode;
	private String airlineCode;
	private String bussinessCategory;
	private String bussinessCategory1;
	private String country;
	private String remarks;
	private String compoundingScheme;
	private String gstRegistration;
	private String panNo;
	private String panName;
	private String tanNo;
	private String caf;
	private String psu;
	
	private String nameOfBank;
	private String branch;
	private String addressOfBranch;
	private String accountNo;
	private String accounType;
	private String ifscCode;
	private String swift;

	private String createdBy;
	private String  updatedBy;
	private Long orgId;
    private boolean active;
    
    List<PartyStateDTO> partyStateDTO;
    List<PartyAddressDTO> partyAdressDTO;
    List<PartyDetailsOfDirectorsDTO> partyDetailsOfDirectorsDTO;
    List<PartySpecialTDSDTO> partySpecialTDSDTO;
    List<PartyChargesExemptionDTO> partyChargesExemptionDTO;
    List<PartyCurrencyMappingDTO> partyCurrencyMappingDTO;
    List<PartySalesPersonTaggingDTO> partySalesPersonTaggingDTO;
    List<PartyTdsExemptedDTO> partyTdsExemptedDTO;
    List<PartyPartnerTaggingDTO> partyPartnerTaggingDTO;
    List<PartyVendorEvaluationDTO> partyVendorEvaluationDTO;








}
