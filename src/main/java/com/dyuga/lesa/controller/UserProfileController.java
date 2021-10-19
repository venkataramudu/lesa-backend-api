package com.dyuga.lesa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyuga.lesa.dto.ProductDto;
import com.dyuga.lesa.dto.UserProfileDto;
import com.dyuga.lesa.entity.UserProfile;
import com.dyuga.lesa.service.UserService;
import com.dyuga.lesa.util.AuthenticationUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
@Api(tags="1", value = "Users API", description = "Users API")
public class UserProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationUtil authUtil;

	@ApiOperation("Get User Profile")
	@GetMapping("/{userId}/profile")
	public ResponseEntity<UserProfileDto> getProfile(
			@PathVariable(required=true) Long userId
			) {
		//if(!authUtil.isCurrentUserAccessToUpdateUserProfile(userId)) {
		if(userId!=2) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		Optional<UserProfileDto> updOp = userService.getUserProfileById(userId);
		
		return updOp.map((upd)->{
			
			    userService.getUserDefaultAddress(upd.getId()).ifPresent(upd::setDefaultAddress);
				
				return ResponseEntity.ok(upd);
			})
			.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping("/create-profile") 
	@PutMapping("/{userId}/edit-profile")
	private String update(@PathVariable(required=false) Long userId,@RequestBody UserProfile upd)   
	{  
		userService.saveOrUpdate(upd);
		return "Updated";  
	} 
	@DeleteMapping("/{userId}/delete")
	private void delete(
			@PathVariable(required=true) Long userId) {
		userService.delete(userId);
	}
	@ApiOperation("Get Next Delivery Details")
	@GetMapping("/{userId}/future-deliveries")
	public ResponseEntity<String> getFutureDeliveries(
			@PathVariable(required=true) String userId
			) {
		return null;
	}
	
}
