package com.example.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * クライアントに返却する認証結果クラス
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResult {
	/** ユーザ名*/
	private String userName;
	/** 権限リスト*/
//	private List<String> permissions;
	/** ロール名*/
//	private List<String> roles;
}