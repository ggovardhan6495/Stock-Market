package com.market.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.user.dto.BaseResponseVo;
import com.market.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public BaseResponseVo deleteUser(@RequestParam String username) {
		return userService.deleteUser(username);
	}
}
