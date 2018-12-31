package com.es.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.SpringBootApp.model.CountModel;
import com.es.SpringBootApp.model.Products;
import com.es.SpringBootApp.model.path.BrandProduct;



@Repository
@Transactional
public interface ProductsRepository extends JpaRepository<Products, Integer>{	
	@Query("SELECT e FROM Products e WHERE e.indus_id = :indus_id and deleted=0")
	List<Products> findByIndusId(@Param("indus_id") int indus_id);
	
	@Query("SELECT e FROM Products e WHERE deleted=0")
	List<Products> findAll();
	
	@Query("Select new com.es.SpringBootApp.model.CountModel(type1.name,COUNT(type1.id))  "
			+ "from Industry type1 join  Products type2 "
			+ "on type1.id=type2.indus_id and type1.deleted=0 and type2.deleted=0"
			+ "group  by type2.id,type1.name")
	List<CountModel> getLIst();
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Products type SET type.deleted = 1 WHERE type.id = :id")
    int updateDeleted(@Param("id") int id);
	
	@Query("Select new com.es.SpringBootApp.model.path.BrandProduct(pb.id,b.id,p.id,p.product_name,b.brand_name)  "
			+ "from ProductBrand as  pb join Brands as b   on pb.brand_id=b.id" + 
			"	join Products as p on pb.product_id=p.id  and p.deleted=0 and b.deleted=0 "
			+ "and p.id=:id")
	List<BrandProduct> getRelation(@Param("id") int id);
}
