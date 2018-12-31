package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CurrentCompany;


@Repository
@Transactional
public interface CurrentCompanyRepository extends JpaRepository<CurrentCompany, Integer>{	
	@Query("SELECT e FROM CurrentCompany e WHERE e.company_id = :company_id and deleted=0")
	List<CurrentCompany> findByCompanyId(@Param("company_id") String company_id);
	
	@Query("SELECT e FROM CurrentCompany e WHERE e.present_employer like %:present_employer% and deleted=0")
	List<CurrentCompany> findByPresentEmployer(@Param("present_employer") String present_employer);
	
	
	@Query("SELECT e  FROM CurrentCompany e WHERE deleted=0")
	List<CurrentCompany> findAll();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE CurrentCompany type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
}