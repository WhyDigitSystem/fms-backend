package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.JobCardSIVO;

@Repository
public interface JobCardSIRepo extends JpaRepository<JobCardSIVO, Long>{

}

