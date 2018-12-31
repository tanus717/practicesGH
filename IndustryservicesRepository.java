package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.Industryservices;
import com.es.SpringBootApp.model.path.ServiceIndustry;



@Repository
@Transactional
public interface IndustryservicesRepository extends JpaRepository<Industryservices, Integer>{
	@Query("SELECT e FROM Industryservices e WHERE deleted=0")
	List<Industryservices> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Industryservices c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
	
	@Query("Select new com.es.SpringBootApp.model.path.ServiceIndustry(s.id,acc.id,s.serviceid,acc.name,s.servicename)  "
			+ " from Industry acc join Industryservices s "
			+ " on acc.id=s.indus_id  "
			+ "  and acc.deleted=0 and s.deleted=0"
			+ "and acc.id=:id")
     	List<ServiceIndustry> getRelation(@Param("id") int id);
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from Industry type1 join  Industryservices type2 "
			+ "on type1.id=type2.indus_id and type1.deleted=0 and type2.deleted=0" + "group  by type1.id,type1.name")
	List<CountModel> getLIst();
}
