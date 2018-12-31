package com.es.SpringBootApp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.Linkedinindustry;
import com.es.SpringBootApp.model.path.IndustryLinkedin;


@Repository
@Transactional
public interface LinkedinindustryRepository extends JpaRepository<Linkedinindustry, Integer>{
	@Query("SELECT e FROM Linkedinindustry e WHERE deleted=0")
	List<Linkedinindustry> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.path.IndustryLinkedin(rel.id,ind.id,n.id,ind.name,n.linkedin)  "
			+ " from RelLinkedinIndus rel join Industry ind "
			+ " on rel.indus_id=ind.id  "
			+ "join Linkedinindustry n  on   rel.linked_id=n.id  and rel.deleted=0 "
			+ "and ind.id=:id")
     	List<IndustryLinkedin> getRelation(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Linkedinindustry c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
	
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(ind.name,COUNT(rel.id))  "
			+ " from RelLinkedinIndus rel join Industry ind "
			+ " on rel.indus_id=ind.id  "
			+ "  join Linkedinindustry n  on   rel.linked_id=n.id  and rel.deleted=0 "
			+ "group  by ind.name")
	                     List<CountModel> getLIst();
	
	
	
	
}