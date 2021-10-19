package com.dyuga.lesa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name="user_profile",
	uniqueConstraints = {
			@UniqueConstraint(name = "uk_bu_mobile", columnNames = { "buId", "mobile" })		
	}
)
@Data
public class UserProfile extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="buId")
	private Long buId;
	
	@Column(length = 20, nullable = false)
	private String mobile;
	
	private String email;
	
	private String name;
}

