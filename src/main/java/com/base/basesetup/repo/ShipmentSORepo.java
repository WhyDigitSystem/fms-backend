package com.base.basesetup.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.ShipmentAOVO;
import com.base.basesetup.entity.ShipmentSOVO;

@Repository
public interface ShipmentSORepo extends JpaRepository<ShipmentSOVO, Long>{

	@Query(nativeQuery = true, value = "select * from t_sesohdr where t_sesohdrid=?1")
	List<ShipmentSOVO> findShipmentSOById(Long id);

	@Query(nativeQuery = true, value = "select * from t_sesohdr where orgid=?1")
	List<ShipmentSOVO> getShipmentSOByOrgId(Long orgId);

	@Query(nativeQuery = true, value = "select sequence_value from t_sesohdr_docsidseq")
	int finddocid();

	@Query(nativeQuery = true, value = "CALL next_sequence_shipmentso_value()")
	void getbydocsid();

	@Query(nativeQuery = true, value = "select * from t_sesohdr where t_sesohdrid=?1")
	List<ShipmentSOVO> getShipmentSOFollowUpById(Long id);

	@Query(nativeQuery = true, value = "select * from t_sesohdr where orgid=?1")
	List<ShipmentSOVO> getShipmentSOFollowUpByOrgId(Long orgId);

	Optional<ShipmentSOVO> findByDocId(String docId);



//	@Query(nativeQuery = true, value = "select * from t_sesohdr where docid=?1")
//	ShipmentSOVO getShipmentSOFollowUpByDocId(String docId);


}
