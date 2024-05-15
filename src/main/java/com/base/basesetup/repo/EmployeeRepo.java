package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.base.basesetup.entity.EmployeeVO;

public interface EmployeeRepo extends JpaRepository<EmployeeVO, Long>{
	
	@Query(nativeQuery = true, value = "select * from employee where employeeid=?1")
	List<EmployeeVO> getEmployeeById(Long id);

	@Query(nativeQuery = true, value = "select * from employee where orgid=?1")
	List<EmployeeVO> getEmployeeByOrgId(Long orgid);

}
