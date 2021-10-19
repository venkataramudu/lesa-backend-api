package com.dyuga.lesa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dyuga.lesa.dto.UserProfileDto;
import com.dyuga.lesa.entity.Product;
import com.dyuga.lesa.entity.UserProfile;


public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
//
	public Optional<UserProfile> findByBuIdAndMobileAndIsActive(Long buId, String mobile, int active);

	//public Optional<UserProfileDto> findByBuIdAndMobileAndIsActive(Long buId, String mobile, int active);
}

