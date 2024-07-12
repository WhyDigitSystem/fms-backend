package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.HouseParticularsAIVO;
import com.base.basesetup.entity.PreAlertAIVO;

@Repository
public interface HouseParticularsAIRepo extends JpaRepository<HouseParticularsAIVO, Long>{

	List<HouseParticularsAIVO> findByPreAlertAIVO(PreAlertAIVO preAlertAIVO);


}
