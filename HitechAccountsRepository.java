package com.es.SpringBootApp.repository;
import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.HitechAccounts;
import com.es.SpringBootApp.model.path.TwoTablePath;




@Repository
@Transactional
public interface HitechAccountsRepository  extends PagingAndSortingRepository<HitechAccounts, Integer>{

	@Query("SELECT  e  FROM HitechAccounts e WHERE deleted=0")
	List<HitechAccounts> findAll();
	
	
	@Query("SELECT e FROM HitechAccounts e WHERE e.name  like %:name% and deleted=0")
	List<HitechAccounts> findByName(@Param("name") String name);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE HitechAccounts type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("Select  new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))" + 
			"from HitechAccounts type1" + 
			" join AccIndRel type2 on type2.account_id=type1.id" + 
			" join Industry type3 on type2.industry_id=type3.id" + 
			" where type2.isdeleted=0 " + 
			" and type1.deleted=0" +
			" group  by type1.id,type1.name")
	      List<CountModel> getLIst();

	@Query("Select  new com.es.SpringBootApp.model.path.TwoTablePath(type3.name,type1.name)" + 
			"from HitechAccounts type1" + 
			" join AccIndRel type2 on type2.account_id=type1.id" + 
			" join Industry type3 on type2.industry_id=type3.id" + 
			" where type2.isdeleted=0 " + 
			" and type1.deleted=0" +
			" and type2.account_id= :id")
	  List<TwoTablePath> getHierarchy(@Param("id") String id);
	

}
