package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.MasterAirWayBillVO;
import com.base.basesetup.entity.PrintDetailsVO;

@Repository
public interface PrintDetailsRepo extends JpaRepository<PrintDetailsVO, Long>{

	List<PrintDetailsVO> findByMasterAirWayBillVO(MasterAirWayBillVO masterAirWayBillVO);


}
