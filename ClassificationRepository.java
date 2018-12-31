package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.Classification;
import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.path.ThreeTablePath;


@Repository
@Transactional
public interface ClassificationRepository extends JpaRepository<Classification, Integer>{	
	
	@Query("SELECT e FROM Classification e WHERE e.industry_id = :industry_id and deleted=0")
	List<Classification> findByIndustryId(@Param("industry_id") int industry_id);
   
	@Query("SELECT e FROM Classification e WHERE deleted=0")
	List<Classification> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from Classification type1 join  SubClassification type2 "
			+ "on type1.id=type2.classification_id and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Query("select new com.es.SpringBootApp.model.path.ThreeTablePath(c.name,i.name,ig.name)" + 
			"from IndustryGroup ig " + 
			" join Industry i  on ig.id=i.indusgrp_id " + 
			" join Classification c  on c.industry_id=i.id where c.id=:id" )
	  List<ThreeTablePath> getHierarchy(@Param("id") int id);

	@Modifying(clearAutomatically = true)
    @Query("UPDATE Classification type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Classification type SET type.notification = 1 WHERE type.id = :id")
    int updateNotification(@Param("id") int id);
	
	@Query("SELECT e FROM Classification e WHERE e.name like %:name% and deleted=0")
	List<Classification> findByName(@Param("name") String name);
	
}
