package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.AccountOrgStructure;


@Repository
@Transactional
public interface AccountOrgStructureRepository extends JpaRepository<AccountOrgStructure, Integer>{
	
	@Query("SELECT e FROM AccountOrgStructure e WHERE e.accountid = :accountid and deleted=0")
	List<AccountOrgStructure> findByAccountid(@Param("accountid")String accountid);
	
	@Query("SELECT e FROM AccountOrgStructure e WHERE deleted=0")
	List<AccountOrgStructure> findAll();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE AccountOrgStructure type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
}
