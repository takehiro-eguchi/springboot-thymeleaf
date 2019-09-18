package com.egu.springthymeleaf.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * チャットメッセージを表すエンティティです。
 * @author t-eguchi
 *
 */
@Data
public class ChatMessage implements Serializable {

	/** 日付 */
	private Date date;

	/** 名前 */
	private String name;

	/** メッセージ */
	private String message;
}
