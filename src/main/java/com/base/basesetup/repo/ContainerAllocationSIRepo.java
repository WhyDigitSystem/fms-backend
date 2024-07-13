package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ContainerAllocationSIVO;

@Repository
public interface ContainerAllocationSIRepo extends JpaRepository<ContainerAllocationSIVO, Long>{

	@Query(nativeQuery = true, value = "select * from ef_sisohdr where ef_sisohdrid=?1")
	List<ContainerAllocationSIVO> findContainerAllocationSIById(Long id);

	@Query(nativeQuery = true, value = "select * from ef_sisohdr where orgid=?1")
	List<ContainerAllocationSIVO> findContainerAllocationSIByOrgId(Long orgid);

}
