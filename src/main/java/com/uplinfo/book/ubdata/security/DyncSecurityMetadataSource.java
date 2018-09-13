package com.uplinfo.book.ubdata.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

@Component
public class DyncSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private final AntPathMatcher antPathMatcher = new AntPathMatcher();

	private final Map<String, String> urlRoleMap = new HashMap<String, String>() {
		{
			put("/**", "ROLE_Admin");
		}
	};

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation) object;
		String url = fi.getRequestUrl();
		// String httpMethod = fi.getRequest().getMethod();
		for (Map.Entry<String, String> entry : urlRoleMap.entrySet()) {
			if (antPathMatcher.match(entry.getKey(), url)) {
				return SecurityConfig.createList(entry.getValue());
			}
		}
		// 没有匹配到,默认是要登录才能访问
		return SecurityConfig.createList("ROLE_Admin");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
