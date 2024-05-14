package com.base.basesetup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.EventsVO;

@Repository
public interface EventsRepo extends JpaRepository<EventsVO, Long>{

}
