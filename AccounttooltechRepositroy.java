package com.es.SpringBootApp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.Accounttooltech;
import com.es.SpringBootApp.model.path.ToolTechAccount;


@Repository
@Transactional
public interface AccounttooltechRepositroy extends JpaRepository<Accounttooltech, Integer>{
	@Query("SELECT e FROM Accounttooltech e WHERE deleted=0")
	List<Accounttooltech> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Accounttooltech c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
	
	@Query("Select new com.es.SpringBootApp.model.path.ToolTechAccount(acc.id,s.tooltechid,acc.name,s.tooltechname,s.id)  "
			+ " from HitechAccounts acc join Accounttooltech s "
			+ " on acc.id=s.accountid  "
			+ "  and acc.deleted=0 and s.deleted=0"
			+ "and acc.id=:id")
     	List<ToolTechAccount> getRelation(@Param("id") String id);
}