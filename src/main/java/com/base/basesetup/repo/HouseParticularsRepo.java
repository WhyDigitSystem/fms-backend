package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.HouseParticularsVO;
import com.base.basesetup.entity.PreAlertVO;

@Repository
public interface HouseParticularsRepo extends JpaRepository<HouseParticularsVO, Long>{

	List<HouseParticularsVO> findByPreAlertVO(PreAlertVO preAlertVO);

}
