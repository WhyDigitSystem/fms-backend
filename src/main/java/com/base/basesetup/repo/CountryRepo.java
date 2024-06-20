package com.base.basesetup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.CountryVO;

@Repository
public interface CountryRepo extends JpaRepository<CountryVO, Long> {

	@Query(nativeQuery = true,value = "select * from country where countryid=?1")
	List<CountryVO> findCountryById(Long id);

	@Query(nativeQuery = true,value = "select * from country where Orgid=?1")
	List<CountryVO> findCountryByOrgId(Long orgid);

	boolean existsByCountryNameAndOrgId(String country, Long orgId);

	boolean existsByCountryCodeAndOrgId(String countryCode, Long orgId);

}
