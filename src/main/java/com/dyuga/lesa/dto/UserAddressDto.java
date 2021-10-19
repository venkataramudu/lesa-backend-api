package com.dyuga.lesa.dto;


import lombok.Data;

@Data
public class UserAddressDto {
	private Long id;

	private Long userId;
	
	private boolean isDefault;
	
	private String contactDetails;
	
	private String type;	
	
	private String landmark;
	
	private Long cityAreaId;
	
}
