package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.ModuleList;

@Repository
@Transactional
public interface ModuleListRepository extends JpaRepository<ModuleList, Integer> {
	@Query("SELECT e FROM ModuleList e WHERE deleted=0")
	List<ModuleList> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE ModuleList c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
}
