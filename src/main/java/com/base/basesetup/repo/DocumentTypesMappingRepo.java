package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DocumentTypesMappingVO;

@Repository
public interface DocumentTypesMappingRepo extends JpaRepository<DocumentTypesMappingVO, Long>{

	@Query(nativeQuery = true, value = "select * from documenttypesmapping where documenttypesmappingid=?1")
	List<DocumentTypesMappingVO> findDocumentTypesMappingById(Long id);

	@Query(nativeQuery = true, value = "select * from documenttypesmapping where orgid=?1")
	List<DocumentTypesMappingVO> findDocumentTypesMappingByOrgId(Long orgid);

}
