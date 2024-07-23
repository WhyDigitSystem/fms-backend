package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PartyMasterVO;

@Repository
public interface PartyMasterRepo extends JpaRepository<PartyMasterVO, Long> {

}
