package com.egu.springthymeleaf.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		if (!(principal instanceof UserInfo)) {
			throw new IllegalStateException(
					"Illegal principal type. principal = " + principal);
		}
		UserInfo userInfo = (UserInfo)principal;

		// 描画
		model.addAttribute("name", userInfo.getUsername());
        return "hello";
	}
}
