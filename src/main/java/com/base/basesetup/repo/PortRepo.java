package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.basesetup.entity.PortVO;

public interface PortRepo extends JpaRepository<PortVO, Long>{

}
