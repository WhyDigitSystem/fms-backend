package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.SubTypesVO;

@Repository
public interface SubTypesRepo extends JpaRepository<SubTypesVO, Long>{

}
