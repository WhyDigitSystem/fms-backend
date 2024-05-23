package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.BusinessAddressVO;

@Repository
public interface BusinessAddressRepo extends JpaRepository<BusinessAddressVO, Long>{
       
}
