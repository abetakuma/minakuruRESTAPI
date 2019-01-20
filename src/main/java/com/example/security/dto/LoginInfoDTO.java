package com.example.security.dto;

import lombok.Data;

/**
 * クライアントから渡されるログイン情報
 *
 */
@Data
public class LoginInfoDTO {
	private String email;
	private String password;
}