package com.es.SpringBootApp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.RelLinkedinIndus;
import com.es.SpringBootApp.model.path.IndustryLinkedin;


@Repository
@Transactional
public interface RelLinkedinIndusRepository extends JpaRepository<RelLinkedinIndus, Integer>{
	@Query("SELECT e FROM RelLinkedinIndus e WHERE e.deleted=0")
	List<RelLinkedinIndus> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.path.IndustryLinkedin(rel.id,ind.id,n.id,ind.name,n.linkedin)  "
			+ " from RelLinkedinIndus rel join Industry ind "
			+ " on rel.indus_id=ind.id  "
			+ "join Linkedinindustry n  on   rel.linked_id=n.id  and rel.deleted=0 "
			+ "and ind.id=:id")
     	List<IndustryLinkedin> getRelation(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE RelLinkedinIndus c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
}