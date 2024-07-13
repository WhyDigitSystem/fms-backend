package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ContainerAllocationSIVO;
import com.base.basesetup.entity.ContainerDetailsVO;

@Repository
public interface ContainerDetailsRepo extends JpaRepository<ContainerDetailsVO, Long>{

	List<ContainerDetailsVO> findByContainerAllocationSIVO(ContainerAllocationSIVO containerAllocationSIVO);

}
