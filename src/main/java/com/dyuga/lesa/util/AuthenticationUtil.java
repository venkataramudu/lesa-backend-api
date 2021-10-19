package com.dyuga.lesa.util;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.dyuga.lesa.enums.*;

@Component
public class AuthenticationUtil {

	public Long getCurrentUserId() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal==null)return null;
		
		return Long.parseLong(principal.toString());
	}
	
	public boolean isAdminUser() {
		
		Collection<? extends GrantedAuthority> auths = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		return auths.contains(UserRole.ADMIN);
	}
	
	public boolean isCurrentUserAccessToUpdateUserProfile(Long userProfileId) {
		
		return userProfileId.equals(getCurrentUserId()) || isAdminUser();
	}
}