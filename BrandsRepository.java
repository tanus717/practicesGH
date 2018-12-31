package com.es.SpringBootApp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.Brands;
import com.es.SpringBootApp.model.path.BrandProduct;


@Repository
@Transactional
public interface BrandsRepository extends JpaRepository<Brands, Integer>{
	
	@Query("SELECT e FROM Brands e WHERE e.brand_name like %:brand_name% and deleted=0")
	List<Brands> findByBrandName(@Param("brand_name")String brand_name);
	
	@Query("SELECT e FROM Brands e WHERE deleted=0")
	List<Brands> findAll();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Brands type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("Select new com.es.SpringBootApp.model.path.BrandProduct(pb.id,b.id,p.id,p.product_name,b.brand_name)  "
			+ "from ProductBrand as  pb join Brands as b   on pb.brand_id=b.id" + 
			"	join Products as p on pb.product_id=p.id  and p.deleted=0 and b.deleted=0 "
			+ "and b.id=:id")
	List<BrandProduct> getRelation(@Param("id") int id);
	
	@Query("SELECT e FROM Brands e WHERE e.brand_name = :brand_name and deleted=0")
	List<Brands> findByName(@Param("brand_name") String brand_name);
}
