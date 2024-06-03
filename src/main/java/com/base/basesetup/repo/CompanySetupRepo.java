package com.base.basesetup.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.CompanySetupVO;

@Repository
public interface CompanySetupRepo extends JpaRepository<CompanySetupVO, Long>{

	@Query(nativeQuery = true, value = "select * from companysetup where id=?1")
	Optional<CompanySetupVO> findById(Long id);

}
