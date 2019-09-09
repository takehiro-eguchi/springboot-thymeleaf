package com.egu.springthymeleaf.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * セキュリティ設定オブジェクトです。
 * @author t-eguchi
 *
 */
//@EnableWebSecurity
public class LdapWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// ユーザの識別名
		auth.ldapAuthentication()
			.userDnPatterns("uid={0},ou=people")
			.contextSource()
			.url("ldap://ldap.nssys.co.jp/dc=nssys,dc=co,dc=jp");
	}
}
