package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.CarrierDetailsVO;
import com.base.basesetup.entity.MasterAirWayBillVO;

@Repository
public interface CarrierDetailsRepo extends JpaRepository<CarrierDetailsVO, Long>{


	List<CarrierDetailsVO> findByMasterAirWayBillVO(MasterAirWayBillVO masterAirWayBillVO);

}
