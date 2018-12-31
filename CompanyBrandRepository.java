package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CompanyBrand;
import com.es.SpringBootApp.model.CountModel;


@Repository
@Transactional
public interface CompanyBrandRepository extends JpaRepository<CompanyBrand, Integer>{	
	@Query("SELECT e FROM CompanyBrand e WHERE e.company_id = :company_id and deleted=0")
	List<CompanyBrand> findByCompanyId(@Param("company_id") String company_id);
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from HitechAccounts type1 join  CompanyBrand type2 "
			+ "on type1.id=type2.company_id and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Query("SELECT e FROM CompanyBrand e WHERE deleted=0")
	List<CompanyBrand> findAll();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE CompanyBrand type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);

}