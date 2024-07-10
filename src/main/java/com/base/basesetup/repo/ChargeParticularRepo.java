package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.AdvanceCanAiVO;
import com.base.basesetup.entity.ChargeParticularVO;

@Repository
public interface ChargeParticularRepo extends JpaRepository<ChargeParticularVO, Long> {

	List<ChargeParticularVO> findByAdvanceCanAiVO(AdvanceCanAiVO advanceCanAiVO);

}
