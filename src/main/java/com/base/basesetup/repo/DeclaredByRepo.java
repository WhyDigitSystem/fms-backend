package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DeclaredByVO;
import com.base.basesetup.entity.MasterAirWayBillVO;

@Repository
public interface DeclaredByRepo extends JpaRepository<DeclaredByVO, Long>{


	List<DeclaredByVO> findByMasterAirWayBillVO(MasterAirWayBillVO masterAirWayBillVO);

}
