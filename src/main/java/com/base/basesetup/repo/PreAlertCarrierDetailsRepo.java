package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PreAlertCarrierDetailsVO;
import com.base.basesetup.entity.PreAlertVO;

@Repository
public interface PreAlertCarrierDetailsRepo extends JpaRepository<PreAlertCarrierDetailsVO, Long> {

	List<PreAlertCarrierDetailsVO> findByPreAlertVO(PreAlertVO preAlertVO);

}


