package com.base.basesetup.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.base.basesetup.dto.CreatedUpdatedDate;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ef_sehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseBillOfLadingVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ef_sehousegen")
	@SequenceGenerator(name = "ef_sehousegen", sequenceName = "ef_sehouseseq", initialValue = 1000000001, allocationSize = 1)
	@Column(name = "ef_sehouseid")
	private Long id;
	@Column(name = "hblno")
	private String hblNo;
	@Column(name = "hbldate")
	private LocalDate hbldate;
	@Column(name = "uwlhblno")
	private String uwlHblNo;
	@Column(name = "sino")
	private String siNo;
	@Column(name = "sidate")
	private LocalDate siDate;
	@Column(name = "jobno")
	private String jobNo;
	@Column(name = "jobdate")
	private LocalDate jobDate;
	@Column(name = "mblno")
	private String mblNo;
	@Column(name = "masterfinalized")
	private boolean masterFinalized;

	@Column(name = "active")
	private boolean active;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "modifiedby")
	private String updatedBy;
	@Column(name = "orgid")
	private Long orgId;
	@Column(name = "cancel")
	private boolean cancel;
	@Column(name = "cancelremarks")
	private boolean cancelRemarks;

	@OneToMany(mappedBy = "houseBillOfLadingVO", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<HouseAddressDetailsVO> houseAddressDetailsVO;

	@OneToMany(mappedBy = "houseBillOfLadingVO", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<HouseShipperParticularVO> houseShipperParticularVO;

	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}

}
