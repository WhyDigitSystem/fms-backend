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

	@Query(nativeQuery = true, value = "CALL next_sequence_value()")
	int getbyeventsid();

	@Query(nativeQuery = true, value = "select sequence_value from eventsidseq")
	int findeventid();

//	@Query(nativeQuery = true, value = "SELECT CONCAT('Ev', LPAD(CAST(SUBSTRING(eventid, 3) AS UNSIGNED) + 1, LENGTH(SUBSTRING(eventid, 3)), '0')) AS next_eventid FROM fms_db.events ORDER BY eventid DESC LIMIT 1")
//	String findLatestEventid();


}

