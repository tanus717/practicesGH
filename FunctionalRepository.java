package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.Functional;
import com.es.SpringBootApp.model.path.TwoTablePath;


@Repository
@Transactional
public interface FunctionalRepository extends JpaRepository<Functional, Integer>{
	@Query("SELECT e FROM Functional e WHERE e.functiongroupid = :functiongroupid and deleted=0")
	List<Functional> findByFunctiongroupid(@Param("functiongroupid")int functiongroupid);
	
	@Query("SELECT e FROM Functional e WHERE deleted=0")
	List<Functional> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from Functional type1 join  SubFunctional type2 "
			+ "on type1.id=type2.functionalid and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Query("select new com.es.SpringBootApp.model.path.TwoTablePath(f.name,fg.name)" + 
			"from FunctionGroup fg " + 
			" join Functional f  on fg.id=f.functiongroupid where f.id=:id" )
	  List<TwoTablePath> getHierarchy(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Functional type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("SELECT e FROM Functional e WHERE e.name like %:name% and deleted=0")
	List<Functional> findByName(@Param("name") String name);
	
	
	
}