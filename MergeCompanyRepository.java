package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.MergeCompany;


@Repository
@Transactional
public interface MergeCompanyRepository extends JpaRepository<MergeCompany, Integer>{	
	@Query("SELECT e FROM MergeCompany e WHERE e.parentcompany_id = :parentcompany_id and deleted=0")
	List<MergeCompany> findByParentcompanyId(@Param("parentcompany_id") String parentcompany_id);

	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from HitechAccounts type1 join  MergeCompany type2 "
			+ "on type1.id=type2.parentcompany_id and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Query("SELECT e FROM MergeCompany e WHERE deleted=0")
	List<MergeCompany> findAll();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE MergeCompany type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	
}
