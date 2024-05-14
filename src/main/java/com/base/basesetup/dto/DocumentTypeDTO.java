package com.base.basesetup.dto;

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
	private int code;
	private int finyr;
	private int branch;
	private String prefix;
	private Long orgId;

	
}
