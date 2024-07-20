package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.HouseAirWayBillVO;

@Repository
public interface HouseAirWayBillRepo extends JpaRepository<HouseAirWayBillVO, Long>{

	HouseAirWayBillVO findBySoNo(String docId);

}
