package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PreAlertSIVO;
import com.base.basesetup.entity.VesselDetailsSIVO;

@Repository
public interface VesselDetailsSIRepo extends JpaRepository<VesselDetailsSIVO, Long>{

	List<VesselDetailsSIVO> findByPreAlertSIVO(PreAlertSIVO preAlertSIVO);

}
