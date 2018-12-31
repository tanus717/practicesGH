package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.UserRoles;



@Repository
@Transactional
public interface UserRolesRepository extends JpaRepository<UserRoles, String>{
	@Query("SELECT e FROM UserRoles e WHERE deleted=0")
	List<UserRoles> findAll();
	
	@Query("SELECT e FROM UserRoles e WHERE e.roleid = :roleid and deleted=0")
	List<UserRoles> findByRoleId(@Param("roleid") String roleid);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE UserRoles type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
}
