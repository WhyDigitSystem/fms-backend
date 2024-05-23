package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.TermsAndConditionVO;

@Repository
public interface TermsAndConditionRepo extends JpaRepository<TermsAndConditionVO, Long>{

	@Query(nativeQuery = true,value = "select * from termsandcondition where termsandconditionid=?1")
	List<TermsAndConditionVO> getTermsAndConditionById(Long id);

	@Query(nativeQuery = true,value = "select * from termsandcondition where orgid=?1")
	List<TermsAndConditionVO> getTermsAndConditionByOrgId(Long orgid);

}
