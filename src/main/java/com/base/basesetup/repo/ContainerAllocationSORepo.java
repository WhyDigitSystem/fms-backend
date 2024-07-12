package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ContainerAllocationSOVO;

@Repository
public interface ContainerAllocationSORepo extends JpaRepository<ContainerAllocationSOVO, Long>{

	@Query(nativeQuery = true, value = "select * from ef_sesohdr where ef_sesohdrid=?1")
	List<ContainerAllocationSOVO> findContainerAllocationSOById(Long id);

	@Query(nativeQuery = true, value = "select * from ef_sesohdr where orgid=?1")
	List<ContainerAllocationSOVO> findContainerAllocationSOByOrgId(Long orgid);


}
