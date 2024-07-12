package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.HouseParticularsSIVO;
import com.base.basesetup.entity.PreAlertSIVO;
@Repository
public interface HouseParticularsSIRepo extends JpaRepository<HouseParticularsSIVO, Long> {

	List<HouseParticularsSIVO> findByPreAlertSIVO(PreAlertSIVO preAlertSIVO);

}
