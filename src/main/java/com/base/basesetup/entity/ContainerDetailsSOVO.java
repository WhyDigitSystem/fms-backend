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
@Table(name="ef_sehcontainerdtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContainerDetailsSOVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sehcontainerdtlgen")
	@SequenceGenerator(name = "ef_sehcontainerdtlgen", sequenceName = "ef_sehcontainerdtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sehcontainerdtlid")
	private Long id;
	@Column(name = "containertype")
	private String containerType;
	@Column(name = "containerno")
	private String containerNo;
	@Column(name = "sealno")
	private String sealNo;
	@Column(name = "loadtype")
	private String load;
	@Column(name = "qty")
	private BigDecimal qty;
	@Column(name = "volume")
	private BigDecimal volume;
	@Column(name = "pkgs")
	private BigDecimal pkgs;
	@Column(name = "grwt")
	private BigDecimal grwt;
	
	@ManyToOne
	@JoinColumn(name = "ef_sesohdrid")
	@JsonBackReference
	private ContainerAllocationSOVO containerAllocationSOVO;
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

}
