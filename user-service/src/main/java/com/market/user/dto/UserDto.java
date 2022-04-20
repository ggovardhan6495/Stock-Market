package com.market.user.dto;

import java.util.Set;

import com.market.user.entity.Role;

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
