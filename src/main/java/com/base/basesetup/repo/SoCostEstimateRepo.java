package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ShipmentSOVO;
import com.base.basesetup.entity.SoCostEstimateVO;

@Repository
public interface SoCostEstimateRepo extends JpaRepository<SoCostEstimateVO, Long> {

	List<SoCostEstimateVO> findByShipmentSOVO(ShipmentSOVO shipmentSOVO);

}
