package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.Naukriindustry;
import com.es.SpringBootApp.model.path.IndustryNaukri;

@Repository
@Transactional
public interface NaukriindustryRepository extends JpaRepository<Naukriindustry, Integer> {

	@Query("SELECT e FROM Naukriindustry e WHERE deleted=0")
	List<Naukriindustry> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.path.IndustryNaukri(rel.id,ind.id,n.id,ind.name,n.naukri)  "
			+ " from RelNaukriIndus rel join Industry ind "
			+ " on rel.indus_id=ind.id  "
			+ "join Naukriindustry n  on   rel.naukri_id=n.id  and rel.deleted=0 "
			+ "and ind.id=:id")
     	List<IndustryNaukri> getRelation(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Naukriindustry c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
	
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(ind.name,COUNT(rel.id))  "
			+ " from RelNaukriIndus rel join Industry ind "
			+ " on rel.indus_id=ind.id  "
			+ " join Naukriindustry n  on   rel.naukri_id=n.id  and rel.deleted=0 "
			+ "group  by ind.name")
	                     List<CountModel> getLIst();
    }
