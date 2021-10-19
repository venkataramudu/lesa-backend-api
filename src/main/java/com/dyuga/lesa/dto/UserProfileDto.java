package com.dyuga.lesa.dto;


import lombok.Data;

@Data
public class UserProfileDto {
	private Long id;
	
	private Long buId;
	
	private String name;
	
	private String mobile;
	
	private String email;
	
	private boolean active;
	
	private UserAddressDto defaultAddress;

}
