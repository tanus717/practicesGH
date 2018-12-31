package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.Accountprocess;
import com.es.SpringBootApp.model.path.ProcessAccount;

@Repository
@Transactional
public interface AccountprocessRepository extends JpaRepository<Accountprocess, Integer> {

	@Query("SELECT e FROM Accountprocess e WHERE deleted=0")
	List<Accountprocess> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Accountprocess c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
	
	@Query("Select new com.es.SpringBootApp.model.path.ProcessAccount(acc.id,s.processid,acc.name,s.processname,s.id)  "
			+ " from HitechAccounts acc join Accountprocess s "
			+ " on acc.id=s.accountid  "
			+ "  and acc.deleted=0 and s.deleted=0"
			+ "and acc.id=:id")
     	List<ProcessAccount> getRelation(@Param("id") String id);
	
	
	
    }
