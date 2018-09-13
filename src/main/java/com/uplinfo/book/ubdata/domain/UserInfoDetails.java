package com.uplinfo.book.ubdata.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserInfoDetails extends User{

	
	public UserInfoDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
	}
	
	public UserInfoDetails(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, true, true, true, true, authorities);
		
	}

	private static final long serialVersionUID = -8086919156410644496L;

}
