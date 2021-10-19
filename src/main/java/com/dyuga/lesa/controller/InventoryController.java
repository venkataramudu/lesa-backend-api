package com.dyuga.lesa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyuga.lesa.config.CommonConfiguration;
import com.dyuga.lesa.dto.ProductCategoryDto;
import com.dyuga.lesa.dto.ProductDto;
import com.dyuga.lesa.dto.UserProfileDto;
import com.dyuga.lesa.service.InventoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

public class InventoryController {

}

@RestController
@Slf4j
@RequestMapping("/api/v1/product-categories")
@Api(tags="3", value = "Inventory API", description = "Inventory API")
class ProductCategoryController {
	
	@Autowired
	private InventoryService invntrySrvc;

	@ApiOperation("Get Product Categories")
	@GetMapping
	public ResponseEntity<List<ProductCategoryDto>> getProductCategories(
			@RequestHeader(name = CommonConfiguration.APP_ID_HTTP_HEADER_NAME, required=true) Long buId
			) {
		
		return ResponseEntity.ok(invntrySrvc.getProductCategoriesByBU(buId));
	}
}

@RestController
@Slf4j
@RequestMapping("/api/v1/products")
@Api(tags="3")
class ProductController {
	
	@Autowired
	private InventoryService invntrySrvc;
	
	@ApiOperation("Get Products by Category")
	@GetMapping("/byCategory/{categoryId}")
	public ResponseEntity<ProductCategoryDto> getProductsByCategory(
			@PathVariable(required=true) Long categoryId
			) {
			Long buId=1L;
			Optional<ProductCategoryDto> updOp = invntrySrvc.getProductsByCategory(buId, categoryId);
			
		
			return (updOp).map((upd)->{
			
	//			invntrySrvc.getUserDefaultAddress(upd.getId()).ifPresent(upd::setDefaultAddress);
				
				return ResponseEntity.ok(upd);
			})
			.orElse(ResponseEntity.notFound().build());	
	}
	
	@ApiOperation("Get Product by Id")
	@GetMapping("/{categoryId}/{productId}")
	public ResponseEntity<ProductDto> getProductById(
			@PathVariable(required=true) Long categoryId,Long productId
			) {
			Long buId=1L;
			Optional<ProductDto> updOp = invntrySrvc.getProductById(buId,categoryId,productId);
			
		
			return (updOp).map((upd)->{
			
//				invntrySrvc.getUserDefaultAddress(upd.getId()).ifPresent(upd::setDefaultAddress);
				
				return ResponseEntity.ok(upd);
			})
			.orElse(ResponseEntity.notFound().build());		
	}
}

