package com.egu.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("message", "Hello Thymeleaf!!");
        return "hello";
	}
}
