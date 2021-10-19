package com.dyuga.lesa.util;

import org.springframework.stereotype.Component;

import com.dyuga.lesa.dto.ProductCategoryDto;
import com.dyuga.lesa.dto.ProductDto;
import com.dyuga.lesa.dto.UserAddressDto;
import com.dyuga.lesa.dto.UserProfileDto;
import com.dyuga.lesa.entity.Product;
import com.dyuga.lesa.entity.ProductCategory;
import com.dyuga.lesa.entity.UserAddress;
import com.dyuga.lesa.entity.UserProfile;

@Component
public class MapperUtil {

	public UserProfileDto convertToDto(UserProfile up) {
		
		UserProfileDto upd = new UserProfileDto();
		upd.setId(up.getId());
		upd.setBuId(up.getBuId());
		upd.setMobile(up.getMobile());
		upd.setEmail(up.getEmail());
		upd.setName(up.getName());
		upd.setActive(up.getIsActive()==1);
		
		return upd;
	}
	
	public UserAddressDto convertToDto(UserAddress ua) {
		
		UserAddressDto uad = new UserAddressDto();
		uad.setId(ua.getId());
		uad.setUserId(ua.getUser().getId());
		uad.setCityAreaId(ua.getCityAreaId());
		uad.setContactDetails(ua.getContactDetails());
		uad.setDefault(ua.getIsDefault()==1);
		uad.setLandmark(ua.getLandmark());
		uad.setType(ua.getType());
		
		return uad ;
	}
	public ProductCategoryDto convertToDto(ProductCategory pc) {
		
		ProductCategoryDto pcd = new ProductCategoryDto();
		pcd.setId(pc.getId());
		pcd.setName(pc.getName());
		pcd.setDescription(pc.getDescription());
		
		return pcd;
	}
	public ProductDto convertToDto(Product pc) {
		
		ProductDto pcd = new ProductDto();
		pcd.setId(pc.getId());
		pcd.setName(pc.getName());
		pcd.setCost(pc.getCost());
		pcd.setDescripation(pc.getDescription());
		
		return pcd;
	}
}