package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.base.basesetup.entity.PortVO;

public interface PortRepo extends JpaRepository<PortVO, Long>{

	@Query(nativeQuery = true, value = "select * from port where portid=?1")
	List<PortVO> getPortById(Long id);

	@Query(nativeQuery = true, value = "select * from port where orgid=?1")
	List<PortVO> getPortByOrgId(Long orgid);

	boolean existsByPortAndOrgId(String port, Long orgId);

	boolean existsByCodeAndOrgId(String code, Long orgId);

	boolean existsByPortAndOrgIdAndId(String port, Long orgId, Long id);

	boolean existsByCodeAndOrgIdAndId(String code, Long orgId, Long id);

	@Query(nativeQuery = true, value = "select * from port where active='1' AND country='india'AND type='air'")
	List<PortVO> findPolForShipmentAO();

	@Query(nativeQuery = true, value = "select * from port where active='1' AND NOT country='india'AND type='air'")
	List<PortVO> findPodForShipmentAO();

}
