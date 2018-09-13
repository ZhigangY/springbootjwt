package com.uplinfo.book.ubdata.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uplinfo.book.ubdata.domain.User;
import com.uplinfo.book.ubdata.domain.UserInfoDetails;
import com.uplinfo.book.ubdata.persistence.UserMapper;

@Service
public class UserInfoService implements UserDetailsService {

	private static final String ROLE_PREFIX = "ROLE_";
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
		grantedAuthority.add(new SimpleGrantedAuthority(ROLE_PREFIX
				+ "Admin"));
		User usr = userMapper.getUserByUsername(username);
		UserDetails user = new UserInfoDetails(username,usr.getPassword(),grantedAuthority);
		return user;
	}

}
