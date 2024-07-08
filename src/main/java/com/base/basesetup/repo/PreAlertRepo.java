package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PreAlertVO;

@Repository
public interface PreAlertRepo extends JpaRepository<PreAlertVO, Long>{

	@Query(nativeQuery = true, value = "select * from ef_aiord_hdr where ef_aiord_hdrid=?1")
	List<PreAlertVO> findPreAlertById(Long id);

	@Query(nativeQuery = true, value = "select * from ef_aiord_hdr where orgid=?1")
	List<PreAlertVO> findPreAlertByOrgId(Long orgid);

}
