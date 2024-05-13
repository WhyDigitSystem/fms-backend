package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.basesetup.entity.DesignationVO;


public interface DesignationRepo extends JpaRepository<DesignationVO, Long>{
}
