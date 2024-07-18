package com.base.basesetup.entity;

import java.math.BigDecimal;
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
@Table(name = "ef_scaninvoicehdr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceCanSIVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ef_scaninvoicehdrgen")
	@SequenceGenerator(name = "ef_scaninvoicehdrgen",sequenceName = "ef_scaninvoicehdrseq",initialValue = 1000000001,allocationSize = 1)
	@Column(name="ef_scaninvoicehdrid")
	private Long id;
	@Column(name = "docid")
	private String docId;
	@Column(name = "billcurr")
	private String billCurr;
	@Column(name = "bexrate")
	private BigDecimal bexRate;
	@Column(name = "masterno")
	private String masterNo;
	@Column(name = "taxexempt")
	private boolean taxExempt;
	@Column(name = "docdate")
	private LocalDate docDate;
	@Column(name = "houseNo")
	private String houseNo;
	@Column(name = "chargescheme")
	private String chargeScheme;
	@Column(name = "billofentry")
	private String billOfEntry;
	@Column(name = "deffrtcurrType")
	private String defFrtCurrType;
	@Column(name = "deffrtcurr")
	private BigDecimal defFrtCurr;
	@Column(name = "totpkgs")
	private Long totPkgs;
	@Column(name = "totgrwt")
	private BigDecimal totGrWt;
	@Column(name = "usd")
	private BigDecimal usd;
	
	@Column(name = "shipper")
	private String shipper;
	@Column(name = "saddtype")
	private String sAddType;
	@Column(name = "saddress")
	private String sAddress;
	@Column(name = "consignee")
	private String consignee;
	@Column(name = "caddtype")
	private String cAddType;
	@Column(name = "caddress")
	private String cAddress;
	@Column(name = "notify")
	private String notify;
	@Column(name = "naddtype")
	private String nAddType;
	@Column(name = "naddress")
	private String nAddress;
	@Column(name = "billtoparty")
	private String billToParty;
	@Column(name = "baddtype")
	private String bAddType;
	@Column(name = "baddress")
	private String bAddress;
	
	
    @Column(name="active")
    private boolean active;
    @Column(name="createdby")
    private String createdBy;
    @Column(name="modifiedby")
	private String updatedBy;
    @Column(name="orgid")
	private Long orgId;
    @Column(name="cancel")
	private boolean cancel;
    @Column(name="cancelremarks")
   	private boolean cancelRemarks;
    

	@OneToMany(mappedBy = "advanceCanSIVO",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ChargeParticularSIVO> chargeParticularSIVO;
	
	@Embedded
	private CreatedUpdatedDate commonDate = new CreatedUpdatedDate();

	@JsonGetter("active")
	public String getActive() {
		return active ? "Active" : "In-Active";
	}
}
