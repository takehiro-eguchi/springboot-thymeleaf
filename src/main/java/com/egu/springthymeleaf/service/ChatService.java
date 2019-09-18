package com.egu.springthymeleaf.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.egu.springthymeleaf.entity.ChatMessage;

/**
 * チャットに関わるサービスです。
 * @author t-eguchi
 *
 */
@Service
public class ChatService {

	/** メッセージ一覧 */
	private final List<ChatMessage> messages = new LinkedList<>();

	/**
	 * 追加します。
	 * @param message
	 */
	public void post(ChatMessage message) {
		Date date = new Date();
		message.setDate(date);
		messages.add(message);
	}

	/**
	 * 一覧を取得します。
	 * @return
	 */
	public List<ChatMessage> list() {
		return messages;
	}
}
