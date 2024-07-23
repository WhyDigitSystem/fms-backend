package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.PartyChargesExemptionVO;

@Repository
public interface PartyChargesExemptionRepo extends JpaRepository<PartyChargesExemptionVO, Long>{

}
