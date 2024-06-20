package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DocumentTypeVO;

@Repository
public interface DocumentTypeRepo extends JpaRepository<DocumentTypeVO, Long>{

	@Query(nativeQuery = true, value = "select * from documenttype where documenttypeid=?1")
	List<DocumentTypeVO> getDocumentTypeById(Long id);

	@Query(nativeQuery = true, value = "select * from documenttype where orgid=?1")
	List<DocumentTypeVO> getDocumentTypeByOrgId(Long orgid);

	boolean existsByDocumentNameAndOrgId(String documentName, Long orgId);

	boolean existsByDocumentTypeAndOrgId(String documentType, Long orgId);

}
