package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DocumentTypeMappingVO;

@Repository
public interface DocumentTypeMappingRepo extends JpaRepository<DocumentTypeMappingVO, Long>{

}
