package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.AdvanceCanAiVO;

@Repository
public interface AdvanceCanAiRepo extends JpaRepository<AdvanceCanAiVO, Long> {

	@Query(value = "select * from ef_acaninvoicehdr where ef_acaninvoicehdrid=?1",nativeQuery =true)
	List<AdvanceCanAiVO> findAdvanceCanAiById(Long id);

	@Query(value = "select * from ef_acaninvoicehdr where orgid=?1",nativeQuery =true)
	List<AdvanceCanAiVO> findAdvanceCanAiByOrgId(Long orgid);

	@Query(nativeQuery = true, value = "select sequence_value from ef_acaninvoicehdr_docidseqs")
	int finddocid();

	@Query(nativeQuery = true, value = "CALL next_sequence_advancecanai_value()")
	void getbydocsid();


}
