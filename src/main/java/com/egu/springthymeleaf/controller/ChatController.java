package com.egu.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String get() {
		return "chat";
	}

	@PostMapping
	public String post(@ModelAttribute ChatMessage message) {
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
