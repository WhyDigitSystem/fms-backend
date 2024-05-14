package com.base.basesetup.dto;

import java.util.List;

import javax.persistence.Column;

import com.base.basesetup.entity.DocumentTypeVO;
import com.base.basesetup.entity.SubTypesVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeMappingDTO {

	private Long id;
	private String branch;
	private String financialYear;
	private Long orgId;

	
}
