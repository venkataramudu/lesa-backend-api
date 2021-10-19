package com.dyuga.lesa.repo;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dyuga.lesa.dto.ProductCategoryDto;
import com.dyuga.lesa.entity.Product;
import com.dyuga.lesa.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

	public Optional<ProductCategory> findByBuIdAndId(Long buId, long id);
	
	public Optional<ProductCategory> findByBuId(Long buId);

}
