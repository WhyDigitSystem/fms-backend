package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ContainerAllocationSOVO;
import com.base.basesetup.entity.ContainerDetailsSOVO;

@Repository
public interface ContainerDetailsSORepo extends JpaRepository<ContainerDetailsSOVO, Long>{

	List<ContainerDetailsSOVO> findByContainerAllocationSOVO(ContainerAllocationSOVO containerAllocationSOVO);


}
