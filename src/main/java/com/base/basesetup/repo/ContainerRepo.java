package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ContainerVO;

@Repository
public interface ContainerRepo extends JpaRepository<ContainerVO, Long>{

	@Query(nativeQuery = true, value = "select * from container where containerid=?1")
	List<ContainerVO> findContainerById(Long id);

	@Query(nativeQuery = true, value = "select * from container where orgid=?1")
	List<ContainerVO> getContainerByOrgId(Long id);

	boolean existsByCategoryAndOrgId(String category, Long id);

}
