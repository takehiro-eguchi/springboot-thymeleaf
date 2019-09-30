package com.egu.springthymeleaf.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

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
	@NotBlank
	private String name;

	/** メッセージ */
	@NotBlank
	private String message;
}
