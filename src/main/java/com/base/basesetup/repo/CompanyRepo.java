package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.CompanyVO;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyVO, Long> {

	@Query(nativeQuery = true,value = "select * from company where companyid=?1")
	List<CompanyVO> findCompanyById(Long id);
	
	@Query(nativeQuery = true,value = "select * from company where Orgid=?1")
	List<CompanyVO> findCompanyByOrgId(Long orgId);

}
