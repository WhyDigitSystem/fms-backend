package com.base.basesetup.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.basesetup.entity.DocumentTypeVO;
import com.base.basesetup.entity.SubTypesVO;

@Repository
public interface SubTypesRepo extends JpaRepository<SubTypesVO, Long>{



	List<SubTypesVO> findByDocumentTypeVO(DocumentTypeVO documentTypeVO);

	void deleteAllById(Optional<SubTypesVO> subtypes);




}
