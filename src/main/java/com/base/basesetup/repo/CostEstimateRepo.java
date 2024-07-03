package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.CostEstimateVO;
import com.base.basesetup.entity.ShipmentAOVO;

@Repository
public interface CostEstimateRepo extends JpaRepository<CostEstimateVO, Long>{

	List<CostEstimateVO> findByShipmentAOVO(ShipmentAOVO shipmentAOVO);


}
