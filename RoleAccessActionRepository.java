package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.RoleAccessAction;



@Repository
@Transactional
public interface RoleAccessActionRepository extends JpaRepository<RoleAccessAction, String>{
	@Query("SELECT e FROM RoleAccessAction e WHERE deleted=0")
	List<RoleAccessAction> findAll();

	@Modifying(clearAutomatically = true)
	@Query("UPDATE RoleAccessAction c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
}
