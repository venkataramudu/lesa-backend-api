package com.dyuga.lesa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractEntity {

	@Column(name = "CREATED_D")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
	
	@Column(name = "CREATED_BY")
	protected String createdBy;
	
	@Column(name = "MODIFIED_D")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedDate;
	
	@Column(name = "MODIFIED_BY")
	protected String modifiedBy;
	
	@Column(name = "IS_ACTIVE")
	protected int isActive=1;
}