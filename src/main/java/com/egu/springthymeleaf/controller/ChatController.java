package com.egu.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egu.springthymeleaf.entity.ChatMessage;
import com.egu.springthymeleaf.service.ChatService;

/**
 * フォームを制御するコントローラオブジェクトです。
 * @author t-eguchi
 *
 */
@Controller
@RequestMapping("/chat")
public class ChatController {

	/** チャットサービス */
	@Autowired
	private ChatService service;

	@GetMapping
	public String get(@ModelAttribute("message") ChatMessage message, Model model) {
		return "chat";
	}

	@PostMapping
	public String post(
			@Validated @ModelAttribute("message") ChatMessage message,
			BindingResult result,
			Model model) {
		// エラー
		if (result.hasErrors()) {
			return "chat";
		}

		// 登録及びリダイレクト
		service.post(message);
		return "redirect:/chat/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<ChatMessage> messages = service.list();
		model.addAttribute("messages", messages);
		return "chat-list";
	}
}
