package com.market.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponse extends BaseResponseVo {
	private String accessToken;
	private String tokenType;
}
