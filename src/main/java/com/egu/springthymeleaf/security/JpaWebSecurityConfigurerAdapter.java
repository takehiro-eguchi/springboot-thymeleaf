package com.egu.springthymeleaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 認証・認可設定
		http
			.authorizeRequests().antMatchers("/admin").authenticated()
			.and().anonymous();

		// CSRF対策無効化
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(service)
			.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
}
