package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.AdvanceCanSIVO;

@Repository
public interface AdvanceCanSIRepo extends JpaRepository<AdvanceCanSIVO, Long>{

	@Query(nativeQuery = true,value = "select * from ef_scaninvoicehdr where ef_scaninvoicehdrid=?1")
	List<AdvanceCanSIVO> findAdvanceCanSIById(Long id);

	@Query(nativeQuery = true,value = "select * from ef_scaninvoicehdr where orgid=?1")
	List<AdvanceCanSIVO> findAdvanceCanSIByOrgId(Long orgid);

	@Query(nativeQuery = true, value = "select sequence_value from ef_scaninvoicehdr_docidseqs")
	int finddocid();

	@Query(nativeQuery = true, value = "CALL next_sequence_advancecansi_value()")
	void getbydocsid();

}
