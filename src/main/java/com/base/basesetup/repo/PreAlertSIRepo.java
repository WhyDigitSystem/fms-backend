package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PreAlertSIVO;

@Repository
public interface PreAlertSIRepo extends JpaRepository<PreAlertSIVO, Long> {

	@Query(nativeQuery = true, value = "select * from ef_siord_hdr where ef_siord_hdrid=?1")
	List<PreAlertSIVO> findPreAlertById(Long id);

	@Query(nativeQuery = true, value = "select * from ef_siord_hdr where orgid=?1")
	List<PreAlertSIVO> findPreAlertByOrgId(Long orgid);

}
