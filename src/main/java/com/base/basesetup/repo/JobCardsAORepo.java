package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.JobCardAOVO;

@Repository
public interface JobCardsAORepo extends JpaRepository<JobCardAOVO, Long>{

	JobCardAOVO findByJobNo(String string);

	JobCardAOVO findByOrdNo(String docId);

}
