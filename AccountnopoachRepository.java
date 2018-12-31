package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.Accountnopoach;
import com.es.SpringBootApp.model.CountModel;


@Repository
@Transactional
public interface AccountnopoachRepository extends JpaRepository<Accountnopoach, Integer> {
	
	@Query("SELECT e FROM Accountnopoach e WHERE e.parentid = :parentid and deleted=0")
	List<Accountnopoach> findByParentid(@Param("parentid")String parentid);
	
	@Query("SELECT e FROM Accountnopoach e WHERE deleted=0")
	List<Accountnopoach> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from HitechAccounts type1 join  Accountnopoach type2 "
			+ "on type1.id=type2.parentid and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Accountnopoach type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("SELECT e FROM Accountnopoach e WHERE e.name like %:name% and deleted=0")
	List<Accountnopoach> findByName(@Param("name") String name);
	
}
