package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.base.basesetup.entity.DesignationVO;


public interface DesignationRepo extends JpaRepository<DesignationVO, Long>{

	@Query(value = "select * from designation where designationid=?1",nativeQuery = true)
	List<DesignationVO> findDesignationById(Long id);

	boolean existsByDesignationAndOrgId(String designation, Long orgId);

	@Query(value = "select * from designation where orgid=?1",nativeQuery = true)
	List<DesignationVO> findDesignationByOrgId(Long orgid);
}
