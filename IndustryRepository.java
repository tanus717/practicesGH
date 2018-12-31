package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.Industry;
import com.es.SpringBootApp.model.path.AccountIndustry;
import com.es.SpringBootApp.model.path.TwoTablePath;

@Repository
@Transactional
public interface IndustryRepository extends JpaRepository<Industry, Integer> {

	@Query("SELECT e FROM Industry e WHERE e.indusgrp_id = :indusgrp_id and deleted=0")
	List<Industry> findByIndusgrpId(@Param("indusgrp_id") int indusgrp_id);

	@Query("SELECT e FROM Industry e WHERE deleted=0")
	List<Industry> findAll();

	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from Industry type1 join  Classification type2 "
			+ "on type1.id=type2.industry_id and type1.deleted=0 and type2.deleted=0" + "group  by type1.id,type1.name")
	List<CountModel> getLIst();

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Industry c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Industry c SET c.notification = 1 WHERE c.id = :id")
	int updateNotification(@Param("id") int id);

	@Query("Select new com.es.SpringBootApp.model.path.TwoTablePath(i.name,ig.name)" + "from IndustryGroup ig "
			+ " join Industry i  on ig.id=i.indusgrp_id where i.id=:id")
	List<TwoTablePath> getHierarchy(@Param("id") int id);

	@Query("Select new com.es.SpringBootApp.model.path.AccountIndustry(accind.id,ind.id,accind.name,ind.name)  "
			+ " from HitechAccounts accind join AccIndRel acc "
			+ " on accind.id=acc.account_id join Industry ind on ind.id=acc.industry_id  and acc.isdeleted=0 and accind.deleted=0 "
			+ "and ind.id=:id")
     	List<AccountIndustry> getRelation(@Param("id") int id);
	
	@Query("SELECT e FROM Industry e WHERE e.name like %:name% and deleted=0")
	List<Industry> findByName(@Param("name") String name);
	
	
}
