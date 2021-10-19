package com.dyuga.lesa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_address")
@Data
public class UserAddress extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable = false )
	private UserProfile user;
	
	@Column(name = "is_default")
	private int isDefault=0;
	
	@Column(name="city_details" )
	private String contactDetails;
	
	private String type;	
	
	private String landmark;
	
	@Column(name="city_area_id")
	private Long cityAreaId;
}

