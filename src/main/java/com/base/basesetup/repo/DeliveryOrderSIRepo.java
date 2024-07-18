package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DeliveryOrderSIVO;

@Repository
public interface DeliveryOrderSIRepo extends JpaRepository<DeliveryOrderSIVO, Long>{

	@Query(nativeQuery = true, value = "select * from ef_sido where ef_sidoid=?1")
	List<DeliveryOrderSIVO> findDeliveryOrderSIById(Long id);

	@Query(nativeQuery = true, value = "select * from ef_sido where orgid=?1")
	List<DeliveryOrderSIVO> findDeliveryOrderSIByOrgId(Long orgid);

}
