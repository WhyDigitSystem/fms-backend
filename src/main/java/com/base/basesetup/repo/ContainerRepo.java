package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ContainerVO;

@Repository
public interface ContainerRepo extends JpaRepository<ContainerVO, Long>{

}
