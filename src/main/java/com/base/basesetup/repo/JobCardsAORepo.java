package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.JobCardAOVO;
import com.base.basesetup.entity.MasterAirWayBillVO;

@Repository
public interface JobCardsAORepo extends JpaRepository<JobCardAOVO, Long>{

	JobCardAOVO findByJobNo(String string);

	JobCardAOVO findByOrdNo(String docId);

}
