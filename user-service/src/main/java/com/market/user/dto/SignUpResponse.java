package com.market.user.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponse extends BaseResponseVo {
	private String userName;
	private String eamil;
	private List<String> roles;
}
