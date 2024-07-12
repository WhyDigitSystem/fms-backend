package com.base.basesetup.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;

import com.base.basesetup.entity.HouseParticularsSIVO;
import com.base.basesetup.entity.PreAlertSIVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseParticularsSIDTO {
 
	private Long Id;
	private String houseNO;
	private LocalDate date;
	private String jobNo;
	private String jobBranch;
	private String closed;
	private Long pkgs;
	private BigDecimal grwt;
	private String volume;
	private String shipper;
	private String consignee;
	private String bro;
	private String notify;
	private String salesCategory;
	private String salesPerson;
	private String pod;
	private String fpod;
	private String incoterm;
	private String freight;
	private String industry;
	private String billOfEntry;
	private String itemDescription;
	
}
