package com.base.basesetup.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.dto.ScreenVO;

@Repository
public interface ScreenRepo extends JpaRepository<ScreenVO, Long>{

	@Query(nativeQuery = true, value = "select * from screen where screenid=?1")
	List<ScreenVO> findScreenById(Long id);

	@Query(nativeQuery = true, value = "select * from screen where orgid=?1")
	List<ScreenVO> findScreenByOrgId(Long orgid);

	boolean existsByScreenName(String screenName);

	boolean existsByScreenCode(String screenCode);

	@Query(nativeQuery = true, value = "select screenname, screencode from screen where screencode NOT IN (SELECT screencode FROM documenttypes)")
	Set<Object[]> findAllScreenCode();

}
