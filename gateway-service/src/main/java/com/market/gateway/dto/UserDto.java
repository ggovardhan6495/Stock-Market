package com.market.gateway.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private String username;
	private String email;
	private String password;
	private Set<Role> role;
}
