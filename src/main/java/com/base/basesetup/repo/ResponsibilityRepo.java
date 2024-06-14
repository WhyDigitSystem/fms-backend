package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ResponsibilitiesVO;

@Repository
public interface ResponsibilityRepo extends JpaRepository<ResponsibilitiesVO, Long> {

}
