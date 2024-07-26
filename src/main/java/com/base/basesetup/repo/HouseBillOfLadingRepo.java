package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.HouseBillOfLadingVO;

@Repository
public interface HouseBillOfLadingRepo extends JpaRepository<HouseBillOfLadingVO, Long>{

}
