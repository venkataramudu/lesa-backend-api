package com.dyuga.lesa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyuga.lesa.dto.ProductBriefDto;
import com.dyuga.lesa.dto.ProductCategoryDto;
import com.dyuga.lesa.dto.ProductDto;
import com.dyuga.lesa.entity.ProductCategory;
import com.dyuga.lesa.repo.ProductCategoryRepository;
import com.dyuga.lesa.repo.ProductRepository;
import com.dyuga.lesa.util.MapperUtil;

@Service
public class InventoryService {
	
	@Autowired
	private ProductCategoryRepository prdctCtgryRepo;
	
	@Autowired
	private ProductRepository prdctRepo;
	
	@Autowired
	private MapperUtil maprUtil;

	public List<ProductCategoryDto> getProductCategoriesByBU(Long buId){
		
		return prdctCtgryRepo.findByBuId(buId)
			.stream()
			.map(maprUtil::convertToDto).collect(Collectors.toList());
	}
	
	public Optional<ProductCategoryDto> getProductsByCategory(Long buId, Long categoryId){
		
		return Optional.ofNullable(
				prdctCtgryRepo.findByBuIdAndId(buId, categoryId)
				.map(maprUtil::convertToDto)
				.orElse(null)
				);
	}
	public Optional<ProductDto> getProductById(Long buId,Long categoryId, Long productId){
//		return Optional.ofNullable(
//				( prdctRepo.getProductsById(buId, productId))
//				.map(maprUtil::convertToDto)
//				.orElse(null)
//				);
		return null;
	}
//	public List<ProductBriefDto> getProductById(Long buId, Long categoryId){
//		
//		return null;
//	}
}
