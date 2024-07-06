package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.HouseDetailsVO;
import com.base.basesetup.entity.MasterAirWayBillVO;

@Repository
public interface HouseDetailsRepo extends JpaRepository<HouseDetailsVO, Long> {

	List<HouseDetailsVO> findByMasterAirWayBillVO(MasterAirWayBillVO masterAirWayBillVO);

}
