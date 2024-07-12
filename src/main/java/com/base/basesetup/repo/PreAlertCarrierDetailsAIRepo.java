package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PreAlertCarrierDetailsAIVO;
import com.base.basesetup.entity.PreAlertAIVO;

@Repository
public interface PreAlertCarrierDetailsAIRepo extends JpaRepository<PreAlertCarrierDetailsAIVO, Long> {

	List<PreAlertCarrierDetailsAIVO> findByPreAlertAIVO(PreAlertAIVO preAlertAIVO);


}


