package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PartyDetailsOfDirectorsVO;

@Repository
public interface PartyDetailsOfDirectorsRepo extends JpaRepository<PartyDetailsOfDirectorsVO, Long>{

}
