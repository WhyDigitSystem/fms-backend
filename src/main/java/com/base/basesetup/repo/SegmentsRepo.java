package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.SegmentsVO;

@Repository
public interface SegmentsRepo extends JpaRepository<SegmentsVO, Long>{

	@Query(nativeQuery = true,value = "select * from segments where segmentsid=?1")
	List<SegmentsVO> getSegmentsById(Long id);
	
	@Query(nativeQuery = true,value = "select * from segments where orgid=?1")
	List<SegmentsVO> getSegmentsByOrgId(Long orgid);

	boolean existsBySegmentDescriptionAndOrgId(String segmentDescription, Long orgId);

	boolean existsBySegmentNameAndOrgId(String segmentName, Long orgId);

}
