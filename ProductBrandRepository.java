package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.ProductBrand;



@Repository
@Transactional
public interface ProductBrandRepository extends JpaRepository<ProductBrand, Integer>{	
	@Query("SELECT e FROM ProductBrand e WHERE e.product_id = :product_id and deleted=0")
	List<ProductBrand> findByProductId(@Param("product_id") String product_id);
	
	@Query("SELECT e FROM ProductBrand e WHERE deleted=0")
	List<ProductBrand> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.product_name,COUNT(type1.id))  "
			+ "from Products type1 join  ProductBrand type2 "
			+ "on type1.id=type2.product_id and type1.deleted=0 and type2.deleted=0"
			+ "group  by type1.id,type1.product_name")
	List<CountModel> getLIst();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE ProductBrand type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	
	
	
}
