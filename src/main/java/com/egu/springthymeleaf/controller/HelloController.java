package com.egu.springthymeleaf.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egu.springthymeleaf.entity.UserInfo;

/**
 * Helloリソースに関するコントローラです。
 * @author t-eguchi
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	/** GETメソッド対応 */
	@GetMapping
	public String get(Model model) {
		// セッション情報よりユーザを取得
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = null;
		if (principal instanceof UserInfo) {
			UserInfo userInfo = (UserInfo)principal;
			username = userInfo.getUsername();
		} else if (principal instanceof LdapUserDetails) {
			LdapUserDetails userDetails = (LdapUserDetails)principal;
			username = userDetails.getUsername();
		} else {
			username = "anonymous";
//			throw new IllegalStateException(
//					"Illegal principal type. principal = " + principal);
		}

		// 描画
		model.addAttribute("name", username);
        return "hello";
	}
}
