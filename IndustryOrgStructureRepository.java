package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.IndustryOrgStructure;


@Repository
@Transactional
public interface IndustryOrgStructureRepository extends JpaRepository<IndustryOrgStructure, Integer>{
	
	@Query("SELECT e FROM IndustryOrgStructure e WHERE e.accountid = :accountid and deleted=0")
	List<IndustryOrgStructure> findByAccountid(@Param("accountid")String accountid);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE IndustryOrgStructure type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("SELECT e FROM IndustryOrgStructure e WHERE deleted=0")
	List<IndustryOrgStructure> findAll();
	
	
	
}
