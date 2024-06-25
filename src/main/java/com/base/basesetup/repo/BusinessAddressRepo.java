package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.BusinessAddressVO;
import com.base.basesetup.entity.GstInVO;

@Repository
public interface BusinessAddressRepo extends JpaRepository<BusinessAddressVO, Long>{

	List<BusinessAddressVO> findByGstInVO(GstInVO gstInVO);
       
}
