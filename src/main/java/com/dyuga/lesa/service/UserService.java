package com.dyuga.lesa.service;

import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyuga.lesa.dto.UserAddressDto;
import com.dyuga.lesa.dto.UserProfileDto;
import com.dyuga.lesa.entity.Product;
import com.dyuga.lesa.entity.UserAddress;
import com.dyuga.lesa.entity.UserProfile;
import com.dyuga.lesa.repo.UserAddressRepository;
import com.dyuga.lesa.repo.UserProfileRepository;
import com.dyuga.lesa.util.MapperUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserProfileRepository usrProfileRepo;
	
	@Autowired
	private UserAddressRepository usrAddressRepo;
	
	@Autowired
	private MapperUtil maprUtil;

	public Optional<UserProfileDto> getUserProfileBy(Long buId, String mobile, int active) {
		
		return Optional.ofNullable(
				usrProfileRepo.findByBuIdAndMobileAndIsActive(buId, mobile, active)
				.map(maprUtil::convertToDto)
				.orElse(null)
				);
	}
	public Optional<UserProfileDto> getUserProfileById(Long userId) {
	
		return Optional.ofNullable(
				usrProfileRepo.findById(userId)
				.map(maprUtil::convertToDto)
				.orElse(null)
				);
	}
	
	public Optional<UserAddressDto> getUserDefaultAddress(Long userId) {
		
		return Optional.ofNullable(
				usrAddressRepo.findByUser_idAndIsDefault(userId, 1)
				.map(maprUtil::convertToDto)
				.orElse(null)
				);
	}
	public void saveOrUpdate(UserProfile upd) {
		// TODO Auto-generated method stub
		usrProfileRepo.save(upd);
	}
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		usrAddressRepo.deleteById(userId);
		usrProfileRepo.deleteById(userId);
		
	}
}