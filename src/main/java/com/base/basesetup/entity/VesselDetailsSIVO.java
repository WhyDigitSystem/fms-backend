package com.base.basesetup.entity;

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
@Table(name = "ef_sicarrier_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VesselDetailsSIVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sicarrier_dtlgen")
	@SequenceGenerator(name = "ef_sicarrier_dtlgen", sequenceName = "ef_sicarrier_dtlseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sicarrier_dtlid")
	private Long id;
	@Column(name = "type")
	private String type;
	@Column(name = "vesselname")
	private String vesselName;
	@Column(name = "voyage")
	private String voyage;
	@Column(name = "etd")
	private String etd;
	@Column(name = "etdtime")
	private LocalDate etdTime;
	@Column(name = "eta")
	private String eta;
	@Column(name = "etaTime")
	private LocalDate etaTime;
	@Column(name = "pol")
	private String pol;
	@Column(name = "pod")
	private String pod;
	
	@ManyToOne
	@JoinColumn(name = "t_sisohdrid")
	@JsonBackReference
	private PreAlertSIVO preAlertSIVO;
	
	@Embedded
	@Builder.Default
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

}
