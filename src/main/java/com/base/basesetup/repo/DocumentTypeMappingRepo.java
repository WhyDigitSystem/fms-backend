package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DocumentTypeMappingVO;

@Repository
public interface DocumentTypeMappingRepo extends JpaRepository<DocumentTypeMappingVO, Long>{

	@Query(nativeQuery = true, value = "select * from documenttypemapping where documenttypemappingid=?1")
	List<DocumentTypeMappingVO> getDocumentTypeMappingById(Long id);

	@Query(nativeQuery = true, value = "select * from documenttypemapping where orgid=?1")
	List<DocumentTypeMappingVO> getDocumentTypeMappingByOrgId(Long orgid);

	boolean existsByBranchAndOrgId(String branch, Long orgId);

	boolean existsByFinancialYearAndOrgId(String financialYear, Long orgId);

}
