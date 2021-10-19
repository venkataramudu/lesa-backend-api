package com.dyuga.lesa.enums;

public enum UserRole {

	USER("USER"), ADMIN("ADMIN");
	
	String val;
	
	private UserRole(String role) {
		this.val=role;
	}
}
