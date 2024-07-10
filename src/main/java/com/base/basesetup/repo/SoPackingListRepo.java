package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ShipmentSOVO;
import com.base.basesetup.entity.SoPackingListVO;

@Repository
public interface SoPackingListRepo extends JpaRepository<SoPackingListVO, Long> {

	List<SoPackingListVO> findByShipmentSOVO(ShipmentSOVO shipmentSOVO);

}
