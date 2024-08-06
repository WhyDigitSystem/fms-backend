package com.base.basesetup.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DocumentTypesVO;

@Repository
public interface DocumentTypesRepo extends JpaRepository<DocumentTypesVO, Long> {





	@Query(nativeQuery = true, value = "select * from documenttypes where documenttypesid=?1")
	List<DocumentTypesVO> findDocumentTypesById(Long id);

	@Query(nativeQuery = true, value = "select * from documenttypes where orgid=?1")
	List<DocumentTypesVO> findDocumentTypesByOrgId(Long orgid);

	

}
