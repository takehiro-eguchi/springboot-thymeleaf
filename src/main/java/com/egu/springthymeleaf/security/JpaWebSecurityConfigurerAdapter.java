package com.egu.springthymeleaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * JPAを用いたセキュリティアダプタです。
 * @author t-eguchi
 *
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
public class JpaWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	/** ユーザーサービス */
	@Autowired
	private UserDetailsService service;

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().anonymous();
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(service)
			.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
}
