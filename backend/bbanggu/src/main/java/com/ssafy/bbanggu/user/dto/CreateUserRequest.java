package com.ssafy.bbanggu.user.dto;

import com.ssafy.bbanggu.user.domain.User;

/**
 * 회원가입 요청 DTO
 */
public record RegisterUserRequest(
	String name,
	String email,
	String password,
	String phoneNumber,
	String userType
) {
	public User toEntity() {
		return new User(name, email, password, phoneNumber, userType);
	}
}