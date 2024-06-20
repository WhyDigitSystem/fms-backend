package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.GstInVO;

@Repository
public interface GstInRepo extends JpaRepository<GstInVO, Long>{
	
	@Query(nativeQuery = true, value = "select * from gstin where gstinid=?1")
	List<GstInVO> getGstInById(Long id);

	@Query(nativeQuery = true, value = "select * from gstin where orgid=?1")
	List<GstInVO> getGstInByOrgId(Long orgid);

	boolean existsByPanNameAndOrgId(String panName, Long orgId);

	boolean existsByPartyNameAndOrgId(String partyName, Long id);

}
