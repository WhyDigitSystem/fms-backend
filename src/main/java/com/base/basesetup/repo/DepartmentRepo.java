package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.base.basesetup.entity.DepartmentVO;

public interface DepartmentRepo extends JpaRepository<DepartmentVO, Long> {

	@Query(value = "select * from department where departmentid=?1",nativeQuery =true)
	List<DepartmentVO> findDepartmentById(Long id);

	@Query(value = "select * from department where orgId=?1",nativeQuery =true)
	List<DepartmentVO> findDepartmentByOrgId(Long orgId);

	boolean existsByDepartmentAndOrgId(String department, Long orgId);

	boolean existsByDepartmentCodeAndOrgId(String departmentCode, Long orgId);

}
