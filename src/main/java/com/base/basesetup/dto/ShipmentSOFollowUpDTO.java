package com.base.basesetup.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentSOFollowUpDTO {

	
	private String docId;
	private boolean documentReceived;
	private boolean pickUpDone;
	private boolean customsClearanceDone;
	private LocalDate documentReceiveddate;
	private LocalDate pickUpDonedate;
	private LocalDate customsClearanceDonedate;
	private Long containerCount;
	private LocalDate cfcInwardDate;
	private LocalDate contBookingDate;
	private LocalDate emptyContPickupDate;
	private LocalDate stuffingDate;
	private LocalDate railmentDate;
	private LocalDate contTerminalHandover;	
	private boolean cargoHandOver;
	private LocalDate cargoHandOverDate;
	private boolean emptyContReturn;
	private LocalDate emptyContReturnDate;
	private boolean emptyContSurrender;
	private LocalDate emptyContSurrenderDate;
	private Long containerReturnCount;
	private String emptyReturnRemarks;
	
	private String shippingBill;
	private LocalDate date;
	
	
}
