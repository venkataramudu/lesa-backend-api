package com.dyuga.lesa.dto;

import lombok.Data;

@Data
public class ProductDto {
	private Long id;

	private Long categoryId;
	
	private String imgUrl;
	
	private String name;
	
	private String currencyType;
	
	private String cost;
	
	private String avilableQuanity;	
	
	private String descripation;
		
}
