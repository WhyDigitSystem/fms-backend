package com.base.basesetup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SegmentDTO {
	private Long id;
	private String segmentName;
	private String segmentDescription;
	private Long orgId;

}
