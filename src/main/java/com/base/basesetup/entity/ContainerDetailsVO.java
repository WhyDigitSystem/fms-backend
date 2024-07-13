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
@Table(name = "ef_sihcontainerdtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContainerDetailsVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sihcontainerdtlgen")
	@SequenceGenerator(name = "ef_sihcontainerdtlgen", sequenceName = "ef_sihcontainerdtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sihcontainerdtlid")
	private Long id;
	@Column(name = "houseno")
	private String houseNo;
	@Column(name = "jobno")
	private String jobNo;
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
	@JoinColumn(name = "ef_sisohdrid")
	@JsonBackReference
	private ContainerAllocationSIVO containerAllocationSIVO;
	
	
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();



}
