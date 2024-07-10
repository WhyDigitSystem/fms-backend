package com.base.basesetup.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_sesodtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoPackingListVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_sesodtlgen")
	@SequenceGenerator(name = "t_sesodtlgen", sequenceName = "t_sesodtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "t_aesodtlid")
	private Long id;
	@Column(name = "sidnO")
	private String sIdNO;
	@Column(name = "custpono")
	private String custPoNo;
	@Column(name = "custpodt")
	private String custPoDt;
	@Column(name = "industry")
	private String industry;
	@Column(name = "itemdescription")
	private String itemDescription;
	@Column(name = "qty")
	private int qty;
	@Column(name = "uom")
	private String uom;
	@Column(name = "grwt")
	private String grWt;
	@Column(name = "chwt")
	private String chWt;
	@Column(name = "diml")
	private BigDecimal dimL;
	@Column(name = "dimw")
	private BigDecimal dimW;
	@Column(name = "dimh")
	private BigDecimal dimH;
	@Column(name = "unit")
	private String unit;
	@Column(name = "volume")
	private BigDecimal volume;
	
	@ManyToOne
	@JoinColumn(name = "t_sesohdrid")
	@JsonBackReference
	private ShipmentSOVO shipmentSOVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	
}
