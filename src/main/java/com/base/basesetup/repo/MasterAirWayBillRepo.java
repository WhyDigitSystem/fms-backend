package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.base.basesetup.entity.MasterAirWayBillVO;

public interface MasterAirWayBillRepo extends JpaRepository<MasterAirWayBillVO, Long>{

	@Query(nativeQuery = true, value = "select * from ef_aemasterhdr where ef_aemasterhdrid=?1")
	List<MasterAirWayBillVO> findMasterAirWayBillById(Long id);

	@Query(nativeQuery = true, value = "select * from ef_aemasterhdr where orgid=?1")
	List<MasterAirWayBillVO> findMasterAirWayBillByOrgId(Long orgid);

}
