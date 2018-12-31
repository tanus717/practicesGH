package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.SuperClassification;
import com.es.SpringBootApp.model.path.FiveTablePath;




@Repository
@Transactional
public interface SuperClassificationRepository extends JpaRepository<SuperClassification, Integer> {	
	
	@Query("select new com.es.SpringBootApp.model.path.FiveTablePath(sup.name, sub.name,c.name,i.name,ig.name)" + 
			"from IndustryGroup ig " + 
			" join Industry i  on ig.id=i.indusgrp_id " + 
			" join Classification c  on c.industry_id=i.id " + 
			" join SubClassification sub on sub.classification_id =c.id" + 
			" join SuperClassification sup on sup.subclassification_id=sub.id where sup.id=:id")
	  List<FiveTablePath> getHierarchy(@Param("id") int id);
	
	@Query("SELECT e FROM SuperClassification e WHERE e.subclassification_id = :subclassification_id and deleted=0")
	List<SuperClassification> findBySubClassificationId(@Param("subclassification_id") int subclassification_id);
   
	@Query("SELECT e FROM SuperClassification e WHERE deleted=0")
	List<SuperClassification> findAll();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE SuperClassification type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE SuperClassification type SET type.notification = 1 WHERE type.id = :id")
    int updateNotifaction(@Param("id") int id);
	
	@Query("SELECT e FROM SuperClassification e WHERE e.name like %:name% and deleted=0")
	List<SuperClassification> findByName(@Param("name") String name);
	
	
}
