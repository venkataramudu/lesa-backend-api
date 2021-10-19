package com.dyuga.lesa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product_category")
@Data
public class ProductCategory extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	
	@Column(name = "image_id")
	private String imageId;
	
	@Column(name = "bu_id")
	private Long buId;
}
