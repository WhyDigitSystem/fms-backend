package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PackingListVO;
import com.base.basesetup.entity.ShipmentAOVO;

@Repository
public interface PackingListRepo extends JpaRepository<PackingListVO, Long>{

	List<PackingListVO> findByShipmentAOVO(ShipmentAOVO shipmentAOVO);

}
