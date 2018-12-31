package com.es.SpringBootApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.AccountBlackList;
import com.es.SpringBootApp.model.CountModel;

@Repository
@Transactional
public interface AccountBlackListRepository extends JpaRepository<AccountBlackList, Integer>{
	@Query("SELECT e FROM AccountBlackList e WHERE e.parentid = :parentid and deleted=0")
	List<AccountBlackList> findByParentid(@Param("parentid") String parentId);
	
	@Query("SELECT e FROM AccountBlackList e WHERE deleted=0")
	List<AccountBlackList> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from HitechAccounts type1 join  AccountBlackList type2 "
			+ "on type1.id=type2.parentid and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.name")
	List<CountModel> getLIst();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE AccountBlackList type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("SELECT e FROM AccountBlackList e WHERE e.name like %:name% and deleted=0")
	List<AccountBlackList> findByName(@Param("name") String name);
}
