package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.Accountservices;
import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.path.ServiceAccount;


@Repository
@Transactional
public interface AccountservicesRepository extends JpaRepository<Accountservices, Integer>{
	@Query("SELECT e FROM Accountservices e WHERE deleted=0")
	List<Accountservices> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Accountservices c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
	
	@Query("Select new com.es.SpringBootApp.model.path.ServiceAccount(acc.id,s.serviceid,acc.name,s.servicename,s.id)  "
			+ " from HitechAccounts acc join Accountservices s "
			+ " on acc.id=s.accountid  "
			+ "  and acc.deleted=0 and s.deleted=0"
			+ "and acc.id=:id")
     	List<ServiceAccount> getRelation(@Param("id") String id);
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type3.name,COUNT(type3.id)) " + 
			"from Accountservices type1 join  Services type2 " + 
			"on type1.serviceid=type2.id " + 
			"join HitechAccounts type3 on type1.accountid=type3.id " + 
			"and type1.deleted=0 and type2.deleted=0 " + 
			"group  by type3.id,type3.name")
	List<CountModel> getLIst();
	
}
