package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.EventsVO;

@Repository
public interface EventsRepo extends JpaRepository<EventsVO, Long>{

	@Query(nativeQuery = true,value = "select * from events where eventsid=?1")
	List<EventsVO> findEventsById(Long id);

	@Query(nativeQuery = true,value = "select * from events where orgid=?1")
	List<EventsVO> findEventsByOrgId(Long orgid);

}
