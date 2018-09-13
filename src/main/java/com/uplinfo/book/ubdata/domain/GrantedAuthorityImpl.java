package com.uplinfo.book.ubdata.domain;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

	private static final long serialVersionUID = -2510053818314291879L;
	private String authority;

	public GrantedAuthorityImpl(String authority) {
		this.authority = authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}

}
