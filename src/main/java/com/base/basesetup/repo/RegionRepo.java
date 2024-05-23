package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.RegionVO;

@Repository
public interface RegionRepo extends JpaRepository<RegionVO, Long>{

	@Query(nativeQuery = true,value = "select * from region where regionid=?1")
	List<RegionVO> getRegionById(Long id);

	@Query(nativeQuery = true,value = "select * from region where orgid=?1")
	List<RegionVO> getRegionByOrgId(Long orgid);

}
