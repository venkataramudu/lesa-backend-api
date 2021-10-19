package com.dyuga.lesa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyuga.lesa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Optional<Product> findById(Long id);

}