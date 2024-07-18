package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.AdvanceCanSIVO;
import com.base.basesetup.entity.ChargeParticularSIVO;

@Repository
public interface ChargeParticularSIRepo extends JpaRepository<ChargeParticularSIVO, Long>{

	List<ChargeParticularSIVO> findByAdvanceCanSIVO(AdvanceCanSIVO advanceCanSIVO);

}
