package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.FunctionGroup;


@Repository
@Transactional
public interface FunctionGroupRepository extends JpaRepository<FunctionGroup, Integer>{

	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from FunctionGroup type1 join Functional type2 "
			+ "on type1.id=type2.functiongroupid and type2.deleted=0  and type1.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Query("SELECT e FROM FunctionGroup e WHERE deleted=0")
	List<FunctionGroup> findAll();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE FunctionGroup type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("SELECT e FROM FunctionGroup e WHERE e.name like %:name% and deleted=0")
	List<FunctionGroup> findByName(@Param("name") String name);
	
}


