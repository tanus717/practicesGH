package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.SubFunctional;
import com.es.SpringBootApp.model.path.ThreeTablePath;



@Repository
@Transactional
public interface SubFunctionalRepository extends JpaRepository<SubFunctional, Integer>{
	@Query("SELECT e FROM SubFunctional e WHERE e.functionalid = :functionalid and deleted=0")
	List<SubFunctional> findByFunctionalid(@Param("functionalid")int functionalid);
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from SubFunctional type1 join  SupFunctional type2 "
			+ "on type1.id=type2.subfunctionalid and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Query("SELECT e FROM SubFunctional e WHERE deleted=0")
	List<SubFunctional> findAll();
	
	@Query("select new com.es.SpringBootApp.model.path.ThreeTablePath(subf.name,f.name,fg.name)" + 
			"from FunctionGroup fg " + 
			" join Functional f  on fg.id=f.functiongroupid " + 
			" join SubFunctional subf  on subf.functionalid=f.id  where subf.id=:id" )
	  List<ThreeTablePath> getHierarchy(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE SubFunctional type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("SELECT e FROM SubFunctional e WHERE e.name like %:name% and deleted=0")
	List<SubFunctional> findByName(@Param("name") String name);
	
	
	
}
