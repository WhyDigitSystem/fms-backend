package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DocumentTypeMappingVO;
import com.base.basesetup.entity.MappingVO;

@Repository
public interface MappingRepo extends JpaRepository<MappingVO, Long>{


	List<MappingVO> findByDocumentTypeMappingVO(DocumentTypeMappingVO documentTypeMappingVO);

}
