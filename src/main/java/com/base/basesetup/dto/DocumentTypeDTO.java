package com.base.basesetup.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeDTO {

	private Long id;
	private String documentName;
	private String documentType;
	private String documentDescription;
	private String module;
	private String subModule;
	private String primaryTable;
	private String autoGenField;
	private String prefixField;
	private String documentCode;
	private String code;
	private String finyr;
	private String branch;
	private String prefix;
    private boolean financeTransaction;
    private boolean postFinance;
    private boolean noGeneration;
	private Long orgId;
	private String createdBy;
	private boolean active;
	
	private List<SubTypesDTO> subTypesDTO;
}
