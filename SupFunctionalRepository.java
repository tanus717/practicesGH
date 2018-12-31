package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.SupFunctional;
import com.es.SpringBootApp.model.path.FourTablePath;


@Repository
@Transactional
public interface SupFunctionalRepository extends JpaRepository<SupFunctional, Integer>{
	@Query("SELECT e FROM SupFunctional e WHERE e.subfunctionalid = :subfunctionalid and deleted=0")
	List<SupFunctional> findBySubfunctionalid(@Param("subfunctionalid")int subfunctionalid);
	
	@Query("SELECT e FROM SupFunctional e WHERE deleted=0")
	List<SupFunctional> findAll();
	
	@Query("select new com.es.SpringBootApp.model.path.FourTablePath(supf.supfunctionalname,subf.name,f.name,fg.name)" + 
			"from FunctionGroup fg " + 
			" join Functional f  on fg.id=f.functiongroupid " + 
			" join SubFunctional subf  on subf.functionalid=f.id " + 
			" join SupFunctional supf on supf.subfunctionalid =subf.id where supf.id=:id" )
	  List<FourTablePath> getHierarchy(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE SupFunctional type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("SELECT e FROM SupFunctional e WHERE e.supfunctionalname like %:supfunctionalname% and deleted=0")
	List<SupFunctional> findByName(@Param("supfunctionalname") String supfunctionalname);
	
	
	
}

