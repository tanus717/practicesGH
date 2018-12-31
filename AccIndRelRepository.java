package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.AccIndRel;
import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.path.AccountIndustry;

@Repository
@Transactional
public interface AccIndRelRepository extends JpaRepository<AccIndRel, Integer> {
	@Query("SELECT e FROM AccIndRel e WHERE e.account_id = :account_id and isdeleted=0")
	List<AccIndRel> findByAccountId(@Param("account_id") String account_id);

	@Query("SELECT e FROM AccIndRel e WHERE e.industry_id = :industry_id and isdeleted=0")
	List<AccIndRel> findByIndustryId(@Param("industry_id") int industry_id);

	@Query("SELECT e FROM AccIndRel e WHERE isdeleted=0")
	List<AccIndRel> findAll();

	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ " from Industry type1 join AccIndRel type2 "
			+ " on type1.id=type2.industry_id and type2.isdeleted=0 and type1.deleted=0"
			+ " group  by type1.id,type1.name")
	List<CountModel> getLIst();

	@Modifying(clearAutomatically = true)
	@Query("UPDATE AccIndRel type SET type.isdeleted = 1 WHERE type.id = :id")
	int updateDeleted(@Param("id") int id);
	
	
	@Query("Select new com.es.SpringBootApp.model.path.AccountIndustry(accind.id,ind.id,accind.name,ind.name)  "
			+ " from HitechAccounts accind join AccIndRel acc "
			+ " on accind.id=acc.account_id join Industry ind on ind.id=acc.industry_id  and acc.isdeleted=0 and accind.deleted=0 "
			+ "and accind.id=:id")
	List<AccountIndustry> getRelation(@Param("id") String id);
	
	
	
	
}
