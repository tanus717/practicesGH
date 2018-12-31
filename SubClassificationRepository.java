package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.SubClassification;
import com.es.SpringBootApp.model.path.FourTablePath;



@Repository
@Transactional
public interface SubClassificationRepository extends JpaRepository<SubClassification, Integer> {	
	@Query("SELECT e FROM SubClassification e WHERE e.classification_id = :classification_id and deleted=0")
	List<SubClassification> findByClassificationId(@Param("classification_id") int classification_id);
   
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from SubClassification type1 join  SuperClassification type2 "
			+ "on type1.id=type2.subclassification_id and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Query("SELECT e FROM SubClassification e WHERE deleted=0")
	List<SubClassification> findAll();
	
	@Query("select new com.es.SpringBootApp.model.path.FourTablePath(sub.name,c.name,i.name,ig.name)" + 
			"from IndustryGroup ig " + 
			" join Industry i  on ig.id=i.indusgrp_id " + 
			" join Classification c  on c.industry_id=i.id " + 
			" join SubClassification sub on sub.classification_id =c.id where sub.id=:id" )
	  List<FourTablePath> getHierarchy(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE SubClassification type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE SubClassification type SET type.notification = 1 WHERE type.id = :id")
    int updateNotification(@Param("id") int id);
	
	@Query("SELECT e FROM SubClassification e WHERE e.name like %:name% and deleted=0")
	List<SubClassification> findByName(@Param("name") String name);
	
}
