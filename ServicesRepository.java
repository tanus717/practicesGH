package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.Services;

@Repository
@Transactional
public interface ServicesRepository extends JpaRepository<Services, String>{
	@Query("SELECT e FROM Services e WHERE deleted=0")
	List<Services> findAll();

	@Modifying(clearAutomatically = true)
    @Query("UPDATE Services type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.servicename,COUNT(type1.id))  "
			+ "from Accountservices type1 join  Services type2 "
			+ "on type1.serviceid=type2.id and type1.deleted=0 and type2.deleted=0" + "group  by type2.id,type1.servicename")
	List<CountModel> getLIst();
	
	
	
}
