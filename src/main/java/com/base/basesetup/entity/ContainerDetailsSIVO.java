package com.base.basesetup.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "ef_sicontainer_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContainerDetailsSIVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sicontainer_dtlgen")
	@SequenceGenerator(name = "ef_sicontainer_dtlgen", sequenceName = "ef_sicontainer_dtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sicontainer_dtlid")
	private Long id;
	@Column(name = "containertype")
	private String containerType;
	@Column(name = "containerno")
	private String containerNo;
	@Column(name = "containerwt")
	private BigDecimal containerWt;
	@Column(name = "pkgs")
	private BigDecimal pkgs;
	@Column(name = "grwt")
	private BigDecimal grwt;
	@Column(name = "mlineno")
	private String mLineNo;
	@Column(name = "slineno")
	private String sLineNo;
	@Column(name = "sealno")
	private String sealNo;
	
	@ManyToOne
	@JoinColumn(name = "t_sisohdrid")
	@JsonBackReference
	private PreAlertSIVO preAlertSIVO;
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	
}
