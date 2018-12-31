package com.es.SpringBootApp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.RelMonsterIndus;
import com.es.SpringBootApp.model.path.IndustryMonster;


@Repository
@Transactional
public interface RelMonsterIndusRepository extends JpaRepository<RelMonsterIndus, Integer>{
	@Query("SELECT e FROM RelMonsterIndus e WHERE e.deleted=0")
	List<RelMonsterIndus> findAll();
	
	
	@Query("Select new com.es.SpringBootApp.model.path.IndustryMonster(rel.id,ind.id,n.id,ind.name,n.monster)  "
			+ " from RelMonsterIndus rel join Industry ind "
			+ " on rel.indus_id=ind.id  "
			+ "join Monsterindustry n  on   rel.monster_id=n.id  and rel.deleted=0 "
			+ "and ind.id=:id")
     	List<IndustryMonster> getRelation(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE RelMonsterIndus c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
	
	
}