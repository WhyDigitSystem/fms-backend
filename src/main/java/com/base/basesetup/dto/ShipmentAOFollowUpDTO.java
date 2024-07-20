package com.base.basesetup.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentAOFollowUpDTO {
	private String docId;
	private boolean documentReceived;
	private boolean pickUpDone;
	private boolean customsClearanceDone;
	private LocalDate documentReceiveddate;
	private LocalDate pickUpDonedate;
	private LocalDate customsClearanceDonedate;   
}
