package com.dyuga.lesa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyuga.lesa.entity.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{

	public Optional<UserAddress> findByUser_idAndIsDefault(Long userId, int i);

}