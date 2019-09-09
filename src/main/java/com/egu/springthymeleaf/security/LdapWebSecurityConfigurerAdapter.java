package com.egu.springthymeleaf.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * セキュリティ設定オブジェクトです。
 * @author t-eguchi
 *
 */
@EnableWebSecurity
public class LdapWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		System.err.println(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().fullyAuthenticated()
			.and()
		.formLogin();
		System.err.println(http);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// ユーザの識別名
		auth.ldapAuthentication()
			.userDnPatterns("uid={0},ou=people")
			.contextSource()
			.url("ldap://ldap.nssys.co.jp/dc=nssys,dc=co,dc=jp");
		System.err.println(auth);
	}
}
