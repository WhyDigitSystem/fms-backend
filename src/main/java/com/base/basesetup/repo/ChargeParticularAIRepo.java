package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.AdvanceCanAIVO;
import com.base.basesetup.entity.ChargeParticularAIVO;

@Repository
public interface ChargeParticularAIRepo extends JpaRepository<ChargeParticularAIVO, Long> {

	List<ChargeParticularAIVO> findByAdvanceCanAIVO(AdvanceCanAIVO advanceCanAIVO);


}
