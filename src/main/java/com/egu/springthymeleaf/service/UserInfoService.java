package com.egu.springthymeleaf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.egu.springthymeleaf.entity.UserInfo;
import com.egu.springthymeleaf.repository.UserInfoRepository;

/**
 * ユーザ情報を扱うサービスです。
 * @author takehiro
 *
 */
@Service
public class UserInfoService implements UserDetailsService {

	/** ユーザーレポジトリ */
	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo info = new UserInfo();
		info.setUsername(username);
		info.setPassword("password");
		repository.save(info);
		Optional<UserInfo> userInfoOpt = repository.findById(username);
		if (userInfoOpt.isPresent()) {
			return userInfoOpt.get();
		}
		throw new UsernameNotFoundException(username + " is not found.");
	}
}
