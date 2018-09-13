package com.uplinfo.book.ubdata.boot;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uplinfo.book.ubdata.domain.AccountCredentials;
import com.uplinfo.book.ubdata.security.CustomAuthenticationProvider;
import com.uplinfo.book.ubdata.security.DyncSecurityMetadataSource;
import com.uplinfo.book.ubdata.security.JWTAuthenticationFilter;
import com.uplinfo.book.ubdata.security.TokenAuthenticationService;
import com.uplinfo.book.ubdata.security.UserInfoService;
import com.uplinfo.book.ubdata.utils.JSONResult;
import com.uplinfo.book.ubdata.utils.MD5Util;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private DyncSecurityMetadataSource dyncSecurityMetadataSource;

	// 设置 HTTP 验证规则
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 关闭csrf验证
		http.csrf().disable()
				// 对请求进行认证
				.authorizeRequests()
				// 所有 / 的所有请求 都放行
				.antMatchers("/").permitAll()
				// 所有 /login 的POST请求 都放行
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				// 添加权限检测
				//.antMatchers("/hello").hasAuthority("AUTH_WRITE")
				// 角色检测
				//.antMatchers("/world").hasRole("ADMIN")
				// 所有请求需要身份认证
				.anyRequest().authenticated()
				.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
					public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
						fsi.setSecurityMetadataSource(dyncSecurityMetadataSource);
						fsi.setAccessDecisionManager(accessDecisionManager);
						return fsi;
					}
				}).and()
				// 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// 添加一个过滤器验证其他请求的Token是否合法
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 使用自定义身份验证组件
		// auth.authenticationProvider(customAuthenticationProvider);
		//auth.userDetailsService(userInfoService);
		auth.authenticationProvider(authenticationProvider());

	}
	
	@Bean
	public AuthenticationProvider authenticationProvider(){
	    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	    authenticationProvider.setUserDetailsService(userInfoService);
	    authenticationProvider.setPasswordEncoder(new Md5PasswordEncoder());
	    //authenticationProvider.setPasswordEncoder(passwordEncoder());
	    return authenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new PasswordEncoder(){

			@Override
			public String encode(CharSequence rawPassword) {
				return MD5Util.encode((String)rawPassword);
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				//System.out.println(encode(rawPassword));
				//System.out.println(encodedPassword);
				return encodedPassword.equals(MD5Util.encode((String)rawPassword));
			}

				    	
	    };
	}
	/**
	 * 
	 */
	private AccessDecisionManager accessDecisionManager = new AccessDecisionManager(){

		@Override
		public void decide(Authentication authentication, Object object,
				Collection<ConfigAttribute> configAttributes)
				throws AccessDeniedException, InsufficientAuthenticationException {
			if (CollectionUtils.isEmpty(configAttributes)) {
	            throw new AccessDeniedException("not allow");
	        }
			
			FilterInvocation fi = (FilterInvocation) object;
			//System.out.println(fi.getHttpRequest().getMethod());
	        Iterator<ConfigAttribute> ite = configAttributes.iterator();
	        while (ite.hasNext()) {
	            ConfigAttribute ca = ite.next();
	            String needRole = ((org.springframework.security.access.SecurityConfig) ca).getAttribute();
	            for (GrantedAuthority ga : authentication.getAuthorities()) {
	                if(ga.getAuthority().equals(needRole)){
	                    //匹配到有对应角色,则允许通过
	                    return;
	                }
	            }
	        }
	        //该url有配置权限,但是当然登录用户没有匹配到对应权限,则禁止访问
	        throw new AccessDeniedException("not allow " + authentication.getAuthorities());
			
		}

		@Override
		public boolean supports(ConfigAttribute attribute) {
			return true;
		}

		@Override
		public boolean supports(Class<?> clazz) {
			return true;
		}
		
	};

}

class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	@SuppressWarnings("deprecation")
	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {

		// JSON反序列化成 AccountCredentials
		AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);

		// 返回一个验证令牌
		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		TokenAuthenticationService.addAuthentication(res, auth);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getOutputStream()
				.println(JSONResult.fillResultString(500, "Internal Server Error!", JSONObject.NULL));
	}
}
