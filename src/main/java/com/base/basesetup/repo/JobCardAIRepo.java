package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.JobCardAIVO;

@Repository
public interface JobCardAIRepo extends JpaRepository<JobCardAIVO, Long>{

}
