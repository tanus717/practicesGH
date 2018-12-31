package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.Tooltech;

@Repository
@Transactional
public interface TooltechRepository extends JpaRepository<Tooltech, String>{
	@Query("SELECT e FROM Tooltech e WHERE deleted=0")
	List<Tooltech> findAll();

	@Modifying(clearAutomatically = true)
    @Query("UPDATE Tooltech type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.tooltechname,COUNT(type1.tooltechid))  "
			+ "from Accounttooltech type1 join  Tooltech type2 "
			+ "on type1.tooltechid=type2.id and type1.deleted=0 and type2.deleted=0" + "group  by type1.tooltechid,type1.tooltechname")
	List<CountModel> getLIst();
	
	
}
