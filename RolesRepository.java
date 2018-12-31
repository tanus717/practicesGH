package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.Roles;
import com.es.SpringBootApp.model.path.RoleAccess;
import com.es.SpringBootApp.model.path.RoleUsers;



@Repository
@Transactional
public interface RolesRepository extends JpaRepository<Roles, String>{
	@Query("SELECT e FROM Roles e WHERE deleted=0")
	List<Roles> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.path.RoleAccess(r.id,r.name,a.create,a.delete,a.view,a.access,a.edit,a.approve,a.reject,a.category,a.id)  "
			+ " from Roles r join RoleAccessAction a "
			+ " on r.id=a.roleid and r.deleted=0 and a.deleted=0 "
			+ " and r.id=:id")
     	List<RoleAccess> getRoleAccess(@Param("id") String id);
	
/*	@Query("Select new com.es.SpringBootApp.model.path.RoleUsers(Roles.name,Roles.id," + 
			"(SELECT " + 
			"STRING_AGG(ur.userid,', ') " + 
			"FROM UserRoles "
			+ "where roleid='sjdbs' ))  "+
			 "from Roles r" + 
			"where Roles.id= :id ")*/
/*	@Query(value= "SELECT new com.es.SpringBootApp.model.path.RoleUsers"
			+ "(ur.roleid,ur.userid,r.name) "
			+ "from UserRoles ur join Roles r "
			+ " on ur.roleid=r.id where r.id =:id ")*/
	
	
	
/*	@Query(value="Select new com.es.SpringBootApp.model.path.RoleUsers(r.name,r.id,(SELECT STUFF("
			+ "( SELECT ',' + userid FROM UserRoles where roleid = r.id FOR XML PATH(''), "
			+ "TYPE ).value('.', 'NVARCHAR(MAX)'),1,1,'')))"
			+ "from Roles r where r.id =:id")*/
	
	@Query(value="SELECT  STUFF(( SELECT ',' + userid FROM UserRoles where roleid = ?1 FOR XML PATH(''),TYPE ).value('.', 'NVARCHAR(MAX)'),1,1,'')",nativeQuery=true)
	String  data(@Param("id")String id);
	
	@Query(value="Select new com.es.SpringBootApp.model.path.RoleUsers(r.id,'',r.name)"
			+ "from Roles r ")
	
/*	@Query(value= "SELECT new com.es.SpringBootApp.model.path.RoleUsers(r.id,r.name,'sdfggfhyhj')  FROM  Roles r  ")*/
     	List<RoleUsers>  getRelation();
	
	
	  @Query(value="Select new com.es.SpringBootApp.model.path.RoleUsers(r.id,'',r.name) from Roles r where id =:id")
     	List<RoleUsers>  getRelation(@Param("id")String id);
	
	
	
	
	@Query("SELECT e FROM Roles e WHERE e.name like %:name% and deleted=0")
	List<Roles> findByName(@Param("name") String name);
	
	
	
	
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Roles c SET c.deleted = 1 WHERE c.id = :id")
	int updateDeleted(@Param("id") int id);
}

