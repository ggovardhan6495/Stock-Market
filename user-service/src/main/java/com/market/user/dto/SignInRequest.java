package com.market.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {
	private String userName;
	private String password;
}
